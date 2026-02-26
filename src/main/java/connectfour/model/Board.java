package connectfour.model;

public class Board {
    public static final int ROWS = 6;
    public static final int COLS = 7;

    private final char[][] grid;

    public Board() {
        grid = new char[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                grid[r][c] = '.';
            }
        }
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean canDrop(int col) {
        if (col < 0 || col >= COLS) return false;
        return grid[0][col] == '.';
    }

    /**
     * Drops a disc into a column. Assumes canDrop(col) is true.
     * @return the row index where the disc landed.
     */
    public int dropDisc(int col, char symbol) {
        for (int r = ROWS - 1; r >= 0; r--) {
            if (grid[r][col] == '.') {
                grid[r][col] = symbol;
                return r;
            }
        }
        // Should never happen if canDrop was checked.
        throw new IllegalStateException("Column is full: " + col);
    }

    public boolean isFull() {
        for (int c = 0; c < COLS; c++) {
            if (grid[0][c] == '.') return false;
        }
        return true;
    }
}