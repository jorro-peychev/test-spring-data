package com.example.demo.superclass.domain;

import javax.persistence.Entity;

@Entity
public class Task extends com.example.demo.superclass.domain.AbstractBaseTask {
  private String name;

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String toString() {

    return "Task{" +
        "name='" + name + '\'' +
        ", id=" + id +
        '}';
  }
}
