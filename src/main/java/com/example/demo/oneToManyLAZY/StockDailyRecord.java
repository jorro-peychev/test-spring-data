package com.example.demo.oneToManyLAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock_daily_record"/*, catalog = "mkyongdb",
    uniqueConstraints = @UniqueConstraint(columnNames = "DATE")*/)
public class StockDailyRecord implements java.io.Serializable {

  private Integer recordId;
  private Stock stock;
  private Long volume;
  private String name;

  public StockDailyRecord() {
  }

  public StockDailyRecord(Stock stock) {
    this.stock = stock;
  }

  public StockDailyRecord(Stock stock, Float priceOpen, Float priceClose,
                          Float priceChange, Long volume) {
    this.stock = stock;
    this.volume = volume;
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "RECORD_ID", unique = true, nullable = false)
  public Integer getRecordId() {
    return this.recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "STOCK_ID", nullable = false)
  public Stock getStock() {
    return this.stock;
  }

  public void setStock(Stock stock) {
    this.stock = stock;
  }

  @Column(name = "VOLUME")
  public Long getVolume() {
    return this.volume;
  }

  public void setVolume(Long volume) {
    this.volume = volume;
  }


  public String toString(){
    return recordId+ "-" + name + "; ";
  }

  @Column(name = "NAME")
  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }
}
