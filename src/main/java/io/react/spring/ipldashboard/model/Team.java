package io.react.spring.ipldashboard.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String teamName;
    private long totalMatches;
    private long totalWins;

    @Transient
    private List<Match> matchList;

    public Team() {
    }

    public Team(String teamName, long totalMatches) {
        this.teamName = teamName;
        this.totalMatches = totalMatches;
    }

    public long getId() {
        return id;
    }

    public Team setId(long id) {
        this.id = id;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public Team setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public long getTotalMatches() {
        return totalMatches;
    }

    public Team setTotalMatches(long totalMatches) {
        this.totalMatches = totalMatches;
        return this;
    }

    public long getTotalWins() {
        return totalWins;
    }

    public Team setTotalWins(long totalWins) {
        this.totalWins = totalWins;
        return this;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", totalMatches=" + totalMatches +
                ", totalWins=" + totalWins +
                '}';
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public Team setMatchList(List<Match> matchList) {
        this.matchList = matchList;
        return this;
    }
}
