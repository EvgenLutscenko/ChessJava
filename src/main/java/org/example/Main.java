package org.example;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.fromFen(
                //"8/4r3/8/2N3b1/8/4Q3/1R6/6B1 w - - 0 1"
                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
        );

        Game game = new Game(board);
        game.gameLoop();

    }
}
