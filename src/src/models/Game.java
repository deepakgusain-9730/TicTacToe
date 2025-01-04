package models;

import enums.GameState;
import enums.PlayerType;
import exceptions.BotCountException;
import exceptions.PlayerCountException;
import exceptions.SymbolCountException;
import strategies.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private Board board;

    private List<Player> players;

    private List<Move> moves;

    private GameState gameState;

    private int nextMovePlayerIndex;

    private Player winner;

    private WinningStrategy winningStrategy;

    private Game(int dimension, List<Player> players, WinningStrategy winningStrategy) {
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.board = new Board(dimension);
        this.nextMovePlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();

    }

    public void displayBoard() {
        this.board.displayBoard();
    }

    public void makeMove() {
        Player currentPlayer = players.get(nextMovePlayerIndex);
        Move currentMove = currentPlayer.makeMove(board);
        moves.add(currentMove);

        if (winningStrategy.checkWinner(board, currentMove)){
            setGameState(GameState.ENDED);
            setWinner(currentPlayer);
            return;
        }
        if(moves.size() == board.getSize() * board.getSize()){
//            Game is drawn
            setGameState(GameState.DRAW);
            return;
        }
        nextMovePlayerIndex = (nextMovePlayerIndex + 1) % players.size();
    }

    public static class Builder {
        private int dimension;

        private List<Player> players;


        private WinningStrategy winningStrategy;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder addPlayer(Player player) {
            players.add(player);
            return this;
        }


        private Builder validateBot() throws BotCountException {
            int botCount = 0;
            for (Player player : players) {
                if(player.getPlayerType().equals(PlayerType.BOT))
                    botCount++;

            }
            if(botCount>1)
                throw new BotCountException("Bot count more than one.");
            return this;
        }

        private Builder validatePlayerCount() throws PlayerCountException {
            if(players.size() != dimension-1 )
                throw new PlayerCountException("Players count should be " + dimension + " - 1");
            return this;
        }

        private void validatePlayerChars() throws SymbolCountException{

            HashSet<Character> validChars = new HashSet<>();
            for (Player player : players) {
                if (validChars.contains(player.getSymbol().getaChar())) {
                    throw new SymbolCountException("Player " + player.getSymbol().getaChar() + " is already in use.");
                }else{
                    validChars.add(player.getSymbol().getaChar());
                }
            }


        }

        private void validate() throws BotCountException, PlayerCountException, SymbolCountException {
            validateBot().validatePlayerCount().validatePlayerChars();
        }

        public Game build() throws BotCountException, PlayerCountException, SymbolCountException {
            validate();
            return new Game(this.dimension, this.players, this.winningStrategy);
        }

    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

}
