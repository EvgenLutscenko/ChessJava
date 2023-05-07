package org.example.GameStatusCheckers;

import org.example.Board.Board;
import org.example.piece.Color;

public abstract class GameStatusChecker {
    public abstract GameStatus checker(Board board, Color color);
}
