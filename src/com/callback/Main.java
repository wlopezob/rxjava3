package com.callback;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Book book = new Book("W.S.", "Horror", "Xyz", 200, "SoldOut");
        EndUser user1 = new EndUser("Wlopezob", book);
        EndUser user2 = new EndUser("Joseob", book);
        EndUser user3 = new EndUser("Kattyob", book);

        System.out.println(book.getInStock());

        book.setInStock("In stock");
    }


}
