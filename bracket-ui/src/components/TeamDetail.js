import React, {useEffect, useState} from "react";
import axios from 'axios';
import {useParams, useHistory} from 'react-router-dom';
import {makeStyles} from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import TeamCardTitle from "./TeamCardTitle";
import TeamForm from "./TeamForm";


const useStyles = makeStyles((theme) => ({
    root: {
        minWidth: 275,
    },
    title: {
        fontSize: 14,
    },
}));


export default function TeamDetail(props) {
    const classes = useStyles();
    let {teamId} = useParams();
    let history = useHistory();
    const [team, setTeam] = useState({id: '', name: '', primaryColor: ''});


    useEffect(() => {
        const axiosOptions = {
            method: 'get',
            url: `/api/teams/id/${teamId}`,
        };
        axios(axiosOptions).then(res => setTeam(res.data))
    }, []);
    const handleTeamFormSubmit = (values, actions) => {
        const axiosOptions = {
            method: 'put',
            data: {
                id: teamId,
                name: values.team.name,
                primaryColor: values.team.primaryColor,
            },
            url: `/api/teams/id/${teamId}`,
        };
        axios(axiosOptions)
            .then(response => {
                actions.setSubmitting(false);
                history.push('/teams');
            })
            .catch(error => {
                actions.setSubmitting(false);
                alert(error);
            });
    }

    return (
        <Grid container className={classes.root} justify="center">
            <Grid item xs={5} className={classes.root}>
                <Card>
                    {team.name && (
                        <CardContent>
                            <TeamCardTitle team={team}/>
                            <TeamForm team={team} handleSubmit={handleTeamFormSubmit}/>
                        </CardContent>
                    )}
                </Card>
            </Grid>
        </Grid>
    );
}
