package com.example.demo.superclass.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractBaseTask {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Integer id;

  public Integer getId() {

    return id;
  }

  public void setId(Integer id) {

    this.id = id;
  }
}