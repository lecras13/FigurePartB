package com.epam.figure.logic;

import com.epam.figure.entity.Cube;
import com.epam.figure.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class CalculatorTest {

    @DataProvider
    public static Object[][] testProviderRightParameters(){
        Point a = new Point(-2, -2, -2);
        Point b = new Point(2, -2, -2);
        Point c = new Point(2, 2, -2);
        Point d = new Point(-2, 2, -2);
        Point a1 = new Point(-2, -2, 2);
        Point b1 = new Point(2, -2, 2);
        Point c1 = new Point(2, 2, 2);
        Point d1 = new Point(-2, 2, 2);

        return new Object[][]{
                {a, b, c, d, a1, b1, c1, d1}
        };
    }

    @DataProvider
    public static Object[][] testProviderWrongParameters(){
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(1, 1, 0);
        Point d = new Point(0, 1, 0);
        Point a1 = new Point(0, 0, 1);
        Point b1 = new Point(1, 0, 1);
        Point c1 = new Point(1, 1, 1);
        Point d1 = new Point(0, 1, 1);

        return new Object[][]{
                {a, b, c, d, a1, b1, c1, d1}
        };
    }

    @Test
    @UseDataProvider("testProviderRightParameters")
    public void testSurfaceAreaShouldCalculateResult(Point a, Point b, Point c, Point d, Point a1, Point b1, Point c1, Point d1){
        List<Point> list = Arrays.asList(a, b, c, d, a1, b1, c1, d1);
        Cube cube = new Cube(list);

        Calculator calculator = new Calculator();
        int surface = calculator.surfaceArea(cube);

        Assert.assertEquals(surface, 96);
    }

    @Test
    @UseDataProvider("testProviderRightParameters")
    public void testVolumeShouldCalculateResult(Point a, Point b, Point c, Point d, Point a1, Point b1, Point c1, Point d1){
        List<Point> list = Arrays.asList(a, b, c, d, a1, b1, c1, d1);
        Cube cube = new Cube(list);

        Calculator calculator = new Calculator();
        int volume = calculator.volume(cube);

        Assert.assertEquals(volume, 64);
    }

    @Test
    @UseDataProvider("testProviderWrongParameters")
    public void testVolumeRatioWhenPlaneXyNotCutCube(Point a, Point b, Point c, Point d, Point a1, Point b1, Point c1, Point d1){
        List<Point> list = Arrays.asList(a, b, c, d, a1, b1, c1, d1);
        Cube cube = new Cube(list);

        Calculator calculator = new Calculator();
        double volume = calculator.volumeRatio(cube, "XY");

        Assert.assertEquals(volume, -1, 0.1);
    }

    @Test
    @UseDataProvider("testProviderWrongParameters")
    public void testVolumeRatioWhenPlaneXzNotCutCube(Point a, Point b, Point c, Point d, Point a1, Point b1, Point c1, Point d1){
        List<Point> list = Arrays.asList(a, b, c, d, a1, b1, c1, d1);
        Cube cube = new Cube(list);

        Calculator calculator = new Calculator();
        double volume = calculator.volumeRatio(cube, "XZ");

        Assert.assertEquals(volume, -1, 0.1);
    }

    @Test
    @UseDataProvider("testProviderWrongParameters")
    public void testVolumeRatioWhenPlaneYzNotCutCube(Point a, Point b, Point c, Point d, Point a1, Point b1, Point c1, Point d1){
        List<Point> list = Arrays.asList(a, b, c, d, a1, b1, c1, d1);
        Cube cube = new Cube(list);

        Calculator calculator = new Calculator();
        double volume = calculator.volumeRatio(cube, "YZ");

        Assert.assertEquals(volume, -1, 0.1);
    }

    @Test
    @UseDataProvider("testProviderWrongParameters")
    public void testVolumeRatioWhenPlaneNotRight(Point a, Point b, Point c, Point d, Point a1, Point b1, Point c1, Point d1){
        List<Point> list = Arrays.asList(a, b, c, d, a1, b1, c1, d1);
        Cube cube = new Cube(list);

        Calculator calculator = new Calculator();
        double volume = calculator.volumeRatio(cube, "YY");

        Assert.assertEquals(volume, -1, 0.1);
    }

    @Test
    @UseDataProvider("testProviderRightParameters")
    public void testVolumeRatioWhenPlaneXyCutCube(Point a, Point b, Point c, Point d, Point a1, Point b1, Point c1, Point d1){
        List<Point> list = Arrays.asList(a, b, c, d, a1, b1, c1, d1);
        Cube cube = new Cube(list);

        Calculator calculator = new Calculator();
        double volume = calculator.volumeRatio(cube, "XY");

        Assert.assertEquals(volume, 1, 0.1);
    }

    @Test
    @UseDataProvider("testProviderRightParameters")
    public void testVolumeRatioWhenPlaneXzCutCube(Point a, Point b, Point c, Point d, Point a1, Point b1, Point c1, Point d1){
        List<Point> list = Arrays.asList(a, b, c, d, a1, b1, c1, d1);
        Cube cube = new Cube(list);

        Calculator calculator = new Calculator();
        double volume = calculator.volumeRatio(cube, "XZ");

        Assert.assertEquals(volume, 1, 0.1);
    }

    @Test
    @UseDataProvider("testProviderRightParameters")
    public void testVolumeRatioWhenPlaneYZCutCube(Point a, Point b, Point c, Point d, Point a1, Point b1, Point c1, Point d1){
        List<Point> list = Arrays.asList(a, b, c, d, a1, b1, c1, d1);
        Cube cube = new Cube(list);

        Calculator calculator = new Calculator();
        double volume = calculator.volumeRatio(cube, "YZ");

        Assert.assertEquals(volume, 1, 0.1);
    }
}
