package models;

import enums.BotDifficultyLevel;
import enums.PlayerType;
import factories.BotPlayingStrategyFactory;
import strategies.botPlayingStrategies.BotPlayingStrategy;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, int id, PlayerType playerType, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, id, playerType, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Bot Move for " + this.getName());
        BotPlayingStrategy botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
        return botPlayingStrategy.makeMove(board, this);
    }
}
