package com.epam.figure.entity;

public class Parameters {
    private int surfaceArea;
    private int volume;

    public Parameters(int surfaceArea, int volume){
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (!(o instanceof Parameters)) {
            return false;
        }

        Parameters that = (Parameters) o;

        if (surfaceArea != that.surfaceArea) {
            return false;
        }
        return volume == that.volume;
    }

    @Override
    public int hashCode(){
        int result = surfaceArea;
        result = 31 * result + volume;
        return result;
    }

    @Override
    public String toString(){
        return "Parameters{" +
                "surfaceArea=" + surfaceArea +
                ", volume=" + volume +
                '}';
    }
}
