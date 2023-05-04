package org.example;

import org.example.piece.*;

import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPiece(Coordinates coordinates, Piece piece){
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

    public void removePiece(Coordinates coordinates){
        pieces.remove(coordinates);
    }

    public void movePice(Coordinates from, Coordinates to){
        Piece piece = getPiese(from);

        removePiece(from);
        setPiece(to, piece);

    }

    public void setDefaultPiecesPosition(){
        for (File file : File.values()){
            setPiece(new Coordinates(file, 2), new Pawn(new Coordinates(file, 2), Color.WHITE));
            setPiece(new Coordinates(file, 7), new Pawn(new Coordinates(file, 7), Color.BLACK));
        }
        setPiece(new Coordinates(File.A, 1), new Rook(new Coordinates(File.A, 1),Color.WHITE));
        setPiece(new Coordinates(File.H, 1), new Rook(new Coordinates(File.H, 1),Color.WHITE));
        setPiece(new Coordinates(File.A, 8), new Rook(new Coordinates(File.A, 8),Color.BLACK));
        setPiece(new Coordinates(File.H, 8), new Rook(new Coordinates(File.H, 8),Color.BLACK));

        // set knights
        setPiece(new Coordinates(File.B, 1), new Knight(new Coordinates(File.B, 1),Color.WHITE));
        setPiece(new Coordinates(File.G, 1), new Knight(new Coordinates(File.G, 1),Color.WHITE));
        setPiece(new Coordinates(File.B, 8), new Knight(new Coordinates(File.B, 8),Color.BLACK));
        setPiece(new Coordinates(File.G, 8), new Knight(new Coordinates(File.G, 8),Color.BLACK));

        // set bishops
        setPiece(new Coordinates(File.C, 1), new Bishop(new Coordinates(File.C, 1),Color.WHITE));
        setPiece(new Coordinates(File.F, 1), new Bishop(new Coordinates(File.F, 1),Color.WHITE));
        setPiece(new Coordinates(File.C, 8), new Bishop(new Coordinates(File.C, 8),Color.BLACK));
        setPiece(new Coordinates(File.F, 8), new Bishop(new Coordinates(File.F, 8),Color.BLACK));

        // set queens
        setPiece(new Coordinates(File.D, 1), new Queen(new Coordinates(File.D, 1),Color.WHITE));
        setPiece(new Coordinates(File.D, 8), new Queen(new Coordinates(File.D, 8),Color.BLACK));

        // set kings
        setPiece(new Coordinates(File.E, 1), new King(new Coordinates(File.E, 1),Color.WHITE));
        setPiece(new Coordinates(File.E, 8), new King(new Coordinates(File.E, 8),Color.BLACK));
    }

    public boolean isSquareEmpty(Coordinates coordinates){
        return !pieces.containsKey(coordinates);
    }

    public Piece getPiese(Coordinates coordinates){
        return pieces.get(coordinates);
    }

    public static boolean isSquareDark(Coordinates coordinates){
        return ((coordinates.file.ordinal() + coordinates.rank) % 2) == 0;
    }
}
