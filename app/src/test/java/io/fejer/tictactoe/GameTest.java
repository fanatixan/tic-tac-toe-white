package io.fejer.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Game")
class GameTest {

    Game game;

    @BeforeEach
    void setup() {
        game = new Game();
    }

    @DisplayName("GIVEN a new game WHEN printing THEN empty board is printed")
    @Test
    void givenNewGameWhenPrintingThenEmptyBoardIsPrinted() {
        // given

        // when
        String message = game.print();

        // then
        assertThat(message).contains("""
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s
                """);
    }

    @DisplayName("GIVEN a new game WHEN printing THEN the message 'Player X moves' is printed")
    @Test
    void givenNewGameWhenPrintingThenXMovesIsPrinted() {
        // given

        // when
        String message = game.print();

        // then
        assertThat(message).contains("Player X moves");
    }

}
