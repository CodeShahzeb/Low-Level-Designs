package com.management;

import java.time.LocalDateTime;

class Members extends Account {
    public int totalBook = 0;

    Members(String id, String pass, User user) {
        super(id, pass, user);
    }

    public void issueBook(Book book) {
        this.totalBook += 1;
    }

    public void renew(LocalDateTime today) {
        BookLending.creationDate = today;
        BookLending.dueDate = today;
    }

    public int getTotalBook() {
        return totalBook;
    }
}