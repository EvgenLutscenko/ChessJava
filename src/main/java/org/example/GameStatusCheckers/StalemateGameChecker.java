package org.example.GameStatusCheckers;

import org.example.Board.Board;
import org.example.piece.Color;
import org.example.piece.Piece;

import java.util.List;

public class StalemateGameChecker extends GameStatusChecker{
    @Override
    public GameStatus checker(Board board, Color color) {
        List<Piece> pieces = board.getPiecesByColor(color);

        for(Piece piece : pieces){
            if(piece.getAvailableMovs(board).size() > 0){
                return GameStatus.ONGOING;
            }
        }
        return GameStatus.STALEMATE;
    }
}
