import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";


const useStyles = makeStyles((theme) => ({
    button: {
        padding: theme.spacing(2),
        textAlign: 'center',
        color: theme.palette.text.secondary
    },
}));

export default function TeamDetail(props) {
    const classes = useStyles();

    return (
        <Grid item xs={12}>
            <Button className={classes.button}>Hello world</Button>
        </Grid>
    );
}
