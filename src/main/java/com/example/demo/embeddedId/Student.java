package com.example.demo.embeddedId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Student {

  @EmbeddedId
  private StudentId studentId;

  public StudentId getStudentId() {

    return studentId;
  }

  public void setStudentId(StudentId studentId) {

    this.studentId = studentId;
  }
}
