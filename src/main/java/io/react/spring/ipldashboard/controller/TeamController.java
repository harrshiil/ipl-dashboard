package io.react.spring.ipldashboard.controller;

import io.react.spring.ipldashboard.model.Match;
import io.react.spring.ipldashboard.model.Team;
import io.react.spring.ipldashboard.repository.MatchRepository;
import io.react.spring.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// CORS will give error when server and client has different domain or port
// Below annotation will inform server to accept request from other domain
@CrossOrigin
@RestController
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/teams")
    public Iterable<Team> getAllTeams() {
        return this.teamRepository.findAll();
    }
    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = this.teamRepository.findByTeamName(teamName);
        team.setMatchList(this.matchRepository.findLatestMatchesByTeamName(teamName, 4));
        return team;
    }

    // year is a filter and we may have multiple filter that is why we use qureyParam for year
    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatches(@PathVariable String teamName, @RequestParam int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
    }
}
