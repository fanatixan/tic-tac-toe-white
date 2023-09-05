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

    @Test
    void givenNewGameWhenPrintingStateThenEmptyBoardIsPrinted() {
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

    @Test
    void givenNewGameWhenPrintingStateThenXMovesIsPrinted() {
        // given

        // when
        String message = game.print();

        // then
        assertThat(message).contains("Player X moves");
    }

}
