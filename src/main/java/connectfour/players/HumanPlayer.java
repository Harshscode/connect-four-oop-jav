package connectfour.players;

import connectfour.model.Board;
import connectfour.view.ConsoleView;

public class HumanPlayer extends Player {

    private final ConsoleView view;

    public HumanPlayer(String name, char symbol, ConsoleView view) {
        super(name, symbol);
        this.view = view;
    }

    @Override
    public int chooseColumn(Board board) {
        // returns 0-based column index
        while (true) {
            int col = view.promptForColumn(this); // 1..7
            int zeroBased = col - 1;

            if (!board.canDrop(zeroBased)) {
                view.showMessage("Column is full. Choose another column.");
                continue;
            }
            return zeroBased;
        }
    }
}