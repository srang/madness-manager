import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";
import Container from "@material-ui/core/Container";

import TeamListItem from './TeamListItem'

export default function TeamList(props) {
    const [rows, setRows] = useState([]);

    useEffect(() => {
        const axiosOptions = {
            method: 'get',
            url: '/api/teams',
        }
        axios(axiosOptions).then(res => {
            console.log(res.data);
            let rowData = [];
            res.data.forEach((team) => {
                rowData.push(<TeamListItem
                    team={team}
                    key={team.id}/>)
            });
            setRows(rowData);
        });
    }, []);

    return (
        <Container>
            <Button>refresh</Button>
            <Grid container spacing={3}>
                {rows}
            </Grid>
        </Container>
    );
}

