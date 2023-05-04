package org.example;

import org.example.piece.Piece;

import java.sql.Struct;
import java.util.Set;

public class BoardConsoleRenderer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";

    public void render(Board board, Piece piecetoMove) {
        Set<Coordinates> highlightedSquare = null;
        if (piecetoMove != null) {
            highlightedSquare = piecetoMove.getAvailableMovs(board);
        }
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (highlightedSquare != null && highlightedSquare.contains(coordinates) && board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(new Coordinates(file, rank), true);
                } else if (highlightedSquare != null && highlightedSquare.contains(coordinates)) {
                    line += getPieceSprite(board.getPiese(coordinates), true);
                } else if (board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(new Coordinates(file, rank), false);
                } else {
                    line += getPieceSprite(board.getPiese(coordinates), false);
                }
            }
            line += ANSI_RESET;
            System.out.println(line);

        }
    }

    private String colorizeSprite(String sprie, Color pieceColor, boolean isDark, boolean isHighLighted) {
        String result = sprie;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isHighLighted) {
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        } else if (isDark) {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        }

        return result;
    }

    private String selectUnicodeSpriteForPiece(Piece piece) {
        switch (piece.getClass().getSimpleName()) {
            case "Pawn":
                return "♟";

            case "Knight":
                return "♞";

            case "Bishop":
                return "♝";

            case "Rook":
                return "♜";

            case "Queen":
                return "♛";

            case "King":
                return "♚";
        }
        return "";
    }

    private String getPieceSprite(Piece piece, boolean isHighlited) {
        return colorizeSprite(" " + selectUnicodeSpriteForPiece(piece) + " ", piece.color, Board.isSquareDark(piece.coordinates), isHighlited);
    }

    private String getSpriteForEmptySquare(Coordinates coordinates, boolean isHighlited) {

        return colorizeSprite("    ", Color.WHITE, Board.isSquareDark(coordinates), isHighlited);
    }
}
