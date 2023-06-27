package com.card;

public class Dealer {
    public Hand hand;

    public Dealer() {
        this.hand = new Hand();
    }
    public Card printHand(){
        return hand.cards.get(0);
    }
    public void hit(Deck deck){
        this.hand.cards.add(deck.getCard());
    }
    public void dealCards(Deck deck, Player player){
        player.hand.cards.addAll(deck.getCards(2));
        this.hand.cards.addAll(deck.getCards(2));
    }

}
