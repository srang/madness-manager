import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import CardActions from "@material-ui/core/CardActions";


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

    return (
        <Grid item xs={5} className={classes.root}>
            <Card>
                <CardContent>
                    <Typography className={classes.title} color="textSecondary" gutterBottom>
                        {props.team.name.toUpperCase()}
                        <span><svg width="20" height="20">
                            <rect x="9" y="9" width="10" height="10" stroke="black" fill={'#' + props.team.primaryColor}
                                  stroke-width="0"/>
                        </svg></span>
                    </Typography>
                    <Typography variant="h5" component="h2">
                        {props.team.name}
                    </Typography>
                    <Typography className={classes.pos} color="textSecondary">
                        {props.team.primaryColor.toUpperCase()}
                    </Typography>
                </CardContent>
                <CardActions>
                    <Button size="small">Details</Button>
                </CardActions>
            </Card>
        </Grid>
    );
}
