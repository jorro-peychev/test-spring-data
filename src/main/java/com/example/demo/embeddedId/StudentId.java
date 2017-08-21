package com.example.demo.embeddedId;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class StudentId implements Serializable {
  private String name;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }
}
