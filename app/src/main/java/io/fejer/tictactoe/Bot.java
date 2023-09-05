package io.fejer.tictactoe;

import java.util.function.IntSupplier;

public class Bot {

    private IntSupplier random;

    public Bot(Board board, IntSupplier random) {

        this.random = random;
    }

    public int nextStep() {
        return random.getAsInt();
    }
}
