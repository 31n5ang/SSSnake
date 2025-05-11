package com.sssnake.system;

import com.sssnake.entity.CollisionHandlerManager;
import com.sssnake.entity.item.ItemManager;
import com.sssnake.entity.item.ItemSpawner;
import com.sssnake.entity.item.ScheduledRandomItemSpawner;
import com.sssnake.entity.snake.Direction;
import com.sssnake.entity.snake.Head;
import com.sssnake.entity.snake.Snake;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

import static com.sssnake.system.GameConfig.MAP_HEIGHT;
import static com.sssnake.system.GameConfig.MAP_WIDTH;

public class GameFactory {
    public static Terminal createTerminal() throws IOException {
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();
        terminal.enterRawMode();
        terminal.writer().print("\033[?25l");
        terminal.writer().flush();
        return terminal;
    }

    public static Snake createSnake() {
        return new Snake(new Head(MAP_WIDTH / 2, MAP_HEIGHT / 2), Direction.U);
    }

    public static GameMap createMap() {
        return new GameMap(MAP_WIDTH, MAP_HEIGHT);
    }

    public static Renderer createRenderer(GameMap map, Terminal terminal) {
        return new TerminalRenderer(map, terminal);
    }

    public static ItemManager createItemManager() {
        return new ItemManager();
    }

    public static ItemSpawner createItemSpawner(ItemManager itemManager) {
        return new ScheduledRandomItemSpawner(itemManager);
    }

    public static CollisionHandlerManager createCollisionHandlerManager() {
        return new CollisionHandlerManager();
    }

    public static GameOverEventListener createGameOverEventListener(Terminal terminal) {
        return new TerminalGameOverEventListener(terminal);
    }

    public static GameOverChecker createGameOverChecker(Snake snake) {
        return new TerminalGameOverChecker(snake, MAP_WIDTH, MAP_HEIGHT);
    }

    public static GameInputThread createInput(Terminal terminal) {
        return new GameInputThread(terminal);
    }

    public static GameLoopThread createGameLoop(
            Snake snake,
            GameMap map,
            Renderer renderer,
            CollisionHandlerManager collisionHandlerManager,
            GameOverEventListener gameOverEventListener,
            GameOverChecker gameOverChecker,
            ItemManager itemManager
    ) {
        return new GameLoopThread(snake, map, renderer, collisionHandlerManager, gameOverEventListener, gameOverChecker, itemManager);
    }
}
