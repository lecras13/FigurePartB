package com.epam.figure.validation;

import com.epam.figure.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ValidatorCube implements ValidatorFigure {

    private static final Logger LOGGER = LogManager.getLogger(ValidatorCube.class.getName());

    @Override
    public boolean checkFigure(List<Point> points){
        Point a = points.get(0);
        Point b = points.get(1);
        Point c = points.get(2);
        Point d = points.get(3);
        Point a1 = points.get(4);
        Point b1 = points.get(5);
        Point c1 = points.get(6);
        Point d1 = points.get(7);

        boolean faceFirst = checkPlanes(a, b, c, d);
        boolean faceSecond = checkPlanes(a1, b1, c1, d1);
        boolean faceThird = checkPlanes(a, a1, b, b1);
        boolean faceFourth = checkPlanes(b, b1, c1, c);
        boolean faceFifth = checkPlanes(c, c1, d1, d);
        boolean faceSixth = checkPlanes(d, d1, a1, a);
        boolean edge = checkEdge(a, b, a1, d);
        if ((faceFirst && faceSecond && faceThird && faceFourth && faceFifth && faceSixth && edge)) {
            return true;
        } else {
            LOGGER.warn("Not a cube");
            return false;
        }
    }

    private static boolean checkPlanes(Point a, Point b, Point c, Point d){
        if ((a.getX() == b.getX()) && (c.getX() == d.getX()) && (a.getX() == d.getX())
                || ((a.getY() == b.getY()) && (c.getY() == d.getY()) && (a.getY() == d.getY()))
                || ((a.getZ() == b.getZ()) && (c.getZ() == d.getZ()) && (a.getZ() == d.getZ()))) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkEdge(Point a, Point b, Point a1, Point d){
        return (Math.abs(a.getY() - d.getY()) == Math.abs(a.getZ() - a1.getZ()) && (Math.abs(a.getY() - d.getY()) == (Math.abs(a.getX() - b.getX()))));
    }
}
