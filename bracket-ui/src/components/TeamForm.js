import {Form, Formik} from "formik";
import {TextField} from "@material-ui/core";
import Button from "@material-ui/core/Button";
import React from "react";
import * as Yup from 'yup';
import {makeStyles} from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
    root: {
        minWidth: 275,
    },
    title: {
        fontSize: 14,
    },
    input: {
        display: "inline-flex",
        padding: theme.spacing(2),
    }
}));

const TeamSchema = Yup.object().shape({
    team: Yup.object().shape({
        name: Yup.string()
            .matches(/^[A-Z0-9 ']+$/i, 'Invalid team name')
            .required('Required'),
        primaryColor: Yup.string()
            .matches(/^([A-F0-9]{3}){1,2}$/i, 'Invalid color')
            .required('Required')
    })
});


export default function TeamForm(props) {
    const classes = useStyles();

    return (<Formik enableReinitialize={true}
                    initialValues={{team: {name: props.team.name, primaryColor: props.team.primaryColor}}}
                    onSubmit={props.handleSubmit}
                    validationSchema={TeamSchema}>
            {({
                  values,
                  errors,
                  touched,
                  handleChange,
                  handleBlur
              }) => {

                return (
                    <Form>
                        <div className={classes.input}>
                            <TextField
                                error={errors.team?.name && touched.team?.name}
                                label="Team Name"
                                name="team.name"
                                value={values.team.name}
                                onChange={handleChange}
                                onBlur={handleBlur}
                                helperText={(errors.team?.name && touched.team?.name) && errors.team.name}
                            />
                        </div>
                        <div className={classes.input}>
                            <TextField
                                error={errors.team?.primaryColor && touched.team?.primaryColor}
                                label="Primary Color"
                                name="team.primaryColor"
                                value={values.team.primaryColor.toUpperCase()}
                                onChange={handleChange}
                                onBlur={handleBlur}
                                helperText={(errors.team?.primaryColor && touched.team?.primaryColor) && errors.team.primaryColor}
                            />
                        </div>
                        <Button type="submit">Submit</Button>
                    </Form>
                );
            }}
        </Formik>
    );
}
