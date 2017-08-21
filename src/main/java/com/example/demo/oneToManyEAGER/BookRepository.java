package com.example.demo.oneToManyEAGER;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by georgi.peychev on 8/21/17.
 */
public interface BookRepository extends CrudRepository<Book, Integer> {

}
