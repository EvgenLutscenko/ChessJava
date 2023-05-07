package org.example.piece;

import org.example.Coordinates.Coordinates;
import org.example.Coordinates.CoordinetesShift;

import java.util.Set;

public class Rook extends LongRangePiece implements IRook{
    @Override
    public Set<CoordinetesShift> getPieceShifts() {
        return getRookShifts();
    }

    public Rook(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }
}
