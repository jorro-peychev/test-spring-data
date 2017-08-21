package com.example.demo.oneToManyLAZY;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by georgi.peychev on 8/16/17.
 */
public interface StockRepository extends CrudRepository<Stock, Integer> {
  List<Stock> findAll();
}
