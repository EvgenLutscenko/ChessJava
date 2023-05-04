package org.example;

import org.example.piece.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    static Scanner scanner = new Scanner(System.in);

    public static Coordinates input(){
        while (true){
            System.out.println("Please enter coordinates (ex. a1)");
            String line = scanner.nextLine();

            if(line.length() != 2){
                System.out.println("Invalid format");
                continue;
            }
            char fileChar;
            char rankChar;
            try {
                fileChar = line.charAt(0);
                rankChar = line.charAt(1);
            }catch (StringIndexOutOfBoundsException e){
                System.out.println("Invalid format");
                continue;
            }

            if(!Character.isLetter(fileChar)){
                System.out.println("Invalid format");
                continue;
            }else if(!Character.isDigit(rankChar)){
                System.out.println("Invalid format");
                continue;
            }

            int rank = Character.getNumericValue(rankChar);

            if(rank < 1 || rank > 9){
                System.out.println("Invalid format");
                continue;
            }
            File file = File.getFilefromChar(fileChar);
            if(file == null){
                System.out.println("Invalid format");
                continue;
            }

            return new Coordinates(file, rank);
        }
    }

    public static Coordinates inputPieceCoordinatesforColor(Color color, Board board){
        while (true){
            Coordinates coordinates = input();
            if(board.isSquareEmpty(coordinates)){
                System.out.println("Empty square");
                continue;
            }

            Piece piece = board.getPiese(coordinates);
            if(piece.color != color){
                System.out.println("Wrong color");
                continue;
            }

            Set<Coordinates> availablecoord = piece.getAvailableMovs(board);
            if(availablecoord.size() == 0){
                System.out.println("Piece can't move");
                continue;
            }

            return coordinates;
        }
    }

    public static Coordinates getAvailableMoovetoUser(Set<Coordinates> coordSet){
        while (true){
            System.out.println("Enter move for seleced piece");
            Coordinates coordinates = input();

            if(!coordSet.contains(coordinates)){
                System.out.println("Not available square");
                continue;
            }

            return coordinates;
        }
    }
}
