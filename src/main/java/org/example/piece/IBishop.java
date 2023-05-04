package org.example.piece;

import org.example.CoordinetesShift;

import java.util.HashSet;
import java.util.Set;

public interface IBishop {
    default Set<CoordinetesShift> getBishopShifts() {
        Set<CoordinetesShift> shifts = new HashSet<>();

        for (int i = -7; i < 7; i++) {
            if(i == 0){
                continue;
            }

            shifts.add(new CoordinetesShift(i, -i));
        }

        for (int i = -7; i < 7; i++) {
            if(i == 0){
                continue;
            }

            shifts.add(new CoordinetesShift(i, i));
        }

        return shifts;
    }
}
