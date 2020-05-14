import React from "react";
import Button from "@material-ui/core/Button";
import Grid from "@material-ui/core/Grid";
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import {Link as RouterLink} from 'react-router-dom';

import {makeStyles} from "@material-ui/core/styles";


const useStyles = makeStyles((theme) => ({
    root: {
        minWidth: 275,
    },
    title: {
        fontSize: 14,
    },
    pos: {
        marginBottom: 12,
    },
    button: {
        padding: theme.spacing(2),
        textAlign: 'center',
        color: theme.palette.text.secondary
    },
}));

export default function TeamListItem(props) {
    const classes = useStyles();

    return (
        <Grid item xs={3} className={classes.root}>
            <Card>
                <CardContent>
                    <Typography className={classes.title} color="textSecondary" gutterBottom>
                        {props.team.name.toUpperCase()}
                        <span><svg width="20" height="20">
                            <rect x="9" y="9" width="10" height="10" stroke="black" fill={`#${props.team.primaryColor}`} strokeWidth="0"/>
                        </svg></span>
                    </Typography>
                    <Typography variant="h5" component="h2">
                        {props.team.name}
                    </Typography>
                    <Typography className={classes.pos} color="textSecondary">
                        {props.team.primaryColor}
                    </Typography>
                </CardContent>
                <CardActions>
                    <Button size="small" component={RouterLink} to={`/team/${props.team.id}/detail`} href={`/team/${props.team.id}/detail`}>Details</Button>
                </CardActions>
            </Card>
        </Grid>
    );
}
