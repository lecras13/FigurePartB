package com.epam.figure.dao;

import com.epam.figure.dao.impl.DataDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final DataDao dataDao = new DataDaoImpl();

    private DaoFactory(){
    }

    public DataDao getDataDao(){
        return dataDao;
    }

    public static DaoFactory getInstance(){
        return instance;
    }
}
