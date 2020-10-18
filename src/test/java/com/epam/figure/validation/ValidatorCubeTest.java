package com.epam.figure.validation;

import com.epam.figure.entity.Point;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class ValidatorCubeTest {

    @DataProvider
    public static Object[][] testProvider(){

        Object[][] objects = {
                {new Point(0, 0, 0), new Point(1, 0, 0), new Point(1, 1, 0),
                        new Point(0, 1, 0), new Point(0, 0, 1), new Point(1, 0, 1),
                        new Point(1, 1, 1), new Point(0, 1, 1), true},
                {new Point(0, 0, 0), new Point(1, 0, 0), new Point(1, 1, 0),
                        new Point(0, 1, 0), new Point(1, 0, 1), new Point(1, 0, 1),
                        new Point(1, 1, 1), new Point(0, 1, 1), false}
        }; return objects;
    }

    @Test
    @UseDataProvider("testProvider")
    public void testCheckFigureFormAndLocation(Point a, Point b, Point c, Point d, Point a1, Point b1, Point c1, Point d1, boolean flag){
        List<Point> list = Arrays.asList(a, b, c, d, a1, b1, c1, d1);

        ValidatorFigure validatorFigure = new ValidatorCube();
        boolean result = validatorFigure.checkFigure(list);

        Assert.assertEquals(result, flag);
    }
}