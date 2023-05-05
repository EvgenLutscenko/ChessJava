package org.example.piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.CoordinetesShift;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece{
    @Override
    public Set<CoordinetesShift> getPieceShifts() {
        Set<CoordinetesShift> shifts = new HashSet<>();

        if(this.color == Color.WHITE){
            shifts.add(new CoordinetesShift(0, 1));

            if (coordinates.rank == 2){
                shifts.add(new CoordinetesShift(0, 2));
            }
        }else {
            shifts.add(new CoordinetesShift(0, -1));

            if (coordinates.rank == 7){
                shifts.add(new CoordinetesShift(0, -2));
            }
        }


        return shifts;
    }

    public Pawn(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }
}
