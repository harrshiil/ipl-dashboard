import './HomePage.scss';
import { React, useEffect, useState } from 'react';
import { TeamTile } from '../components/TeamTile';


export const HomePage = () => {

    const [teams, setTeam] = useState([]); // teamObject will set by setTeam() method // initial init

    useEffect(
        () => {
            const fetchAllTeams = async () => {
                const response = await fetch(`${process.env.REACT_APP_API_ROOT_URL}/teams`);
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
                {teams.map(team => <TeamTile key={team.id} teamName={team.teamName}/>)}
            </div>
        </div>
    );
}