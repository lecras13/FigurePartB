package com.epam.figure.entity;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getZ(){
        return z;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }

        Point point = (Point) o;

        if (x != point.x) {
            return false;
        }
        if (y != point.y) {
            return false;
        }
        return z == point.z;
    }

    @Override
    public int hashCode(){
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    @Override
    public String toString(){
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
