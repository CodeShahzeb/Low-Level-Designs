package com.commentary;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Tournament {
    private TournamentType type= TournamentType.UPCOMING;
    private ArrayList<Match> matches;
    private String title;
    private String host;
    private String year;
    private Team winner;
    private HashMap<String, Match> schedule;
    private HashMap<String, Integer> teamPoints;

    public Tournament( String title, String host, String year) {
        this.title = title;
        this.host = host;
        this.year = year;
        this.matches = new ArrayList<>();
        this.schedule = new HashMap<>();
        this.teamPoints = new HashMap<>();
    }
    public void addMatch(Match match){
        matches.add(match);
        LocalDateTime dateTime = match.getDateTime();
        String dateTimeString = dateTime.toString();
        schedule.put(dateTimeString,match);
    }

    public void updateTeamPoints(String teamName, int newPoints) {
        Integer currentPoints = teamPoints.get(teamName);
        if (currentPoints == null) {
            currentPoints = 0;
        }
        teamPoints.put(teamName, currentPoints + newPoints);
    }


    public Map<String,Match> getTeamSchedule(String teamName){
        Map<String,Match> result = schedule.entrySet()
                .stream()
                .filter(map -> (map.getValue()).toString().indexOf(teamName)>0)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        return result;
    }
    public Integer getTeamPoints(String teamName){
        return this.teamPoints.get(teamName);
    }


    public void printTournamentSchedule() {
        System.out.println("Tournament Schedule:");
        System.out.println("--------------------");

        for (Match match : matches) {
            System.out.println("Match: " + match.getTeam1() + " vs " + match.getTeam2());
            System.out.println("Venue: " + match.getVenue());
            System.out.println("Date: " + match.getDateTime());
            System.out.println("Match Type: " + match.getMatchType());
            System.out.println("--------------------");
        }
    }


    public void printMatchDetails() {
        System.out.println("Match Details:");
        System.out.println("--------------------");

        for (int i = 0; i < matches.size(); i++) {
            Match match = matches.get(i);
            System.out.println("Match: " + match.getTeam1() + " vs " + match.getTeam2());
            System.out.println("Venue: " + match.getVenue());
            System.out.println("Date: " + match.getDateTime());
            System.out.println("Match Type: " + match.getMatchType());
            System.out.println("--------------------");
        }
    }

    public void printCommentary() {
        System.out.println("Live Commentary:");
        System.out.println("--------------------");

        for (Match match : matches) {
            System.out.println("Match: " + match.getTeam1() + " vs " + match.getTeam2());
            System.out.println("Venue: " + match.getVenue());
            System.out.println("Date: " + match.getDateTime());
            System.out.println("Commentary: " + match.getCommentary());
            System.out.println("--------------------");
        }
    }


}

