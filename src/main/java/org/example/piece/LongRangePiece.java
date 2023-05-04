package org.example.piece;

import org.example.Board;
import org.example.BoardUtils;
import org.example.Color;
import org.example.Coordinates;

import java.util.List;

public abstract class LongRangePiece extends Piece {
    public LongRangePiece(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean base = super.isSquareAvailableForMove(coordinates, board);

        if (base) {
            List<Coordinates> between = null;
            if (this.coordinates.file == coordinates.file) {
                between = BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);
            } else if (this.coordinates.rank == coordinates.rank) {
                between = BoardUtils.getHorizontalCoordinatesBetween(this.coordinates, coordinates);
            } else {
                between = BoardUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);
            }

            for (Coordinates cord : between) {
                if (!board.isSquareEmpty(cord)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
