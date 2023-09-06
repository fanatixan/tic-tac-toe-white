package io.fejer.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.function.IntSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("Bot")
class BotTest {

    Bot bot;
    @Mock
    Board board;
    @Mock
    IntSupplier random;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        bot = new Bot(board, random);

        when(board.get(anyInt())).thenReturn(Board.EMPTY);
    }

    @DisplayName("WHEN getting next step THEN random step is returned")
    @Test
    void whenGettingNextStepThenRandomStepIsReturned() {
        // given
        int randomValue = 4;
        when(random.getAsInt()).thenReturn(randomValue);

        // when
        int step = bot.nextStep();

        // then
        assertThat(step).isEqualTo(randomValue);
        verify(random, atLeastOnce()).getAsInt();
    }

    @DisplayName("GIVEN random returns non-empty cell WHEN getting next step THEN new cell generated")
    @Test
    void givenNonEmptyCellWhenGettingNextStepThenRandomStepIsReturned() {
        // given
        when(random.getAsInt()).thenReturn(4).thenReturn(5);
        when(board.get(4)).thenReturn('X');

        // when
        int step = bot.nextStep();

        // then
        assertThat(step).isEqualTo(5);
    }

}
