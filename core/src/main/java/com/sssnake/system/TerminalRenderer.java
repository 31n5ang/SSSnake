package com.sssnake.system;

import com.sssnake.entity.AnsiColor;
import com.sssnake.entity.DisplaySymbol;
import org.jline.terminal.Terminal;

import static com.sssnake.entity.AnsiColor.RESET;

public class TerminalRenderer implements Renderer {

    private final GameMap map;
    private final Terminal terminal;
    private final AnsiColor WALL_COLOR = AnsiColor.BG_MAGENTA;

    public TerminalRenderer(GameMap map, Terminal terminal) {
        this.map = map;
        this.terminal = terminal;
    }

    @Override
    public void render() {

        StringBuilder sb = new StringBuilder();
        sb.append("\033[H");

        renderHeader(sb);
        renderMap(sb);

        terminal.writer().print(sb);
        terminal.writer().flush();
    }

    private void renderHeader(StringBuilder sb) {
        sb.append(" _____  _____  _____  _   _         _          \n" +
                "/  ___|/  ___|/  ___|| \\ | |       | |         \n" +
                "\\ `--. \\ `--. \\ `--. |  \\| |  __ _ | | __  ___ \n" +
                " `--. \\ `--. \\ `--. \\| . ` | / _` || |/ / / _ \\\n" +
                "/\\__/ //\\__/ //\\__/ /| |\\  || (_| ||   < |  __/\n" +
                "\\____/ \\____/ \\____/ \\_| \\_/ \\__,_||_|\\_\\ \\___|").append("\n");
        sb.append("W A S D").append("\n");
        sb.append("- Apple(Score): ").append(Score.getValue()).append("\n");
        sb.append("\n");
    }

    private void renderMap(StringBuilder sb) {
        sb.append(WALL_COLOR.color());
        sb.append(" ");
        sb.append(" ".repeat(map.getWidth()));
        sb.append(" \n");
        sb.append(RESET.color());


        DisplaySymbol[][] grid = map.getGrid();
        for (int y = 0; y < map.getHeight(); y++) {
            sb.append(WALL_COLOR.color());
            sb.append(" ");
            sb.append(RESET.color());
            for (int x = 0; x < map.getWidth(); x++) {
                sb.append(RESET.color());
                sb.append(grid[y][x].getBackgroundColor().color());
                sb.append(grid[y][x].getTextColor().color());
                sb.append(grid[y][x].getSymbol());
                sb.append(RESET.color());
            }
            sb.append(WALL_COLOR.color());
            sb.append(" \n");
            sb.append(RESET.color());
        }

        sb.append(WALL_COLOR.color());
        sb.append(" ");
        sb.append(" ".repeat(map.getWidth()));
        sb.append(" ");
        sb.append(RESET.color());
    }

    @Override
    public void clear() {
        terminal.writer().print("\033[H\033[2J");
        terminal.writer().flush();
    }
}
