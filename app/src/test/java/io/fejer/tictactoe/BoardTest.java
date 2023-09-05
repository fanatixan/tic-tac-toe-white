package io.fejer.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Board")
class BoardTest {

    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    void givenNewBoardWhenPrintingThenEmptyGridIsReturned() {
        // given

        // when
        String printedBoard = board.print();

        // then
        assertThat(printedBoard).isEqualTo(
                """
                         | |\s
                        -+-+-
                         | |\s
                        -+-+-
                         | |\s
                        """
        );
    }

    @Test
    void givenXMarkInTheTopLeftCornerWhenPrintingThenMarkIsPrinted() {
        // given
        board.set(0, 'X');

        // when
        String printedBoard = board.print();

        // then
        assertThat(printedBoard).isEqualTo(
                """
                        X| |\s
                        -+-+-
                         | |\s
                        -+-+-
                         | |\s
                        """
        );
    }

    @Test
    void givenXMarkInTheTopRightCornerWhenPrintingThenMarkIsPrinted() {
        // given
        board.set(2, 'X');

        // when
        String printedBoard = board.print();

        // then
        assertThat(printedBoard).isEqualTo(
                """
                         | |X
                        -+-+-
                         | |\s
                        -+-+-
                         | |\s
                        """
        );
    }

    @Test
    void givenMultipleXMarksWhenPrintingThenAllMarksArePrinted() {
        // given
        board.set(4, 'X');
        board.set(8, 'X');
        board.set(5, 'X');

        // when
        String printedBoard = board.print();

        // then
        assertThat(printedBoard).isEqualTo(
                """
                         | |\s
                        -+-+-
                         |X|X
                        -+-+-
                         | |X
                        """
        );
    }

}
