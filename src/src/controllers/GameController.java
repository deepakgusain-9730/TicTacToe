package controllers;

import java.util.*;
import enums.GameState;
import models.Game;
import models.Player;
import strategies.winningStrategies.WinningStrategy;

public class GameController {

    public Game startGame(int dimension,
                          List<Player> players,
                          WinningStrategy winningStrategy) throws Exception {

        return Game.newBuilder().setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(winningStrategy).
                build();

    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public void getWinner(Game game) {

    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public void undo(Game game) {

    }

}
