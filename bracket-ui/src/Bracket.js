import React from "react";
import Game from "./Game";
import Button from "react-bootstrap/Button";

class Bracket extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            games: [
                {
                    teams: [
                        {
                            name: 'Duke',
                            seed: 1,
                        },
                        {
                            name: 'UNC',
                            seed: 16,
                        }
                    ]
                },
                {
                    teams: [
                        {
                            name: 'Georgetown'
                        },
                        {
                            name: 'UConn'
                        }
                    ]
                }
            ],
        };
    }

    render() {
        return (
            <div className="game">
                <Game game={this.state.games[0]}/>
                <Game game={this.state.games[1]}/>
                <Button>Hello</Button>
            </div>
        );
    }
}

export default Bracket;