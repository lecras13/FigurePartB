package com.epam.figure.logic;

import com.epam.figure.entity.Cube;

public interface CalculatorFigure {
    int surfaceArea(Cube cube);

    int volume(Cube cube);

    double volumeRatio(Cube cube, String plane);

}
