import React from "react";
import Board from "./Board";

class BoardGame extends React.Component {
    render() {
        return (
            <div className="board-game">
                <div className="game-board">
                    <Board/>
                </div>
                <div className="board-game-info">
                    <div>{/* status */}</div>
                    <ol>{/* TODO */}</ol>
                </div>
            </div>
        );
    }
}

export default BoardGame;