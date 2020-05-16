import {Form, Formik} from "formik";
import {TextField} from "@material-ui/core";
import Button from "@material-ui/core/Button";
import React from "react";
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


export default function TeamForm(props) {
    const classes = useStyles();

    return (<Formik enableReinitialize={true}
                    initialValues={{team: {name: props.team.name, primaryColor: props.team.primaryColor}}}
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
        >{(props) => {
            const {
                values,
                touched,
                errors,
                dirty,
                isSubmitting,
                handleChange,
                handleBlur,
                handleSubmit,
                handleReset,
            } = props;
            return (
                <Form>
                    <div className={classes.input}>
                        <TextField
                            label="Team Name"
                            name="team.name"
                            value={values.team.name}
                            onChange={handleChange}
                            onBlur={handleBlur}
                            helperText={(errors.team?.name && touched.team.name) && errors.team.name}
                        />
                    </div>
                    <div className={classes.input}>
                        <TextField
                            label="Primary Color"
                            name="team.primaryColor"
                            value={values.team.primaryColor}
                            onChange={handleChange}
                            onBlur={handleBlur}
                            helperText={(errors.team?.primaryColor && touched.team.primaryColor) && errors.team.primaryColor}
                        />
                    </div>
                    <Button type="submit">Submit</Button>
                </Form>
            );
        }}
        </Formik>
    );
}
