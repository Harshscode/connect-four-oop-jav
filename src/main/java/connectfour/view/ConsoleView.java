package connectfour.view;

import connectfour.model.Board;
import connectfour.players.Player;

import java.util.Scanner;

public class ConsoleView {

    private final Scanner scanner = new Scanner(System.in);

    public int showStartMenu() {
        while (true) {
            System.out.println("\n=== CONNECT FOUR ===");
            System.out.println("1) Two-Player Game");
            System.out.println("2) Player vs Computer");
            System.out.println("3) Exit");
            System.out.print("Choose: ");

            String line = scanner.nextLine().trim();
            if (line.equals("1"))
                return 1;
            if (line.equals("2"))
                return 2;
            if (line.equals("3"))
                return 3;

            System.out.println("Please enter 1, 2, or 3.");
        }
    }

    public void renderBoard(Board board) {
        System.out.println();

        // Column numbers
        System.out.print(" ");
        for (int c = 1; c <= Board.COLS; c++) {
            System.out.print("  " + c + " ");
        }
        System.out.println();

        // Top border
        printBorder();

        for (int r = 0; r < Board.ROWS; r++) {
            System.out.print("|");
            for (int c = 0; c < Board.COLS; c++) {
                System.out.print(" " + board.getCell(r, c) + " |");
            }
            System.out.println();
        }

        // Bottom border
        printBorder();
    }

    private void printBorder() {
        System.out.print("+");
        for (int c = 0; c < Board.COLS; c++) {
            System.out.print("---+");
        }
        System.out.println();
    }

    public int promptForColumn(Player player) {
        while (true) {
            System.out.print(player.getName() + " (" + player.getSymbol() + "), enter column (1-7): ");
            String line = scanner.nextLine().trim();
            try {
                int col = Integer.parseInt(line);
                if (col >= 1 && col <= Board.COLS)
                    return col;
                System.out.println("Out of range. Enter 1 to 7.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 7.");
            }
        }
    }

    public void showWinner(Player player) {
        System.out.println(player.getName() + " wins!");
    }

    public void showDraw() {
        System.out.println("It's a draw!");
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void pauseEnterToContinue() {
        System.out.print("Press ENTER to return to start menu...");
        scanner.nextLine();
    }
}