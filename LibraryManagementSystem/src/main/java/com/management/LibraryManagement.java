package com.management;

import java.util.ArrayList;

class LibraryManagement {

    public static void main(String args[]) {
        Library lib = new Library("test", "Bangalore");
        Catalog bookDatabse = new Catalog();
        // Create librarian profile
        User person = new User("Harsh", "Daman", "harsh@gmail.com", "8758149799");
        Librarian librarian = new Librarian("id", "pass", person);

        Book book1 = new Book("c++", "Coding", "Dan", "TATA");
        librarian.addBook(book1, bookDatabse);

        Book book2 = new Book("JAVA", "Coding", "Henry", "TATA");
        librarian.addBook(book2, bookDatabse);
        // // test
        ArrayList<Book> display = bookDatabse.getBookBySubject("Coding");
        for (Book book : display) {
            displayBook(book);
            System.out.println("check");
        }
    }

    public static void displayBook(Book book) {
        System.out.println("Book:");
        System.out.println("\tTitle:" + book.title);
        System.out.println("\tSubject:" + book.subject);
        System.out.println("\tAuthor:" + book.author);
        System.out.println("\tPublisher:" + book.publisher);
    }
}