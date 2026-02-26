package connectfour.players;

import connectfour.model.Board;
import java.util.Random;

public class ComputerPlayer extends Player {

    private final Random random = new Random();

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int chooseColumn(Board board) {
        System.out.println(getName() + " is thinking...");

        while (true) {
            int col = random.nextInt(Board.COLS); // 0–6
            if (board.canDrop(col)) {
                return col;
            }
        }
    }
}