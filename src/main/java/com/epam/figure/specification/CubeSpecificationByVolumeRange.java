package com.epam.figure.specification;

import com.epam.figure.observer.CubeObservable;
import com.epam.figure.logic.Calculator;

public class CubeSpecificationByVolumeRange implements CubeSpecification {
    private int minVolume;
    private int maxVolume;
    private Calculator calculator;

    public CubeSpecificationByVolumeRange(int minVolume, int maxVolume){
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        calculator = new Calculator();
    }

    @Override
    public boolean specified(CubeObservable cubeObservable){
        int volume = calculator.volume(cubeObservable);
        if (volume >= minVolume && volume <= maxVolume) {
            return true;
        } else {
            return false;
        }
    }
}
