package org.example.model;

public class Employee {
  private Integer id;
  private String name;
  Double salary,rating;

  public Employee(Integer id, String name, Double salary, Double rating) {
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.rating = rating;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", salary=" + salary +
        ", rating=" + rating +
        '}';
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }
}
