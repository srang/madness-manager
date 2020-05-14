import React, {useEffect, useState} from 'react';
import axios from 'axios';
import clsx from "clsx";
import {makeStyles, useTheme} from '@material-ui/core/styles';
import {BrowserRouter as Router, Link as RouterLink, Route, Switch} from "react-router-dom";
import {
    AppBar,
    ChevronLeftIcon,
    ChevronRightIcon,
    CssBaseline,
    Divider,
    Drawer,
    IconButton,
    List,
    ListItem,
    ListItemText,
    MenuIcon,
    Toolbar,
    Typography
} from "@material-ui/core";


import TeamList from '../components/TeamList';
import Splash from "../components/Splash";
import TeamDetail from "../components/TeamDetail";

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
    root: {
        display: 'flex',
    },
    appBar: {
        transition: theme.transitions.create(['margin', 'width'], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
    },
    appBarShift: {
        width: `calc(100% - ${drawerWidth}px)`,
        transition: theme.transitions.create(['margin', 'width'], {
            easing: theme.transitions.easing.easeOut,
            duration: theme.transitions.duration.enteringScreen,
        }),
        marginRight: drawerWidth,
    },
    title: {
        flexGrow: 1,
    },
    hide: {
        display: 'none',
    },
    drawer: {
        width: drawerWidth,
        flexShrink: 0,
    },
    drawerPaper: {
        width: drawerWidth,
    },
    drawerHeader: {
        display: 'flex',
        alignItems: 'center',
        padding: theme.spacing(0, 1),
        // necessary for content to be below app bar
        ...theme.mixins.toolbar,
        justifyContent: 'flex-start',
    },
    content: {
        flexGrow: 1,
        padding: theme.spacing(3),
        transition: theme.transitions.create('margin', {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
        marginRight: -drawerWidth,
    },
    contentShift: {
        transition: theme.transitions.create('margin', {
            easing: theme.transitions.easing.easeOut,
            duration: theme.transitions.duration.enteringScreen,
        }),
        marginRight: 0,
    },
    menuButton: {
        marginRight: theme.spacing(2),
    },
}));

export default function BaseLayout() {
    const classes = useStyles();
    const theme = useTheme();
    const [open, setOpen] = React.useState(false);

    const handleDrawerOpen = () => {
        setOpen(true);
    };

    const handleDrawerClose = () => {
        setOpen(false);
    };


    const [teams, setTeams] = useState([]);
    useEffect(() => {
        const axiosOptions = {
            method: 'get',
            url: '/api/teams',
        }
        axios(axiosOptions).then(res => {
            console.log(res.data);
            setTeams(res.data);
        });
    }, []);
    return (
        <Router className={classes.root}>
            <CssBaseline/>

            <AppBar position="fixed"
                    className={clsx(classes.appBar, {
                        [classes.appBarShift]: open,
                    })}
            >
                <Toolbar>
                    <Typography variant="h6" noWrap className={classes.title}>
                        Bracket UI
                    </Typography>
                    <IconButton
                        color="inherit"
                        aria-label="open drawer"
                        edge="end"
                        onClick={handleDrawerOpen}
                        className={clsx(open && classes.hide)}
                    >
                        <MenuIcon/>
                    </IconButton>
                </Toolbar>
            </AppBar>
            <main className={clsx(classes.content, {
                [classes.contentShift]: open,
            })}
            >
                <div className={classes.drawerHeader}/>
                <Switch>
                    <Route path="/teams/detail">
                        <TeamDetail team={teams[0]}/>
                    </Route>
                    <Route path="/teams">
                        <TeamList teams={teams}/>
                    </Route>
                    <Route path="/">
                        <Splash/>
                    </Route>
                </Switch>
            </main>
            <Drawer
                className={classes.drawer}
                variant="persistent"
                anchor="right"
                open={open}
                classes={{
                    paper: classes.drawerPaper,
                }}
            >
                <div className={classes.drawerHeader}>
                    <IconButton onClick={handleDrawerClose}>
                        {theme.direction === 'rtl' ? <ChevronLeftIcon/> : <ChevronRightIcon/>}
                    </IconButton>
                </div>
                <Divider/>
                <List>
                    {[
                        {text: 'Home', path: '/'},
                        {text: 'Teams', path: '/teams'},
                        {text: 'Detail', path: '/teams/detail'},
                    ].map((item, index) => (
                        <ListItem button key={item.text} component={RouterLink} to={item.path}>
                            <ListItemText primary={item.text}/>
                        </ListItem>
                    ))}
                </List>
            </Drawer>
        </Router>
    );
}

