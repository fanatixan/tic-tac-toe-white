/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package io.fejer.tictactoe;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);

        Random random = new Random();
        Bot bot = new Bot(board, () -> random.nextInt(9));

        game.start(bot, System.out::println, App::sleep);
    }

    private static void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
