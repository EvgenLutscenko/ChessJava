package org.example.Coordinates;


import java.util.Objects;

public class Coordinates {
    public final File file;

    public final Integer rank;

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    public Coordinates shift(CoordinetesShift coordShift) {
        Coordinates coordinates = new Coordinates(File.values()[this.file.ordinal() + coordShift.fileshift], this.rank + coordShift.rankshift);
        return coordinates;
    }

    public boolean canshift(CoordinetesShift shift) {
        int f = file.ordinal() + shift.fileshift;
        int r = rank + shift.rankshift;

        if ((f < 0 || f >= 8) || (r <= 0 || r > 8)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return file == that.file && rank.equals(that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}
