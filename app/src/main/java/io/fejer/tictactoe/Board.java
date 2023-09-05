package io.fejer.tictactoe;

import java.util.Arrays;

public class Board {

    private static final String BOARD_TEMPLATE = """
            0|1|2
            -+-+-
            3|4|5
            -+-+-
            6|7|8
            """;

    private char[] board = new char[9];

    public Board() {
        Arrays.fill(board, ' ');
    }

    public String print() {
        String result = BOARD_TEMPLATE;

        for (int i = 0; i < 9; i++) {
            result = result.replace(String.valueOf(i), String.valueOf(board[i]));
        }

        return result;
    }

    public void set(int index, char mark) {
        board[index] = 'X';
    }
}
