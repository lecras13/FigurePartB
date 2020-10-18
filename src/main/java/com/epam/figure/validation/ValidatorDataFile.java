package com.epam.figure.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ValidatorDataFile implements ValidatorData {
    private static final Logger LOGGER = LogManager.getLogger(ValidatorDataFile.class.getName());

    @Override
    public boolean checkData(List<String> listCoordinate){
        if (listCoordinate.size() == 24) {
            try {
                for (int j = 0; j < listCoordinate.size(); j++) {
                    int i = Integer.parseInt(listCoordinate.get(j));
                }
                return true;
            } catch (NumberFormatException e) {
                LOGGER.warn("Wrong number format");
                return false;
            }
        } else {
            LOGGER.warn("Wrong number point coordinates");
            return false;
        }
    }
}
