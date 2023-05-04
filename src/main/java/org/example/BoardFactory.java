package org.example;

import org.example.piece.Piece;

public class BoardFactory {

    public static Board fromFen(String fen){
        Board board = new Board();
        String[] parts = fen.split(" ");
        String piecePositions = parts[0];

        String[] fenRows = piecePositions.split("/");

        for (int i = 0; i < fenRows.length; i++) {
            String row = fenRows[i];
            int rank = 8 - i;

            int fileIndex = 0;
            for(int j = 0; j < row.length(); j++){
                char fenChar = row.charAt(j);

                if(Character.isDigit(fenChar)){
                    fileIndex += Character.getNumericValue(fenChar);
                }else {
                    File file = File.values()[fileIndex];
                    Coordinates newcoord = new Coordinates(file, rank);

                    Piece piece = PieceFactory.fromFenChar(fenChar, newcoord);
                    if(piece != null){
                        board.setPiece(newcoord, piece);
                    }
                    fileIndex++;
                }
            }
        }

        return board;
    }
}
