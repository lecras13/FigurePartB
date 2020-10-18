package com.epam.figure.observer;

import com.epam.figure.entity.Cube;
import com.epam.figure.entity.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CubeObservable extends Cube implements Observable {
    private List<Observer> observers;

    public CubeObservable(List<Point> points){
        super(points);
        this.observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer){
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void setPoints(List<Point> points){
        this.setPoints(points);
        notifyObservers();
    }

    public List<Observer> getObservers(){
        return observers;
    }

    @Override
    public void notifyObservers(){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CubeObservable that = (CubeObservable) o;
        return Objects.equals(observers, that.observers);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), observers);
    }

    @Override
    public String toString(){
        return "CubeObservable{" +
                "observers=" + observers +
                '}';
    }
}
