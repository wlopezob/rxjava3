package com.callback;

public class EndUser implements Observer{
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  EndUser(String name, SubjectLibrary subject) {
    this.name = name;
    subject.subscribeObserver(this);
  }

  @Override
  public void update(String avail) {
    System.out.println("Hello "+ name+ "!, we are glad to notify you that your book is now "+ avail);
  }
}
