package com.commentary;

import com.commentary.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating teams
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");

        // Creating players
        Player player1 = new Player("Player 1", new Date(), team1);
        Player player2 = new Player("Player 2", new Date(), team1);
        Player player3 = new Player("Player 3", new Date(), team2);
        Player player4 = new Player("Player 4", new Date(), team2);

        // Adding players to teams
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team2.addPlayer(player3);
        team2.addPlayer(player4);

        // Creating a tournament
        Tournament tournament = new Tournament("Tournament 1", "Host 1", "2023");

        // Creating a match
        LocalDateTime matchDateTime = LocalDateTime.now();

        List<Player> team1PlayingEleven = team1.selectPlayingEleven();
        List<Player> team2PlayingEleven = team2.selectPlayingEleven();

        Match match = new Match(team1PlayingEleven, team2PlayingEleven, "Venue 1",
                matchDateTime, MatchType.ODI);

        // Adding match to tournament
        tournament.addMatch(match);

        // Creating overs, balls, and adding runs
        Over over = new Over(1);
        Ball ball = new Ball(player1, player2);
        Run run = new Run();
        run.setTotalRuns(4);
        ball.setRun(run);
        over.addBall(ball);

        // Adding over to match inning
        Inning inning = new Inning(1);
        inning.addOver(over);
        match.getInnings().add(inning);

        // Accessing player records
        PlayerRecord player1Record = player1.getRecord();
        player1Record.setMatchesPlayed(10);
        player1Record.setTotalRuns(500);
        player1Record.setBattingAverage(50.0);

        // Accessing team points in the tournament
        tournament.updateTeamPoints(team1.getName(), 2);
        Integer team1Points = tournament.getTeamPoints(team1.getName());

        // Displaying information
        System.out.println("Player 1 Name: " + player1.getName());
        System.out.println("Player 1 Total Runs: " + player1Record.getTotalRuns());
        System.out.println("Team 1 Points: " + team1Points);

        // Providing commentary of the match ball by ball
        System.out.println("\nMatch Commentary:");
        System.out.println("--------------------");

        Commentator commentator1 = new Commentator("Commentator 1");
        Commentator commentator2 = new Commentator("Commentator 2");

        for (Inning inningObj : match.getInnings()) {
            int inningNumber = inningObj.getInningNumber();
            System.out.println("Inning " + inningNumber + " Commentary:");

            for (Over overObj : inningObj.getOvers()) {
                int overNumber = overObj.getOverNumber();
                System.out.println("Over " + overNumber + " Commentary:");

                for (Ball ballObj : overObj.getBalls()) {
                    Player striker = ballObj.getStriker();
                    Player nonStriker = ballObj.getNonStriker();
                    Run ballRun = ballObj.getRun();

                    Commentary commentary = new Commentary(commentator1.getName() + ": ");
                    commentary.setText(commentary.getText() + striker.getName() + " facing the ball. ");
                    commentary.setText(commentary.getText() + "Scored " + ballRun.getTotalRuns() + " run(s) on this ball. ");
                   // commentary.setText(commentary.getText() + "Total score: " + inning.getInningScore());

                    ballObj.setCommentary(commentary);
                    System.out.println(commentary);

                    // Switching the commentator for the next ball
                    Commentator temp = commentator1;
                    commentator1 = commentator2;
                    commentator2 = temp;
                }
            }
        }
    }
}
