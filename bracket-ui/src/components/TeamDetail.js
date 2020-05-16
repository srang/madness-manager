import React, {useEffect, useState} from "react";
import {Form, Formik} from "formik";
import axios from 'axios';
import {useParams} from 'react-router-dom';
import {makeStyles} from "@material-ui/core/styles";
import {TextField} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import TeamCardTitle from "./TeamCardTitle";
import TeamForm from "./TeamForm";


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
    let {teamId} = useParams();
    const [team, setTeam] = useState({id: '', name: '', primaryColor: ''});


    useEffect(() => {
        const axiosOptions = {
            method: 'get',
            url: `/api/teams/id/${teamId}`,
        }
        axios(axiosOptions).then(res => setTeam(res.data));
    }, []);


    return (
        <Grid container className={classes.root} justify="center">
            <Grid item xs={5} className={classes.root}>
                <Card>
                    {team.name && (
                        <CardContent>
                            <TeamCardTitle team={team} />
                            <Formik enableReinitialize={true}
                                    initialValues={{team: {name: team.name, primaryColor: team.primaryColor}}}
                                    onSubmit={(values, {setSubmitting}) => {
                                        alert(JSON.stringify(values, null, 2));
                                    }}
                                // validate: {(values) => {
                                //     const errors = {};
                                //     if (!values.email) {
                                //         errors.email = 'Required';
                                //     } else if (
                                //         !/^[A-Z0-9 ']+$/i.test(values.teamName)
                                //     ) {
                                //         errors.teamName = 'Invalid team name';
                                //     }
                                //     return errors;
                                // }}
                            >{(props)=> <TeamForm
                                values={props.values}
                                touched={props.touched}
                                errors={props.errors}
                                dirty={props.dirty}
                                isSubmitting={props.isSubmitting}
                                handleChange={props.handleChange}
                                handleBlur={props.handleBlur}
                                handleSubmit={props.handleSubmit}
                                handleReset={props.handleReset}
                            />}
                            </Formik>

                        </CardContent>
                    )}
                </Card>
            </Grid>
        </Grid>
    );
}
