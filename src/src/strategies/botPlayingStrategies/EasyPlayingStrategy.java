package strategies.botPlayingStrategies;

import enums.CellState;
import models.Board;
import models.Bot;
import models.Cell;
import models.Move;

public class EasyPlayingStrategy implements BotPlayingStrategy {


    @Override
    public Move makeMove(Board board, Bot bot) {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Cell cell = board.getCell().get(i).get(j);
                if(cell.getCellState()== CellState.EMPTY){
                    cell.setCellState(CellState.FILLED);
                    cell.setPlayer(bot);
                    Move move = new Move();
                    move.setCell(cell);
                    move.setPlayer(bot);
                    return move;

                }
            }
        }
        return null;
    }
}
