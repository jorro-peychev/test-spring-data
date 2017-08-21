package com.example.demo.superclass.repository;

import com.example.demo.superclass.domain.TaskHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskHistoryRepository extends CrudRepository<TaskHistory, Integer> {

}
