import Typography from "@material-ui/core/Typography";
import CardContent from "@material-ui/core/CardContent";
import React from "react";
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
export default function TeamCardTitle(props) {
    const classes = useStyles();

    return (<Typography className={classes.title} color="textSecondary" gutterBottom>
        {props.team.name.toUpperCase()}
        <span><svg width="20" height="20">
                            <rect x="9" y="9" width="10" height="10" stroke="black" fill={`#${props.team.primaryColor}`} strokeWidth="0"/>
                        </svg></span>
    </Typography>);

}
