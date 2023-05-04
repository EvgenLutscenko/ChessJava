package org.example.piece;

import org.example.*;

import java.util.HashSet;
import java.util.List;
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
