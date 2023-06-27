package com.management;

class Book {
    public String title, subject, author, publisher;
    public int ID;
    static int count = 1;

    Book(String title, String subject, String author, String publisher) {
        this.title = title;
        this.subject = subject;
        this.author = author;
        this.publisher = publisher;
        this.ID = count;
        count += 1;
    }

}