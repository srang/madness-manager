import React, {useEffect, useState} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import TeamList from '../components/TeamList';
import axios from 'axios';
import Container from "@material-ui/core/Container";
import TeamDetail from "../components/TeamDetail";
import {BrowserRouter as Router, Link as RouterLink, Switch, Route} from "react-router-dom";
import Link from "@material-ui/core/Link";

const useStyles = makeStyles((theme) => ({}));

export default function BaseLayout() {
    const classes = useStyles();

    const [teams, setTeams] = useState([]);
    useEffect(() => {
        const axiosOptions = {
            method: 'get',
            url: '/api/teams',
        }
        axios(axiosOptions).then(res => {
            console.log(res.data);
            setTeams(res.data);
        });
    }, []);
    return (
        <Router>
            <div>
                <ul>
                    <li>
                        <Link color="secondary" component={RouterLink} to="/">Home</Link>
                    </li>
                    <li>
                        <Link color="secondary" component={RouterLink} to="/teams">Teams</Link>
                    </li>
                </ul>
                <Switch>
                    <Route path="/teams">
                        <p>Hello teams</p>
                    </Route>
                    <Route path="/">
                        <TeamList teams={teams}/>
                    </Route>
                </Switch>
            </div>
        </Router>
    );
}

