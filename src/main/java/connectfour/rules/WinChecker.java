package connectfour.rules;

import connectfour.model.Board;

public class WinChecker {

    public boolean hasWon(Board board, char symbol, int lastRow, int lastCol) {
        // Check 4 directions: horizontal, vertical, diag \, diag /
        return countInDirection(board, symbol, lastRow, lastCol, 0, 1)   >= 4 || // →
               countInDirection(board, symbol, lastRow, lastCol, 1, 0)   >= 4 || // ↓
               countInDirection(board, symbol, lastRow, lastCol, 1, 1)   >= 4 || // ↘
               countInDirection(board, symbol, lastRow, lastCol, 1, -1)  >= 4;   // ↙
    }

    private int countInDirection(Board board, char symbol, int r, int c, int dr, int dc) {
        // Count discs in both directions from the last move, including the last cell itself
        int count = 1;
        count += countOneSide(board, symbol, r, c, dr, dc);
        count += countOneSide(board, symbol, r, c, -dr, -dc);
        return count;
    }

    private int countOneSide(Board board, char symbol, int r, int c, int dr, int dc) {
        int cnt = 0;
        int rr = r + dr;
        int cc = c + dc;

        while (rr >= 0 && rr < Board.ROWS && cc >= 0 && cc < Board.COLS) {
            if (board.getCell(rr, cc) != symbol) break;
            cnt++;
            rr += dr;
            cc += dc;
        }
        return cnt;
    }
}