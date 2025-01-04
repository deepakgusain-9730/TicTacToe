package models;

import enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;

    private List<List<Cell>> cell;

    Board(int dimension) {
        this.size = dimension;
        cell = new ArrayList<>();
        for(int i=0; i<this.size; i++) {
            List<Cell> row = new ArrayList<>();
            for(int j=0; j<this.size; j++) {
                Cell cell = new Cell();
                cell.setRow(i);
                cell.setCol(j);
                cell.setCellState(CellState.EMPTY);
                row.add(cell);
            }
            cell.add(row);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getCell() {
        return cell;
    }

    public void setCell(List<List<Cell>> cell) {
        this.cell = cell;
    }

    public void displayBoard() {

        System.out.println("Displaying the board");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell1 = cell.get(i).get(j);
                if(cell1.getPlayer()==null){
                    System.out.print("-");
                }else{
                    System.out.print(cell1.getPlayer().getSymbol().getaChar());
                }
            }
            System.out.println();
        }
    }
}
