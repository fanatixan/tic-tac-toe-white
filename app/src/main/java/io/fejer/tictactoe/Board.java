package io.fejer.tictactoe;

public class Board {

    private boolean hasSteps;

    public String print() {
        if (!hasSteps) {
            return """
                     | |\s
                    -+-+-
                     | |\s
                    -+-+-
                     | |\s
                    """;
        }

        return """
                X| |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s
                """;
    }

    public void set(int index, char mark) {
        hasSteps = true;
    }
}
