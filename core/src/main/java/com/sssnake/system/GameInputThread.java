package com.sssnake.system;

import com.sssnake.entity.snake.Direction;
import org.jline.terminal.Terminal;

import java.io.IOException;

public class GameInputThread extends Thread {
    private final Terminal terminal;
    private volatile boolean running = true;

    private static volatile Direction nextDir = null;

    public GameInputThread(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public void run() {
        try {
            while (running) {
                int ch = terminal.reader().read();
                switch (ch) {
                    case 'w': case 'W': nextDir = Direction.U; break;
                    case 's': case 'S': nextDir = Direction.D; break;
                    case 'a': case 'A': nextDir = Direction.L; break;
                    case 'd': case 'D': nextDir = Direction.R; break;
                    case 'q': case 'Q': System.exit(0); break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Direction getNextDirection(Direction current) {
        if (nextDir == null) {
            return current;
        }

        if (nextDir.isOpposite(current)) {
            return current;
        } else {
            return nextDir;
        }
    }
}
