package org.example.piece;

import org.example.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends LongRangePiece implements IBishop{
    @Override
    public Set<CoordinetesShift> getPieceShifts() {
        return getBishopShifts();
    }

    public Bishop(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }
}
