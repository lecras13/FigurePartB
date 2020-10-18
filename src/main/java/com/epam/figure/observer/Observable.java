package com.epam.figure.observer;

public interface Observable {
    void attach(Observer o);

    void detach(Observer o);

    void notifyObservers();
}
