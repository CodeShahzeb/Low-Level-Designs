package com.card;

import java.util.Scanner;

public class BlackJack {
    Dealer dealer;
    Player player;
    Deck deck;
    double betAmount;

    public BlackJack(Player player, double betAmount) {
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.player = player;
        this.player.hand = new Hand();
        this.betAmount = betAmount;
    }
    public void printHandsAndScore(){
        System.out.println("Dealer Cards : "+ dealer.printHand());
        System.out.println("Your Cards : "+ player.hand);
        System.out.println("Your Score : "+ player.hand.getValue());
    }

    public int dealerPlay(int dealerScore, int playerScore){
        System.out.println("Dealer Hand: "+ dealer.hand);
        System.out.println("Dealer Score: "+ dealerScore);
        while(dealerScore < 17){
            dealer.hit(deck);
            dealerScore = dealer.hand.getValue();
            System.out.println("Dealer Hit");
            System.out.println("Dealer Hand: "+ dealer.hand);
            System.out.println("Dealer Score: "+ dealerScore);
        }
        if(dealerScore > 21){
            System.out.println("Dealer Busted! You Win");
            player.updateAmount(betAmount);
            return 1;
        }
        else if(dealerScore >= playerScore){
            System.out.println("Dealer Wins");
            player.updateAmount(-1 * betAmount);
            return 0;
        }
        else{
            System.out.println("You Win");
            player.updateAmount(betAmount);
            return 1;
        }
    }
    public int start(){

        // Deck is shuffled at start
        deck.shuffle();
        // Dealer deals two cards to player and himself
        dealer.dealCards(deck,player);


        int playerScore = player.hand.getValue();
        int dealerScore = dealer.hand.getValue();
        Scanner sc = new Scanner(System.in);
        while(true){
            printHandsAndScore();
            if(playerScore == 21){
                System.out.println("BlackJack! You Win");
                player.updateAmount(betAmount);
                return 1;
            }
            else if (playerScore > 21){
                System.out.println("Busted! Dealer Wins");
                player.updateAmount(-1 * betAmount);
                return 0;
            }
            else{
                System.out.print("Press 1 to Hit, 0 to Stand");
                int input = sc.nextInt();
                if (input ==0){
                    return dealerPlay(dealerScore,playerScore);
                }
                else if(input ==1){
                    player.hit(deck);
                    playerScore = player.hand.getValue();
                    System.out.println("You Hit");
                }
                else{
                    System.out.println("Invalid Choice! Press 1 to Hit, 0 to Stand");
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;
        Player piyush = new Player("Piyush",10000);
        do{
            System.out.print("Enter bet amount: ");
            double betAmount = sc.nextDouble();
            BlackJack game = new BlackJack(piyush,betAmount);
            game.start();
            System.out.println("Your Total amount is :"+ piyush.getAmount());
            System.out.print("Would you like to DEAL? Press Y or N");
            userInput = sc.next();
        }while(userInput.equals("Y"));
    }
}

