package com.epam.figure.specification;

import com.epam.figure.entity.Point;
import com.epam.figure.observer.CubeObservable;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class CubeSpecificationTest {
    private static CubeObservable first;
    private static CubeObservable second;

    @BeforeClass
    public static void setUp(){
        first = new CubeObservable(Arrays.asList(
                new Point(-2, -2, -2), new Point(2, -2, -2),
                new Point(2, 2, -2), new Point(-2, 2, -2),
                new Point(-2, -2, 2), new Point(2, -2, 2),
                new Point(2, 2, 2), new Point(-2, 2, 2)));
        second = new CubeObservable(Arrays.asList(
                new Point(2, 0, 0), new Point(0, 0, 0),
                new Point(0, 2, 0), new Point(2, 2, 0),
                new Point(2, 0, 2), new Point(0, 0, 2),
                new Point(0, 2, 2), new Point(2, 2, 2)
        ));
    }

    @Test
    public void testSpecifiedByIdShouldNegative(){
        CubeSpecificationById cubeSpecification = new CubeSpecificationById(2);

        boolean actual = cubeSpecification.specified(first);

        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedBySurfaceAreaShouldNegative(){
        CubeSpecificationBySurfaceAreaRange cubeSpecification = new CubeSpecificationBySurfaceAreaRange(50, 70);

        boolean actual = cubeSpecification.specified(first);

        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedByVolumeShouldNegative(){
        CubeSpecificationByVolumeRange cubeSpecification = new CubeSpecificationByVolumeRange(15, 47);

        boolean actual = cubeSpecification.specified(first);

        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedByIdShouldPositive(){
        CubeSpecificationById cubeSpecification = new CubeSpecificationById(2);

        boolean actual = cubeSpecification.specified(second);

        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedBySurfaceAreaShouldPositive(){
        CubeSpecificationBySurfaceAreaRange cubeSpecification = new CubeSpecificationBySurfaceAreaRange(15, 30);

        boolean actual = cubeSpecification.specified(second);

        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedByVolumeShouldPositive(){
        CubeSpecificationByVolumeRange cubeSpecification = new CubeSpecificationByVolumeRange(1, 10);

        boolean actual = cubeSpecification.specified(second);

        Assert.assertTrue(actual);
    }
}
