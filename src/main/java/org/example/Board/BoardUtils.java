package org.example.Board;

import org.example.Coordinates.Coordinates;
import org.example.Coordinates.File;

import java.util.ArrayList;
import java.util.List;

public class BoardUtils {
    public static List<Coordinates> getDiagonalCoordinatesBetween(Coordinates sorce, Coordinates target){
        List<Coordinates> diagonal = new ArrayList<>();

        int fileShift = sorce.file.ordinal() < target.file.ordinal()? 1 : -1;
        int rankShift = sorce.rank < target.rank? 1 : -1;

        for(
                int fileIndex = sorce.file.ordinal() + fileShift,
                rankIndex = sorce.rank + rankShift;

                fileIndex != target.file.ordinal() && rankIndex != target.rank;

                fileIndex += fileShift, rankIndex += rankShift
        ){
            diagonal.add(new Coordinates(File.values()[fileIndex], rankIndex));
        }

        return diagonal;
    }

    public static List<Coordinates> getVerticalCoordinatesBetween(Coordinates sorce, Coordinates target){
        List<Coordinates> diagonal = new ArrayList<>();

        int rankShift = sorce.rank < target.rank? 1 : -1;

        for(int rankIndex = sorce.rank + rankShift; rankIndex != target.rank; rankIndex += rankShift){
            diagonal.add(new Coordinates(File.values()[sorce.file.ordinal()], rankIndex));
        }

        return diagonal;
    }

    public static List<Coordinates> getHorizontalCoordinatesBetween(Coordinates sorce, Coordinates target){
        List<Coordinates> diagonal = new ArrayList<>();

        int fileShift = sorce.file.ordinal() < target.file.ordinal()? 1 : -1;

        for(int fileIndex = sorce.file.ordinal() + fileShift; fileIndex != target.file.ordinal(); fileIndex += fileShift){
            diagonal.add(new Coordinates(File.values()[fileIndex], sorce.rank));
        }

        return diagonal;
    }
}
