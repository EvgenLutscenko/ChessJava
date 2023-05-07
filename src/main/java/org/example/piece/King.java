package org.example.piece;

import org.example.Board.Board;
import org.example.Coordinates.Coordinates;
import org.example.Coordinates.CoordinetesShift;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece{
    @Override
    public Set<CoordinetesShift> getPieceShifts() {
        Set<CoordinetesShift> shifts = new HashSet<>();

        for(int fileShift = -1; fileShift < 2; fileShift++){
            for(int rankshift = -1; rankshift < 2; rankshift++){
                if(fileShift == 0 && rankshift == 0){
                    continue;
                }

                shifts.add(new CoordinetesShift(fileShift, rankshift));
            }
        }
        return shifts;
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean base =  super.isSquareAvailableForMove(coordinates, board);

        if(base){
            return !board.isSquareAttacedByColor(this.color.opposite(), coordinates);
        }
        return false;
    }

    public King(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }
}
