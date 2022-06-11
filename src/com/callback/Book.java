package com.callback;

import java.util.ArrayList;

public class Book  implements SubjectLibrary{
  private String name;
  private String type;
  private String author;
  private double price;
  private String inStock;
  private ArrayList<Observer> obsList = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getInStock() {
    return inStock;
  }

  public void setInStock(String inStock) {
    this.inStock = inStock;
    System.out.println("Availability changed from sold out back in stock");
    notifyObserver();
  }

  public ArrayList<Observer> getObsList() {
    return obsList;
  }

  public void setObsList(ArrayList<Observer> obsList) {
    this.obsList = obsList;
  }

  public Book(String name, String type, String author, double price, String inStock) {
    this.name = name;
    this.type = type;
    this.author = author;
    this.price = price;
    this.inStock = inStock;
  }

  @Override
  public void subscribeObserver(Observer ob) {
    this.obsList.add(ob);
  }

  @Override
  public void unsubscribeObserver(Observer ob) {
    this.obsList.remove(ob);
  }

  @Override
  public void notifyObserver() {
    System.out.println("Book{" +
        "name='" + name + '\'' +
        ", type='" + type + '\'' +
        ", author='" + author + '\'' +
        ", price=" + price +
        ", inStock='" + inStock + '\'' +
        ", is now " +this.inStock+ "So, please notify all user"+
        '}');
    this.obsList.stream().forEach(o -> o.update(this.inStock));
  }
}
