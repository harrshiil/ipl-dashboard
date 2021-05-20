import './MatchSmallCard.scss';
import { React } from 'react';
import { Link } from 'react-router-dom'

export const MatchSmallCard = ({ teamName, match }) => {
    if (!match) return null;
    const otherTeamName = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoute = `/teams/${otherTeamName}`;
    const isMatchWon = teamName === match.matchWinner;
    return (
        <div className={isMatchWon ? 'MatchSmallCard won-card' : 'MatchSmallCard lost-card'}>
            <span className="vs">vs</span>
            <h3><Link to={otherTeamRoute}>{otherTeamName}</Link></h3>
            <p className="match-result">{match.matchWinner} won by {match.resultMargin} {match.result}</p>
        </div>
    );
}