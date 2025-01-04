package factories;

import enums.BotDifficultyLevel;
import models.Board;
import models.Bot;
import models.Move;
import strategies.botPlayingStrategies.BotPlayingStrategy;
import strategies.botPlayingStrategies.EasyPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {

        if (botDifficultyLevel == BotDifficultyLevel.EASY)
            return new EasyPlayingStrategy();
        return new EasyPlayingStrategy();
    }
}
