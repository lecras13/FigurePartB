package com.epam.figure.comparator;

import com.epam.figure.observer.CubeObservable;
import com.epam.figure.logic.Calculator;


public class ComparatorByVolume implements CubeComparator {
    private Calculator calculator = new Calculator();

    @Override
    public int compare(CubeObservable first, CubeObservable second){

        int volumeFirst = calculator.volume(first);

        int volumeSecond = calculator.volume(second);

        return Integer.compare(volumeFirst, volumeSecond);
    }
}
