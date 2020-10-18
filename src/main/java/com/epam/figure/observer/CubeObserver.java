package com.epam.figure.observer;

import com.epam.figure.entity.Parameters;
import com.epam.figure.logic.Calculator;

import java.util.HashMap;
import java.util.Map;

public class CubeObserver implements Observer {
    private static Map<Long, Parameters> map = new HashMap<>();
    private Calculator calculator;

    private CubeObserver(){
        calculator = new Calculator();
    }

    public static CubeObserver getCubeObserver(){
        return new CubeObserver();
    }

    public static Map<Long, Parameters> getMap(){
        return map;
    }

    @Override
    public void update(CubeObservable cubeObservable){
        int area = calculator.surfaceArea(cubeObservable);
        int volume = calculator.volume(cubeObservable);
        map.put(cubeObservable.getId(), new Parameters(area, volume));
    }
}

