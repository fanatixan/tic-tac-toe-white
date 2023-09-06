package io.fejer.tictactoe;

import java.util.function.IntSupplier;

public class Bot {

    private Board board;
    private IntSupplier random;

    public Bot(Board board, IntSupplier random) {
        this.board = board;
        this.random = random;
    }

    public int nextStep() {
        int step = random.getAsInt();
        if (board.get(step) != Board.EMPTY) {
            step = random.getAsInt();
        }
        return step;
    }
}
