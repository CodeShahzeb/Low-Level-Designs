package com.management;

class Librarian extends Account {
    Librarian(String id, String pass, User person) {
        super(id, pass, person);
    }

    public void addBook(Book book, Catalog bookDatabase) {
        bookDatabase.updateBook(book);
        System.out.println("Done");
    }

    public void registerUser() {

    }
}