import React from "react";

class Game extends React.Component {
    render() {
        return (
            <div>
                <p>{this.props.game.teams[0].name}</p>
                <p>{this.props.game.teams[1].name}</p>
            </div>
        );
    }
}

export default Game;