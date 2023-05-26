package com.commentary;

import java.util.Date;

public class Player {
    private String name;
    private Date dob;
    private Team team;
    private PlayerRecord record;

    public Player(String name, Date dob, Team team) {
        this.name = name;
        this.dob = dob;
        this.team = team;
        this.record = new PlayerRecord();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    public PlayerRecord getRecord() {
        return record;
    }

    public void setRecord(PlayerRecord record) {
        this.record = record;
    }
}
