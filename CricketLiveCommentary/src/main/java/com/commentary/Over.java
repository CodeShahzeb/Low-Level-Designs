package com.commentary;

import java.util.ArrayList;

public class Over {
    private int number;
    private ArrayList<Ball> balls;

    public Over(int number) {
        this.number = number;
        this.balls = new ArrayList<>();
    }

    public void addBall(Ball ball){
        this.balls.add(ball);
    }
    public int getTotalRuns(){
        int totalRuns = 0;
        for(Ball b : this.balls){
            totalRuns += b.getRun().getTotalRuns();
        }
        return totalRuns;
    }
    public int getTotalWickets(){
        int totalWickets = 0;
        for(Ball b : this.balls){
            totalWickets += b.getWicket() != null ? 1 : 0;
        }
        return totalWickets;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public int getOverNumber() {
        return 1;
    }
}

