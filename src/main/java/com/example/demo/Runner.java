package com.example.demo;

import com.example.demo.embeddedTable.employeeAddress.EmbeddedEmployeeAddress;
import com.example.demo.manyToMany.ManyToManyService;
import com.example.demo.oneToManyEAGER.BookCategory;
import com.example.demo.oneToManyEAGER.BookService;
import com.example.demo.oneToManyLAZY.Stock;
import com.example.demo.oneToManyLAZY.StockService;
import com.example.demo.oneToOne.OneToOneService;
import com.example.demo.superclass.SuperClassService;
import java.util.List;
import org.hibernate.LazyInitializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

  private StockService stockService;

  @Autowired
  private BookService bookService;
  private SuperClassService superClassService;
  private EmbeddedEmployeeAddress embeddedEmployeeAddress;
  private ManyToManyService manyToManyService;
  private OneToOneService oneToOneService;

  public Runner(StockService stockService, SuperClassService superClassService,
                EmbeddedEmployeeAddress embeddedEmployeeAddress, ManyToManyService manyToManyService, OneToOneService oneToOneService) {

    this.stockService = stockService;
    this.superClassService = superClassService;
    this.embeddedEmployeeAddress = embeddedEmployeeAddress;
    this.manyToManyService = manyToManyService;
    this.oneToOneService = oneToOneService;
  }

  @Override
  public void run(String... args) throws Exception {

    oneToManyLazy();
    oneToManyEager();
    superClassTest();
    embeddedTableTest();
    manyToMany();
    oneToOne();

//    embeddedIdTest();
  }

  private void oneToManyLazy() throws Exception {

    stockService.loadData();
    List<Stock> stocks = stockService.getStocks();
    System.out.println("=========> [" + stocks + "]");

    for (Stock stock : stocks) {
      try {
        System.out.println("Try to get lazy collection [" + stock.getStockDailyRecords() + "]");
      }
      catch (LazyInitializationException exception) {
        System.out.println("==============> LazyInitializationException because it is not in transaction.");
      }
      System.out.println("Get lazy collection [" + stockService.getLazy() + "]");
    }
  }

  private void oneToManyEager() throws Exception {

    bookService.loadBooks();

    // fetch all categories
    for (BookCategory bookCategory : bookService.findAllBooks()) {
      LOGGER.info(bookCategory.toString());
    }

    LOGGER.info("========================");
    bookService.deleteCategory();

    // fetch all categories
    for (BookCategory bookCategory : bookService.findAllBooks()) {
      LOGGER.info(bookCategory.toString());
    }
  }

  private void superClassTest() {

    superClassService.loadData();
    LOGGER.info("" + superClassService.findAllTasks());
  }

  private void embeddedIdTest() {
    // TODO
  }

  private void embeddedTableTest() {

    embeddedEmployeeAddress.loadData();
    LOGGER.info("" + embeddedEmployeeAddress.findAllEmployees());
  }

  private void manyToMany() {
    manyToManyService.test();
  }

  private void oneToOne() {
    oneToOneService.test();
  }
}
