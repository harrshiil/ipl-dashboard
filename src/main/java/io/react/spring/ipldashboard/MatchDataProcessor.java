package io.react.spring.ipldashboard;

import io.react.spring.ipldashboard.data.MatchInput;
import io.react.spring.ipldashboard.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {
    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchInput matchInput) throws Exception {

        Match match = new Match()
                .setId(Long.parseLong(matchInput.getId()))
                .setCity(matchInput.getCity())
                .setDate(LocalDate.parse(matchInput.getDate()))
                .setPlayerOfMatch(matchInput.getPlayer_of_match())
                .setVenue(matchInput.getVenue());

        // Set team1 and team2 depending on the inning order
        String firstInningsTeam;
        String secondInningsTeam;
        if ("bat".equals(matchInput.getToss_decision())) {
            firstInningsTeam = matchInput.getToss_winner();
            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
                    ? matchInput.getTeam2()
                    : matchInput.getTeam1();
        } else {
            secondInningsTeam = matchInput.getToss_winner();
            firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
                    ? matchInput.getTeam2()
                    : matchInput.getTeam1();
        }

        match.setTeam1(firstInningsTeam)
                .setTeam2(secondInningsTeam)
                .setTossWinner(matchInput.getToss_winner())
                .setMatchWinner(matchInput.getWinner())
                .setTossDecision(matchInput.getToss_decision())
                .setResult(matchInput.getResult())
                .setResultMargin(matchInput.getResult_margin())
                .setUmpire1(matchInput.getUmpire1())
                .setUmpire2(matchInput.getUmpire2());

        log.info("Converting (" + matchInput + ") into (" + match + ")");

        return match;
    }
}
