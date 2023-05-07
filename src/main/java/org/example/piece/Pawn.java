package org.example.piece;

import org.example.Board.Board;
import org.example.Board.BoardUtils;
import org.example.Coordinates.Coordinates;
import org.example.Coordinates.CoordinetesShift;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {
    @Override
    public Set<CoordinetesShift> getPieceShifts() {
        Set<CoordinetesShift> shifts = new HashSet<>();

        if (this.color == Color.WHITE) {
            shifts.add(new CoordinetesShift(0, 1));

            if (coordinates.rank == 2) {
                shifts.add(new CoordinetesShift(0, 2));
            }

            shifts.add(new CoordinetesShift(1, 1));
            shifts.add(new CoordinetesShift(-1, 1));
        } else {
            shifts.add(new CoordinetesShift(0, -1));

            if (coordinates.rank == 7) {
                shifts.add(new CoordinetesShift(0, -2));
            }

            shifts.add(new CoordinetesShift(-1, -1));
            shifts.add(new CoordinetesShift(1, -1));
        }


        return shifts;
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        if(this.coordinates.file == coordinates.file){
            int range = Math.abs(this.coordinates.rank - coordinates.rank);

            if(range == 2){
                var between = BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);

                return (board.isSquareEmpty(between.get(0)) && board.isSquareEmpty(coordinates));
            }else {
                return board.isSquareEmpty(coordinates);
            }
        }else {
            if(board.isSquareEmpty(coordinates)){
                return false;
            }else {
                if(board.getPiese(coordinates).color != this.color){
                    return true;
                }else {
                    return false;
                }
            }
        }
    }

    @Override
    public Set<CoordinetesShift> getPieceAttack() {
        Set<CoordinetesShift> shifts = new HashSet<>();

        if (this.color == Color.WHITE) {
            shifts.add(new CoordinetesShift(1, 1));
            shifts.add(new CoordinetesShift(-1, 1));
        }else {
            shifts.add(new CoordinetesShift(-1, -1));
            shifts.add(new CoordinetesShift(1, -1));
        }

        return shifts;
    }

    public Pawn(Coordinates coordinates, Color color) {
            super(coordinates, color);
        }
    }
