package com.commentary;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(Player player){
        this.players.remove(player);
    }

    public TournamentSquad selectTournamentSquad(){

        // Here we are assuming some condition for
        // selection, in real time this will be
        // replaced by actual selection criteria.
        boolean condtionForSelection = true;

        TournamentSquad selectedPlayers = new TournamentSquad();
        for(Player p : this.players){
            if(condtionForSelection){
                selectedPlayers.getPlayers().add(p);
            }
        }
        return selectedPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public List<Player> selectPlayingEleven() {
        // Add your logic to select the playing eleven from the list of players
        // For example, you can select the first 11 players in the list
        if (players.size() >= 11) {
            return players.subList(0, 11);
        } else {
            return players;
        }
    }
}
