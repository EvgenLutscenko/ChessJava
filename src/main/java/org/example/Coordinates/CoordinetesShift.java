package org.example.Coordinates;

import java.util.Objects;

public class CoordinetesShift {
    public final int fileshift;

    public final int rankshift;

    public CoordinetesShift(int fileshift, int rankshift) {
        this.fileshift = fileshift;
        this.rankshift = rankshift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinetesShift that = (CoordinetesShift) o;
        return fileshift == that.fileshift && rankshift == that.rankshift;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileshift, rankshift);
    }
}
