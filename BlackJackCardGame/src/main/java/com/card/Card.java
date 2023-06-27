package com.card;

public class Card {
    Rank rank;
    Suit suit;

    public Card(Suit suit,Rank rank) {
        this.suit = suit;
        this.rank = rank;

    }

    public int getValue(){
        return this.rank.value;
    }
    @Override
    public String toString() {
        return "[" + rank + "," + suit + "]";
    }
}
