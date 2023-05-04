package org.example;

import org.example.piece.Piece;

public class Game {
    private final Board board;

    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop(){
        boolean isWhiteMove = true;
        while (true){
            renderer.render(board, null);

            Coordinates coordinates = InputCoordinates.inputPieceCoordinatesforColor(isWhiteMove? Color.WHITE : Color.BLACK, board);
            Piece piece = board.getPiese(coordinates);

            renderer.render(board, piece);

            var avvailablemoveforPiece = piece.getAvailableMovs(board);
            Coordinates targetcoord = InputCoordinates.getAvailableMoovetoUser(avvailablemoveforPiece);

            board.movePice(coordinates, targetcoord);

            isWhiteMove =! isWhiteMove;
        }
    }
}
