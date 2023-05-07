package org.example.GameStatusCheckers;

import org.example.Board.Board;
import org.example.Board.BoardFactory;
import org.example.Coordinates.Coordinates;
import org.example.piece.Color;
import org.example.piece.King;
import org.example.piece.Piece;

import java.util.List;
import java.util.Set;

public class CheckMateGameStatusGameChecker extends GameStatusChecker{

    @Override
    public GameStatus checker(Board board, Color color) {
        Piece king = board.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();

        if(!board.isSquareAttacedByColor(color.opposite(), king.coordinates)){
            return GameStatus.ONGOING;
        }

        List<Piece> pieces = board.getPiecesByColor(color);

        for(Piece piece : pieces){
            Set<Coordinates> coord = piece.getAvailableMovs(board);
            for(Coordinates coordinates : coord){
                Board clone = BoardFactory.copy(board);
                clone.movePice(piece.coordinates, coordinates);

                Piece clonedKing = clone.getPiecesByColor(color).stream().filter(p -> p instanceof King).findFirst().get();

                if(!clone.isSquareAttacedByColor(color.opposite(), clonedKing.coordinates)){
                    return GameStatus.ONGOING;
                }
            }
        }

        return color == Color.WHITE ? GameStatus.CHECKMATE_TO_WHITE_KING : GameStatus.CHECKMATE_TO_BLACK_KING;
    }
}
