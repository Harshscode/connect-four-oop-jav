package connectfour.controller;

import connectfour.model.Board;
import connectfour.model.GameStatus;
import connectfour.players.ComputerPlayer;
import connectfour.players.HumanPlayer;
import connectfour.players.Player;
import connectfour.rules.WinChecker;
import connectfour.view.ConsoleView;

public class GameController {

    private final ConsoleView view = new ConsoleView();
    private final WinChecker winChecker = new WinChecker();

    public void run() {
        while (true) {
            int choice = view.showStartMenu();

            if (choice == 1) {
                startTwoPlayerGame();
            } else if (choice == 2) {
                startVsComputerGame();
            } else {
                view.showMessage("Goodbye!");
                return;
            }
        }
    }

    private void startTwoPlayerGame() {
        Board board = new Board();
        Player p1 = new HumanPlayer("Player 1", 'X', view);
        Player p2 = new HumanPlayer("Player 2", 'O', view);

        Player current = p1;
        GameStatus status = GameStatus.PLAYING;

        while (status == GameStatus.PLAYING) {
            view.renderBoard(board);
            int col = current.chooseColumn(board); // 0-based column
            int row = board.dropDisc(col, current.getSymbol());

            if (winChecker.hasWon(board, current.getSymbol(), row, col)) {
                status = GameStatus.WIN;
                view.renderBoard(board);
                view.showWinner(current);
            } else if (board.isFull()) {
                status = GameStatus.DRAW;
                view.renderBoard(board);
                view.showDraw();
            } else {
                current = (current == p1) ? p2 : p1;
            }
        }

        view.pauseEnterToContinue();
    }

    private void startVsComputerGame() {
        Board board = new Board();

        Player human = new HumanPlayer("Player", 'X', view);
        Player computer = new ComputerPlayer("Computer", 'O');

        Player current = human;
        GameStatus status = GameStatus.PLAYING;

        while (status == GameStatus.PLAYING) {
            view.renderBoard(board);

            int col = current.chooseColumn(board);
            int row = board.dropDisc(col, current.getSymbol());

            if (winChecker.hasWon(board, current.getSymbol(), row, col)) {
                status = GameStatus.WIN;
                view.renderBoard(board);
                view.showWinner(current);
            } else if (board.isFull()) {
                status = GameStatus.DRAW;
                view.renderBoard(board);
                view.showDraw();
            } else {
                current = (current == human) ? computer : human;
            }
        }

        view.pauseEnterToContinue();
    }
}