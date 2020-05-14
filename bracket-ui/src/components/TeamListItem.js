import React from "react";
import Button from "@material-ui/core/Button";
import Grid from "@material-ui/core/Grid";
import {makeStyles} from "@material-ui/core/styles";


const useStyles = makeStyles((theme) => ({
    button: {
        padding: theme.spacing(2),
        textAlign: 'center',
        color: theme.palette.text.secondary
    },
}));

export default function TeamListItem(props) {
        const classes = useStyles();

        return (
                <Grid item xs={12}>
                    <Button className={classes.button}>{props.team.name} {props.team.primaryColor}</Button>
                </Grid>
        );
}
