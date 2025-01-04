import controllers.GameController;
import enums.BotDifficultyLevel;
import enums.GameState;
import enums.PlayerType;
import models.Bot;
import models.Game;
import models.Player;
import models.Symbol;
import strategies.winningStrategies.OrderOneWinningStrategy;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        GameController gameController = new GameController();
        System.out.println("Game is starting...");

//        TODO take input from users to get player details

        Player player = new Player("Deepak", 1, PlayerType.HUMAN, new Symbol( '*'));

//        Player player1 = new Player("Simon", 2, PlayerType.HUMAN, new Symbol( '#'));

        Player bot = new Bot("Bot player", 3, PlayerType.BOT, new Symbol('%'), BotDifficultyLevel.EASY);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
//        players.add(player1);
        players.add(bot);

        Game game = gameController.startGame(3, players, new OrderOneWinningStrategy(3));
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);

//            Add undo feature here in future
        }

        if(gameController.checkState(game).equals(GameState.ENDED)){
            gameController.displayBoard(game);
            System.out.println("Winner is " + game.getWinner().getName());
        }else if (gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game is draw!");
        }
    }
}
