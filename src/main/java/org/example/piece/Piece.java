package org.example.piece;

import org.example.Board;
import org.example.Color;
import org.example.Coordinates;
import org.example.CoordinetesShift;

import java.util.HashSet;
import java.util.Set;

public abstract class Piece {
    public Coordinates coordinates;
    public final Color color;

    public Piece(Coordinates coordinates, Color color) {
        this.coordinates = coordinates;
        this.color = color;
    }

    public Set<Coordinates> getAvailableMovs(Board board){
        Set<Coordinates> result = new HashSet<>();
        for (CoordinetesShift coord : getPieceShifts()){
            if(coordinates.canshift(coord)){
                Coordinates newCoordinates = coordinates.shift(coord);

                if(isSquareAvailableForMove(newCoordinates, board)){
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        return  board.isSquareEmpty(coordinates) || board.getPiese(coordinates).color != color;
    }

    public abstract Set<CoordinetesShift> getPieceShifts();
}
