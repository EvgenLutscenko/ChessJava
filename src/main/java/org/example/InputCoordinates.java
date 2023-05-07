package org.example;

import org.example.Board.Board;
import org.example.Board.BoardConsoleRenderer;
import org.example.Board.BoardFactory;
import org.example.Coordinates.Coordinates;
import org.example.Coordinates.File;
import org.example.Coordinates.Move;
import org.example.piece.Color;
import org.example.piece.King;
import org.example.piece.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    static Scanner scanner = new Scanner(System.in);

    public static Coordinates input() {
        while (true) {
            System.out.println("Please enter coordinates (ex. a1)");
            String line = scanner.nextLine();

            if (line.length() != 2) {
                System.out.println("Invalid format");
                continue;
            }
            char fileChar;
            char rankChar;
            try {
                fileChar = line.charAt(0);
                rankChar = line.charAt(1);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid format");
                continue;
            }

            if (!Character.isLetter(fileChar)) {
                System.out.println("Invalid format");
                continue;
            } else if (!Character.isDigit(rankChar)) {
                System.out.println("Invalid format");
                continue;
            }

            int rank = Character.getNumericValue(rankChar);

            if (rank < 1 || rank > 9) {
                System.out.println("Invalid format");
                continue;
            }
            File file = File.getFilefromChar(fileChar);
            if (file == null) {
                System.out.println("Invalid format");
                continue;
            }

            return new Coordinates(file, rank);
        }
    }

    public static Coordinates inputPieceCoordinatesforColor(Color color, Board board) {
        while (true) {
            Coordinates coordinates = input();
            if (board.isSquareEmpty(coordinates)) {
                System.out.println("Empty square");
                continue;
            }

            Piece piece = board.getPiese(coordinates);
            if (piece.color != color) {
                System.out.println("Wrong color");
                continue;
            }

            Set<Coordinates> availablecoord = piece.getAvailableMovs(board);
            if (availablecoord.size() == 0) {
                System.out.println("Piece can't move");
                continue;
            }

            return coordinates;
        }
    }

    public static Coordinates getAvailableMoovetoUser(Set<Coordinates> coordSet) {
        while (true) {
            System.out.println("Enter move for seleced piece");
            Coordinates coordinates = input();

            if (!coordSet.contains(coordinates)) {
                System.out.println("Not available square");
                continue;
            }

            return coordinates;
        }
    }

    public static Move inputMove(Board board, Color color, BoardConsoleRenderer renderer) {
        while (true) {
            Coordinates coordinates = InputCoordinates.inputPieceCoordinatesforColor(color, board);
            Piece piece = board.getPiese(coordinates);

            renderer.render(board, piece);

            var avvailablemoveforPiece = piece.getAvailableMovs(board);
            Coordinates targetcoord = InputCoordinates.getAvailableMoovetoUser(avvailablemoveforPiece);

            Move move = new Move(coordinates, targetcoord);

            if (checkIfKingUnderAttackAfterMove(board, color, move)) {
                System.out.println("King over attack!");
                renderer.render(board, null);
                continue;
            }

            return move;
        }

    }

    private static boolean checkIfKingUnderAttackAfterMove(Board board, Color color, Move move) {
        Board copy = BoardFactory.copy(board);
        copy.movePice(move.from, move.to);

        //we trust that there is king on the board
        Piece king = copy.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();
        return copy.isSquareAttacedByColor(color.opposite(), king.coordinates);
    }
}
