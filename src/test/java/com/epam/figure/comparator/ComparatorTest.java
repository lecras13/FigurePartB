package com.epam.figure.comparator;

import com.epam.figure.entity.Point;
import com.epam.figure.observer.CubeObservable;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(DataProviderRunner.class)
public class ComparatorTest {
    public static ComparatorById comparatorById = new ComparatorById();
    public static ComparatorBySurfaceArea comparatorBySurfaceArea = new ComparatorBySurfaceArea();
    public static ComparatorByVolume comparatorByVolume = new ComparatorByVolume();

    @DataProvider
    public static Object[][] testProvider(){
        CubeObservable first = new CubeObservable(Arrays.asList(
                new Point(0, 0, 0), new Point(1, 0, 0),
                new Point(1, 1, 0), new Point(0, 1, 0),
                new Point(0, 0, 1), new Point(1, 0, 1),
                new Point(1, 1, 1), new Point(0, 1, 1)));
        CubeObservable second = new CubeObservable(Arrays.asList(
                new Point(-2, -2, -2), new Point(2, -2, -2),
                new Point(2, 2, -2), new Point(-2, 2, -2),
                new Point(-2, -2, 2), new Point(2, -2, 2),
                new Point(2, 2, 2), new Point(-2, 2, 2)));

        Object[][] objects = {{first, second, -1}};
        return objects;
    }

    @Test
    @UseDataProvider("testProvider")
    public void testCompareByIdShouldGiveRightResult(CubeObservable first, CubeObservable second, int expected){

        int actualById = comparatorById.compare(first, second);

        Assert.assertEquals(actualById, expected);
    }

    @Test
    @UseDataProvider("testProvider")
    public void testCompareBySurfaceAreaShouldGiveRightResult(CubeObservable first, CubeObservable second, int expected){

        int actualBySurfaceArea = comparatorBySurfaceArea.compare(first, second);

        Assert.assertEquals(actualBySurfaceArea, expected);
    }

    @Test
    @UseDataProvider("testProvider")
    public void testCompareByVolumeShouldGiveRightResult(CubeObservable first, CubeObservable second, int expected){

        int actualByVolume = comparatorByVolume.compare(first, second);

        Assert.assertEquals(actualByVolume, expected);
    }
}
