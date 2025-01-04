package models;

import enums.CellState;
import enums.PlayerType;

import java.util.Scanner;

public class Player {
    private String name;
    private int id;
    private Symbol symbol;
    private PlayerType playerType;

    public Player() {
    }

    public Player(String name, int id, PlayerType playerType, Symbol symbol) {
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        this.symbol = symbol;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please "+this.name+" enter row");
        int row = scanner.nextInt();

        System.out.print("Please "+this.name+" enter col");
        int col = scanner.nextInt();

        Cell cell = board.getCell().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);

        Move move = new Move();
        move.setPlayer(this);
        move.setCell(cell);
        return move;
    }
}
