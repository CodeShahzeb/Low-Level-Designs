package com.management;

import java.util.HashMap;

class Credentials {
    private HashMap<String, String> loginPass = new HashMap<String, String>();

    Credentials(String username, String password) {
        if (loginPass.containsKey(username)) {
            System.out.println("Invalid username already Exisit");
        } else
            loginPass.put(username, password);
    }

    public boolean login(String username, String password) {

        if (loginPass.get(username) == password) {
            System.out.println("Logged In Succesfully");
            return true;
        }

        return false;

    }
}