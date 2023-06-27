package com.card;

public class Player {
    public String name;
    private double amount;
    public Hand hand;

    public Player(String name, double amount) {
        this.name = name;
        this.amount = amount;
        this.hand = new Hand();
    }

    public double getAmount() {
        return amount;
    }

    public void hit(Deck deck){
        this.hand.cards.add(deck.getCard());
    }
    public void updateAmount(double value){
        amount += value;
    }


}
