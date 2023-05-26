package com.commentary;

import java.util.ArrayList;

public class CricLive {
    private ArrayList<Tournament> tournaments;
    private Admin admin;
    private ArrayList<Commentator> commentators;

    public CricLive(Admin admin) {
        this.admin = admin;
        this.tournaments = new ArrayList<>();
        this.commentators = new ArrayList<>();
    }

    public void addTournament(Tournament tournament){
        this.tournaments.add(tournament);
    }

    public void addCommentator(Commentator commentator){
        this.commentators.add(commentator);
    }

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(ArrayList<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public ArrayList<Commentator> getCommentators() {
        return commentators;
    }

    public void setCommentators(ArrayList<Commentator> commentators) {
        this.commentators = commentators;
    }


}  
