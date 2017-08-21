package com.example.demo.oneToManyLAZY;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class StockService {

  private StockRepository stockRepository;
  private StockDailyRecordRepository stockDailyRecordRepository;

  public StockService(StockRepository stockRepository, StockDailyRecordRepository stockDailyRecordRepository) {

    this.stockRepository = stockRepository;
    this.stockDailyRecordRepository = stockDailyRecordRepository;
  }

  public void loadData() {

    Stock stock = new Stock();
    stock.setStockName("PADINI");

    StockDailyRecord stockDailyRecord1 = new StockDailyRecord();
    stockDailyRecord1.setName("R1");
    stockDailyRecord1.setStock(stock);

    StockDailyRecord stockDailyRecord2 = new StockDailyRecord();
    stockDailyRecord2.setName("R2");
    stockDailyRecord2.setStock(stock);

    List<StockDailyRecord> records = new ArrayList<>();
    records.add(stockDailyRecord1);
    records.add(stockDailyRecord2);

    stock.setStockDailyRecords(records);

    stockRepository.save(stock);
    //stockDailyRecordRepository.save(records);
  }

  public List<Stock> getStocks() {

    return stockRepository.findAll();
  }

  public List<StockDailyRecord> getLazy() {

    List<StockDailyRecord> records = new ArrayList<>();
    List<Stock> stocks = stockRepository.findAll();
    for( Stock stock: stocks){
      records.addAll( stock.getStockDailyRecords() );
      System.out.println("=============>getStockDailyRecords=" + stock.getStockDailyRecords());
    }
    return records;
  }
}
