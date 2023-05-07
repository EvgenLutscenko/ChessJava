package org.example;

import org.example.Board.Board;
import org.example.Board.BoardConsoleRenderer;
import org.example.Coordinates.Move;
import org.example.GameStatusCheckers.CheckMateGameStatusGameChecker;
import org.example.GameStatusCheckers.GameStatus;
import org.example.GameStatusCheckers.GameStatusChecker;
import org.example.GameStatusCheckers.StalemateGameChecker;
import org.example.piece.Color;

import java.util.Collections;
import java.util.List;

public class Game {
    private final Board board;

    private final List<GameStatusChecker> gameStatuscheckers = List.of(
            new CheckMateGameStatusGameChecker(), new StalemateGameChecker()
    );

    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop(){
        Color colorToMove = Color.WHITE;

        GameStatus status = determinGameCheck(board,colorToMove);
        while (status == GameStatus.ONGOING){
            renderer.render(board, null);

            Move move = InputCoordinates.inputMove(board, colorToMove, renderer);

            board.movePice(move.from, move.to);

            colorToMove = colorToMove.opposite();
            status = determinGameCheck(board, colorToMove);
        }

        renderer.render(board, null);
        System.out.println("Geme ended with status: " + status);
        System.out.println("---------------------!!!!!GAME OVER!!!!!---------------------");
    }

    private GameStatus determinGameCheck(Board board, Color color) {
        for(GameStatusChecker checkers : gameStatuscheckers){
            GameStatus status = checkers.checker(board, color);

            if(status != GameStatus.ONGOING){
                return status;
            }
        }
        return GameStatus.ONGOING;
    }
}
