package com.epam.figure.comparator;

import com.epam.figure.observer.CubeObservable;
import com.epam.figure.logic.Calculator;

public class ComparatorBySurfaceArea implements CubeComparator {
    private Calculator calculator = new Calculator();

    @Override
    public int compare(CubeObservable first, CubeObservable second){

        int surfaceAreaFirst = calculator.surfaceArea(first);

        int surfaceAreaSecond = calculator.surfaceArea(second);

        return Integer.compare(surfaceAreaFirst, surfaceAreaSecond);
    }
}
