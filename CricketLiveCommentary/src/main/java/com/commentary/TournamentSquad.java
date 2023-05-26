package com.commentary;

import java.util.ArrayList;

public class TournamentSquad {
    private ArrayList<Player> players;

    public TournamentSquad() {
        this.players = new ArrayList<>();
    }

    public PlayingEleven selectPlayingEleven(){

        // Here we are assuming some condition for
        // selection, in real time this will be
        // replaced by actual selection criteria.
        boolean condtionForSelection = true;

        PlayingEleven selectedPlayers = new PlayingEleven();
        for(Player p : this.players){
            if(condtionForSelection){
                selectedPlayers.getPlayers().add(p);
            }
        }
        return selectedPlayers;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}

