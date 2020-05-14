import React, {useEffect, useState} from "react";
import {makeStyles} from "@material-ui/core/styles";
import axios from 'axios';
import {useParams} from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";


const useStyles = makeStyles((theme) => ({
    root: {
        minWidth: 275,
    },
    title: {
        fontSize: 14,
    },
}));

export default function TeamDetail(props) {
    let {teamId} = useParams();
    const [team, setTeam] = useState(null);
    console.log(teamId);
    const classes = useStyles();
    useEffect(() => {
        const axiosOptions = {
            method: 'get',
            url: `/api/teams/id/${teamId}`,
        }
        axios(axiosOptions).then(res => {
            console.log(res.data);
            setTeam(res.data);
        });
    }, []);

    return (
        <Grid item xs={5} className={classes.root}>
            <Card>
                {team && (
                    <CardContent>
                        <Typography className={classes.title} color="textSecondary" gutterBottom>
                            {team.id}) {team.name.toUpperCase()}
                            <span><svg width="20" height="20">
                            <rect x="9" y="9" width="10" height="10" stroke="black" fill={'#' + team.primaryColor}
                                  strokeWidth="0"/>
                        </svg></span>
                        </Typography>
                        <Typography variant="h5" component="h2">
                            {team.name}
                        </Typography>
                        <Typography className={classes.pos} color="textSecondary">
                            {team.primaryColor.toUpperCase()}
                        </Typography>
                    </CardContent>
                )}
            </Card>
        </Grid>
    );
}
