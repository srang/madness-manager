import React from 'react';
import Grid from "@material-ui/core/Grid";
import TeamListItem from './TeamListItem'
import Container from "@material-ui/core/Container";

export default function TeamList(props) {
    const rows = [];

    props.teams.forEach((team) => {

        rows.push(
            <TeamListItem
                team={team}
                key={team.id}/>
        );

    });

    return (
        <Container maxWidth="md">
            <Grid container spacing={3}>
                {rows}
            </Grid>
        </Container>
    );
}

