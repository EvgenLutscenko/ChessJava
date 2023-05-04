package org.example.piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.CoordinetesShift;

import java.util.Set;

public class Pawn extends Piece{
    @Override
    public Set<CoordinetesShift> getPieceShifts() {
        return null;
    }

    public Pawn(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }
}
