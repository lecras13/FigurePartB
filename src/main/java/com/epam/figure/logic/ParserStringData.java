package com.epam.figure.logic;

import com.epam.figure.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParserStringData {
    private static final Logger LOGGER = LogManager.getLogger();

    public List<String> parseLines(String data){
        LOGGER.info("Parse lines to coordinates");
        List<String> getPointCoordinates = new ArrayList<>();
        String[] s = data.split("\\s?;\\s");
        for (int i = 0; i < s.length; i++) {
            String[] parameters = s[i].split("=");
            String parameter = null;
            if (parameters.length == 2) {
                parameter = s[i].split("=")[1];
            }
            getPointCoordinates.add(parameter);
        }
        return getPointCoordinates;
    }

    public List<Point> parseLinesToPoints(List<String> pointsCoordinate){
        List<Point> point = new ArrayList<>();
        LOGGER.info("Creating points");
        for (int i = 0; i < pointsCoordinate.size(); i += 3) {
            int x = Integer.parseInt(pointsCoordinate.get(i));
            int y = Integer.parseInt(pointsCoordinate.get(i + 1));
            int z = Integer.parseInt(pointsCoordinate.get(i + 2));
            point.add(new Point(x, y, z));
        }
        return point;
    }
}
