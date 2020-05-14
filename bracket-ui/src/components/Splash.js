import {makeStyles} from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";
import React from "react";

const useStyles = makeStyles((theme) => ({
    button: {
        padding: theme.spacing(2),
        textAlign: 'center',
        color: theme.palette.text.secondary
    },
}));

export default function Splash(props) {
    const classes = useStyles();

    return (
        <Grid item xs={12}>
            <Button className={classes.button}>There's no place like home</Button>
        </Grid>
    );
}
