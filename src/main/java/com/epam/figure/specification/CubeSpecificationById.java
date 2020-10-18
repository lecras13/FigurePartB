package com.epam.figure.specification;

import com.epam.figure.observer.CubeObservable;

public class CubeSpecificationById implements CubeSpecification {
    private long id;

    public CubeSpecificationById(long id){
        this.id = id;
    }

    @Override
    public boolean specified(CubeObservable cubeObservable){
        if (id == cubeObservable.getId()) {
            return true;
        } else {
            return false;
        }
    }
}
