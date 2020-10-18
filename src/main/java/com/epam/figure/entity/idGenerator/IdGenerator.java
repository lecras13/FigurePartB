package com.epam.figure.entity.idGenerator;

public class IdGenerator {
    public static long inc = 1;

    public IdGenerator(){
    }

    public static long generateId(){
        long id = inc;
        inc++;
        return id;
    }
}
