package com.epam.figure.dao.impl;

import com.epam.figure.dao.DataDao;
import com.epam.figure.dao.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataDaoImpl implements DataDao {
    private static final String FILEPATH = "src/main/resources/cube_db.txt";
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readData() throws DaoException{
        List<String> listData = new ArrayList<>();
        LOGGER.info("Reading lines from file");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
            String line;
            while ((line = reader.readLine()) != null) {
                listData.add(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new DaoException(e);
        }
        return listData;
    }
}

