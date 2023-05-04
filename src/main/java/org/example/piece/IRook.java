package org.example.piece;

import org.example.CoordinetesShift;

import java.util.HashSet;
import java.util.Set;

public interface IRook {
    default Set<CoordinetesShift> getRookShifts() {
        Set<CoordinetesShift> shifts = new HashSet<>();

        for (int i = -7; i < 7; i++) {
            if(i == 0){
                continue;
            }

            shifts.add(new CoordinetesShift(i, 0));
        }

        for (int i = -7; i < 7; i++) {
            if(i == 0){
                continue;
            }

            shifts.add(new CoordinetesShift(0, i));
        }

        return shifts;
    }
}
