package com.epam.figure.entity;

import com.epam.figure.entity.idGenerator.IdGenerator;

import java.util.List;

public class Cube {
    private List<Point> points;
    private long id;

    public Cube(List<Point> points){
        this.points = points;
        this.id = IdGenerator.generateId();
    }

    public long getId(){
        return id;
    }

    public Point getA(){
        return points.get(0);
    }

    public Point getB(){
        return points.get(1);
    }

    public Point getC(){
        return points.get(2);
    }

    public Point getA1(){
        return points.get(4);
    }

    public Point getD(){
        return points.get(3);
    }

    public void setPoints(List<Point> points){
        this.points = points;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cube)) {
            return false;
        }

        Cube cube = (Cube) o;

        return points != null ? points.equals(cube.points) : cube.points == null;
    }

    @Override
    public int hashCode(){
        return points != null ? points.hashCode() : 0;
    }

    @Override
    public String toString(){
        return "Cube{" +
                "points=" + points +
                '}';
    }
}
