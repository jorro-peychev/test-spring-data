package com.example.demo.superclass.repository;

import com.example.demo.superclass.domain.Task;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
  List<Task> findAll();
}
