package com.example.demo.superclass.domain;

import javax.persistence.Entity;

@Entity
public class TaskHistory extends com.example.demo.superclass.domain.AbstractBaseTask {
  private String status;

  public String getStatus() {

    return status;
  }

  public void setStatus(String status) {

    this.status = status;
  }
}
