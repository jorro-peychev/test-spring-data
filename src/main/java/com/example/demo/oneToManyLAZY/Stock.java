package com.example.demo.oneToManyLAZY;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock"/*, catalog = "mkyongdb"*/, uniqueConstraints = {
    @UniqueConstraint(columnNames = "STOCK_NAME") })
public class Stock implements java.io.Serializable {

  private Integer stockId;
  private String stockName;
  private List<StockDailyRecord> stockDailyRecords = new ArrayList<>(
      0);

  public Stock() {
  }

  @Id
  @GeneratedValue(strategy = AUTO)
  @Column(name = "STOCK_ID", unique = true, nullable = false)
  public Integer getStockId() {
    return this.stockId;
  }

  public void setStockId(Integer stockId) {
    this.stockId = stockId;
  }


  @Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
  public String getStockName() {
    return this.stockName;
  }

  public void setStockName(String stockName) {
    this.stockName = stockName;
  }


  @OneToMany(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
  public List<StockDailyRecord> getStockDailyRecords() {
    return this.stockDailyRecords;
  }

  public void setStockDailyRecords(List<StockDailyRecord> stockDailyRecords) {
    this.stockDailyRecords = stockDailyRecords;
  }

  @Override
  public String toString(){
    return stockId + "-" + stockName + "; " ;
  }
}