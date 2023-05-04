package org.example.piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.CoordinetesShift;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece{

    public Knight(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    public Set<CoordinetesShift> getPieceShifts() {
        return new HashSet<>(Arrays.asList(
                new CoordinetesShift(1, 2),
                new CoordinetesShift(2, 1),

                new CoordinetesShift(2, -1),
                new CoordinetesShift(1, -2),

                new CoordinetesShift(-2, -1),
                new CoordinetesShift(-1, -2),

                new CoordinetesShift(-2, 1),
                new CoordinetesShift(-1, 2)
        ));
    }
}
