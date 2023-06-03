package com.management;

class Library {
    private String name, address;

    Library(String name, String address) {

        this.name = name;
        this.address = address;

    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }
}