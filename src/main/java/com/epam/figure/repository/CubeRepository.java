package com.epam.figure.repository;

import com.epam.figure.observer.CubeObservable;
import com.epam.figure.specification.CubeSpecification;

import java.util.Comparator;
import java.util.List;

public interface CubeRepository {
    void addCube(CubeObservable cube);

    void removeCube(CubeObservable cube);

    void updateCube(CubeObservable cube);

    void sortByTag(Comparator sortByTag);

    List<CubeObservable> query(CubeSpecification cubeSpecification);
}
