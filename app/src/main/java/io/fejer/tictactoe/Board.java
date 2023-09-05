package io.fejer.tictactoe;

public class Board {

    private int step = -1;

    public String print() {
        if (step == -1) {
            return """
                     | |\s
                    -+-+-
                     | |\s
                    -+-+-
                     | |\s
                    """;
        }

        if (step == 0) {
            return """
                    X| |\s
                    -+-+-
                     | |\s
                    -+-+-
                     | |\s
                    """;
        }

        return """
                 | |X
                -+-+-
                 | |\s
                -+-+-
                 | |\s
                """;
    }

    public void set(int index, char mark) {
        step = index;
    }
}
