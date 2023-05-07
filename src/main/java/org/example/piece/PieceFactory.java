package org.example.piece;

import org.example.Coordinates.Coordinates;
import org.example.piece.*;

public class PieceFactory {
    public static Piece fromFenChar(char fenp, Coordinates coordinates){
        switch (fenp){
            case 'p':
                return new Pawn(coordinates, Color.BLACK);
            case 'P':
                return new Pawn(coordinates, Color.WHITE);
            case 'r':
                return new Rook(coordinates, Color.BLACK);
            case 'R':
                return new Rook(coordinates, Color.WHITE);
            case 'n':
                return new Knight(coordinates, Color.BLACK);
            case 'N':
                return new Knight(coordinates, Color.WHITE);
            case 'b':
                return new Bishop(coordinates, Color.BLACK);
            case 'B':
                return new Bishop(coordinates, Color.WHITE);
            case 'q':
                return new Queen(coordinates, Color.BLACK);
            case 'Q':
                return new Queen(coordinates, Color.WHITE);
            case 'k':
                return new King(coordinates, Color.BLACK);
            case 'K':
                return new King(coordinates, Color.WHITE);
        }
        return null;
    }
}
