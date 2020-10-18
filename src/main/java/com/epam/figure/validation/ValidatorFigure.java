package com.epam.figure.validation;

import com.epam.figure.entity.Point;

import java.util.List;

public interface ValidatorFigure {

    boolean checkFigure(List<Point> points);
}
