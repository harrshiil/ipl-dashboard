import './HomePage.scss';
import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { TeamTile } from '../components/TeamTile';


export const HomePage = () => {

    const [teams, setTeam] = useState([]); // teamObject will set by setTeam() method // initial init
    const { teamName } = useParams();

    useEffect(
        () => {
            const fetchAllTeams = async () => {
                const response = await fetch(`http://localhost:8080/teams`);
                const data = await response.json();
                setTeam(data);
            };
            fetchAllTeams();
        }, [] // empty array says that on which events it should call. empty array means on loan only
    );

    return (
        <div className="HomePage">
            <div className="header-section"><h1 className="app-name">IPL Dashboard</h1></div>

            <div className="team-grid">
                {teams.map(team => <TeamTile teamName={team.teamName}/>)}
            </div>
        </div>
    );
}