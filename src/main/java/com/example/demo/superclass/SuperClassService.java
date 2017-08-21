package com.example.demo.superclass;

import com.example.demo.superclass.domain.Task;
import com.example.demo.superclass.repository.TaskRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SuperClassService {

  private TaskRepository taskRepository;

  public SuperClassService(TaskRepository taskRepository) {

    this.taskRepository = taskRepository;
  }

  public void loadData(){
    List<Task> taskList = new ArrayList<>();
    Task task1 = new Task();
    task1.setName("t1");
    taskList.add(task1);

    Task task2 = new Task();
    task1.setName("t2");
    taskList.add(task2);

    taskRepository.save(taskList);
  }

  public List<Task> findAllTasks(){
    return taskRepository.findAll();
  }
}
