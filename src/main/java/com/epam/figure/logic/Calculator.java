package com.epam.figure.logic;

import com.epam.figure.entity.Cube;
import com.epam.figure.entity.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator implements CalculatorFigure {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int surfaceArea(Cube cube){
        int surface = 0;
        Point pointA = cube.getA();
        Point pointB = cube.getB();
        int edgeLengthX = Math.abs(pointA.getX() - pointB.getX());
        int edgeLengthY = Math.abs(pointA.getY() - pointB.getY());
        int edgeLengthZ = Math.abs(pointA.getZ() - pointB.getZ());
        if ((edgeLengthX != 0)) {
            surface = (int) (Math.pow(edgeLengthX, 2)) * 6;
        } else if ((edgeLengthY != 0)) {
            surface = (int) (Math.pow(edgeLengthY, 2)) * 6;
        } else if ((edgeLengthZ != 0)) {
            surface = (int) (Math.pow(edgeLengthZ, 2)) * 6;
        }
        LOGGER.info("Surface is " + surface);
        return surface;
    }

    @Override
    public int volume(Cube cube){
        int volume = 0;
        Point pointС = cube.getC();
        Point pointB = cube.getB();
        int edgeLengthX = Math.abs(pointС.getX() - pointB.getX());
        int edgeLengthY = Math.abs(pointС.getY() - pointB.getY());
        int edgeLengthZ = Math.abs(pointС.getZ() - pointB.getZ());
        if ((edgeLengthX != 0)) {
            volume = (int) Math.pow(edgeLengthX, 3);
        } else if ((edgeLengthY != 0)) {
            volume = (int) Math.pow(edgeLengthY, 3);
        } else if ((edgeLengthZ != 0)) {
            volume = (int) Math.pow(edgeLengthZ, 3);
        }
        LOGGER.info("Volume is " + volume);
        return volume;
    }

    @Override
    public double volumeRatio(Cube cube, String plane){
        switch (plane.toUpperCase()) {
            case "XY":
                return volumeRationByPlaneXY(cube);
            case "XZ":
                return volumeRationByPlaneZX(cube);
            case "YZ":
                return volumeRationByPlaneYZ(cube);
            default:
                LOGGER.log(Level.ERROR, "Wrong name plane!");
                return -1;
        }
    }

    private double volumeRationByPlaneXY(Cube cube){
        Point pointA = cube.getA();
        Point pointA1 = cube.getA1();
        int edgeLengthZ = Math.abs(pointA.getZ() - pointA1.getZ());
        if ((pointA.getZ() >= 0) || (pointA1.getZ() <= 0)) {
            LOGGER.log(Level.ERROR, "The plane XY does not cut the figure!");
        } else {
            double volumeDownPart = (double) edgeLengthZ * edgeLengthZ * Math.abs(pointA.getZ());
            double volumeUpPart = (double) edgeLengthZ * edgeLengthZ * Math.abs(pointA1.getZ());
            return volumeUpPart / volumeDownPart;
        }
        return -1;
    }

    private double volumeRationByPlaneYZ(Cube cube){
        Point pointC = cube.getC();
        Point pointD = cube.getD();
        int edgeLengthX = Math.abs(pointC.getX() - pointD.getX());
        if ((pointD.getX() >= 0) || (pointC.getX() <= 0)) {
            LOGGER.log(Level.ERROR, "The plane XY does not cut the figure!");
        } else {
            double volumeDownPart = edgeLengthX * edgeLengthX * Math.abs(pointC.getZ());
            double volumeUpPart = edgeLengthX * edgeLengthX * Math.abs(pointD.getZ());
            return volumeUpPart / volumeDownPart;
        }
        return -1;
    }

    private double volumeRationByPlaneZX(Cube cube){
        Point pointB = cube.getB();
        Point pointC = cube.getC();
        int edgeLengthY = Math.abs(pointB.getY() - pointC.getY());
        if ((pointB.getY() >= 0) || (pointC.getY() <= 0)) {
            LOGGER.log(Level.ERROR, "The plane XY does not cut the figure!");
        } else {
            double volumeDownPart = edgeLengthY * edgeLengthY * Math.abs(pointB.getZ());
            double volumeUpPart = edgeLengthY * edgeLengthY * Math.abs(pointC.getZ());
            return volumeUpPart / volumeDownPart;
        }
        return -1;
    }
}
