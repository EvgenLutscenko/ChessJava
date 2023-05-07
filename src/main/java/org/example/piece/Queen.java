package org.example.piece;

import org.example.Coordinates.Coordinates;
import org.example.Coordinates.CoordinetesShift;

import java.util.HashSet;
import java.util.Set;

public class Queen extends LongRangePiece implements IRook, IBishop{
    public Queen(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    public Set<CoordinetesShift> getPieceShifts() {
        Set<CoordinetesShift> result = new HashSet<>();
        result.addAll(getRookShifts());
        result.addAll(getBishopShifts());
        return result;
    }
}
