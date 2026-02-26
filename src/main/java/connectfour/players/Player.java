package connectfour.players;

import connectfour.model.Board;

public abstract class Player {
    private final String name;
    private final char symbol;

    protected Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    // Polymorphic move choice
    public abstract int chooseColumn(Board board);
}