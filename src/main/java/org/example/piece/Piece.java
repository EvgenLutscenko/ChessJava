package org.example.piece;

import org.example.Board.Board;
import org.example.Coordinates.Coordinates;
import org.example.Coordinates.CoordinetesShift;

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

    public Set<CoordinetesShift> getPieceAttack(){
        return getPieceShifts();
    }

    public Set<Coordinates> getAttackedSquare(Board board) {
        Set<CoordinetesShift> pieceAttack = getPieceAttack();
        Set<Coordinates> result = new HashSet<>();

        for(CoordinetesShift coord : pieceAttack){
            if(coordinates.canshift(coord)){
                Coordinates newCoord = coordinates.shift(coord);

                if(isSquareAvailableForAttack(newCoord, board)){
                    result.add(newCoord);
                }
            }
        }
        return result;
    }

    protected boolean isSquareAvailableForAttack(Coordinates newCoord, Board board) {
        return true;
    }
}
