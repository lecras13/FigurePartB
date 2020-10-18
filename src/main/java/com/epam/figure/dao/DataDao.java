package com.epam.figure.dao;

import java.util.List;

public interface DataDao {

    List<String> readData() throws DaoException;

}
