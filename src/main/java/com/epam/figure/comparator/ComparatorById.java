package com.epam.figure.comparator;

import com.epam.figure.observer.CubeObservable;


public class ComparatorById implements CubeComparator {

    @Override
    public int compare(CubeObservable first, CubeObservable second){
        return Long.compare(first.getId(), second.getId());
    }
}
