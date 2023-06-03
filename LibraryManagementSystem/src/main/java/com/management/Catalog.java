package com.management;

import java.util.ArrayList;
import java.util.HashMap;

class Catalog {

    private HashMap<String, ArrayList<Book>> bookTitles = new HashMap<String, ArrayList<Book>>();
    private HashMap<String, ArrayList<Book>> bookAuthors = new HashMap<String, ArrayList<Book>>();
    private HashMap<String, ArrayList<Book>> bookSubjects = new HashMap<String, ArrayList<Book>>();
    private HashMap<String, ArrayList<Book>> bookPublications = new HashMap<String, ArrayList<Book>>();

    public void updateBook(Book book) {

        LibraryManagement.displayBook(book);

        // AUTHOR
        // bookAuthors.putIfAbsent(book.author, new ArrayList<Book>());
        if (bookAuthors.containsKey(book.author))
            bookAuthors.get(book.author).add(book);
        else
            bookAuthors.put(book.author, new ArrayList<Book>());

        // TITLES
        if (bookTitles.containsKey(book.title))
            bookTitles.get(book.title).add(book);
        else
            bookTitles.put(book.title, new ArrayList<Book>());

        // PUBLICATION
        if (bookPublications.containsKey(book.publisher))
            bookPublications.get(book.publisher).add(book);
        else
            bookPublications.put(book.publisher, new ArrayList<Book>());

        // SUBJECTS
        if (bookSubjects.containsKey(book.subject))
            bookSubjects.get(book.subject).add(book);
        else
            bookSubjects.put(book.subject, new ArrayList<Book>());

    }

    public ArrayList<Book> getBookByTitle(String title) {
        return bookTitles.get(title);
    }

    public ArrayList<Book> getBookByAuthor(String author) {
        return bookAuthors.get(author);
    }

    public ArrayList<Book> getBookByPublisher(String publisher) {
        return bookPublications.get(publisher);
    }

    public ArrayList<Book> getBookBySubject(String subject) {
        return bookSubjects.get(subject);
    }
}
