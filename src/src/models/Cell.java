package models;

import enums.CellState;
import exceptions.CellFilledException;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getCellState() {
        return cellState;
    }
    private void validateState() throws CellFilledException {
        if (this.cellState==CellState.FILLED){
            throw new CellFilledException("Cell is already filled");
        }
    }
    public void setCellState(CellState cellState){
        validateState();
        this.cellState = cellState;
    }
}
