package com.management;

class Account {
    private String id, password, name;
    private boolean status = true;// Active
    private Credentials credentials;
    User person;

    Account(String id, String password, User person) {
        this.id = id;
        this.password = password;
        this.person = person;
        this.credentials = new Credentials(id, password);
    }

    public void resetPassword() {
        password = "";
    }
}