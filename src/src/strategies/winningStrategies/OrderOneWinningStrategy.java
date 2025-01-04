package strategies.winningStrategies;

import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneWinningStrategy implements WinningStrategy {

    private List<Map<Symbol, Integer>> rows;
    private List<Map<Symbol, Integer>> cols;
    private Map<Symbol, Integer> diagonalCols;
    private Map<Symbol, Integer> reverseDiagonalCols;

    public OrderOneWinningStrategy(int size){
        rows = new ArrayList<>();
        cols = new ArrayList<>();
        diagonalCols = new HashMap<>();
        reverseDiagonalCols = new HashMap<>();
        for(int i = 0; i < size; i++) {
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        Cell cell = move.getCell();
        Player player = cell.getPlayer();
        int row = cell.getRow();
        int col = cell.getCol();
        Map<Symbol, Integer> mapRow = rows.get(row);
        int rowCount = mapRow.getOrDefault(player.getSymbol(), 0) + 1;
        mapRow.put(player.getSymbol(), rowCount);


        Map<Symbol, Integer> mapCol = cols.get(col);

        int colCount = mapCol.getOrDefault(player.getSymbol(), 0) + 1;
        mapCol.put(player.getSymbol(), colCount);

//        For diagonal map

        if(row==col){
            diagonalCols.put(player.getSymbol(), diagonalCols.getOrDefault(player.getSymbol(), 0) + 1);

        }

//        For Reverse Diagonal
        if( row+col == board.getSize()-1){
            reverseDiagonalCols.put(player.getSymbol(), reverseDiagonalCols.getOrDefault(player.getSymbol(), 0) + 1);

        }

//        check if player is winning

        return colCount == board.getSize() ||
                rowCount == board.getSize() ||
                diagonalCols.getOrDefault(player.getSymbol(), 0) == board.getSize() ||
                reverseDiagonalCols.getOrDefault(player.getSymbol(), 0) == board.getSize();


    }


}
