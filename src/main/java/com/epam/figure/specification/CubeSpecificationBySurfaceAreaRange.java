package com.epam.figure.specification;

import com.epam.figure.observer.CubeObservable;
import com.epam.figure.logic.Calculator;

public class CubeSpecificationBySurfaceAreaRange implements CubeSpecification {
    private int minSurfaceArea;
    private int maxSurfaceArea;
    private Calculator calculator;

    public CubeSpecificationBySurfaceAreaRange(int minSurfaceArea, int maxSurfaceArea){
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
        calculator = new Calculator();
    }

    @Override
    public boolean specified(CubeObservable cubeObservable){
        int surfaceArea = calculator.surfaceArea(cubeObservable);
        if (surfaceArea >= minSurfaceArea && surfaceArea <= maxSurfaceArea) {
            return true;
        } else {
            return false;
        }
    }
}
