package com.sssnake.system;

import com.sssnake.entity.AnsiColor;
import org.jline.terminal.Terminal;

public class TerminalGameOverEventListener implements GameOverEventListener {

    private final Terminal terminal;

    public TerminalGameOverEventListener(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public void onGameOver() {
        StringBuilder sb = new StringBuilder();
        sb.append("\033[2J");
        sb.append("\033[H");
        sb.append("Game Over! \nYour score is ");
        sb.append(Score.getValue());
        sb.append(AnsiColor.GREEN.color());
        sb.append(" !");
        sb.append("\n");
        sb.append(AnsiColor.RESET.color());
        terminal.writer().print(sb);
        terminal.writer().flush();

        System.exit(0);
    }
}
