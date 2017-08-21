package com.example.demo.oneToManyLAZY;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by georgi.peychev on 8/17/17.
 */
public interface StockDailyRecordRepository extends CrudRepository<StockDailyRecord, Integer> {

}
