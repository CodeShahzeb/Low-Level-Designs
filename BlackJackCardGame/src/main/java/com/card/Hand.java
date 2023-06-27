package com.card;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }
    public int getValue(){
        int tempValue=0;
        int numOfAces = 0;
        for(Card c : cards){
            tempValue += c.getValue();
            if(c.rank == Rank.ACE){
                numOfAces++ ;
            }
        }
        while(numOfAces >0){
            if(tempValue > 21){
                tempValue -= 10;

            }
            numOfAces--;
        }
        return tempValue;
    }

    @Override
    public String toString() {
        return "[" +
                cards +
                "]";
    }
}

