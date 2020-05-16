import {makeStyles} from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import React from "react";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import Card from "@material-ui/core/Card";

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
}));

export default function Splash(props) {
    const classes = useStyles();

    return (
        <Grid container className={classes.root} justify="center">
            <Grid item xs={8}>
                <Card>
                    <CardContent>
                        <Typography paragraph>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
                            incididunt
                            ut labore et dolore magna aliqua. Rhoncus dolor purus non enim praesent elementum
                            facilisis leo vel. Risus at ultrices mi tempus imperdiet. Semper risus in hendrerit
                            gravida rutrum quisque non tellus. Convallis convallis tellus id interdum velit laoreet
                            id
                            donec ultrices. Odio morbi quis commodo odio aenean sed adipiscing. Amet nisl suscipit
                            adipiscing bibendum est ultricies integer quis. Cursus euismod quis viverra nibh cras.
                            Metus vulputate eu scelerisque felis imperdiet proin fermentum leo. Mauris commodo quis
                            imperdiet massa tincidunt. Cras tincidunt lobortis feugiat vivamus at augue. At augue
                            eget
                            arcu dictum varius duis at consectetur lorem. Velit sed ullamcorper morbi tincidunt.
                            Lorem
                            donec massa sapien faucibus et molestie ac.
                        </Typography>
                    </CardContent>
                </Card>
            </Grid>
        </Grid>
    );
}
