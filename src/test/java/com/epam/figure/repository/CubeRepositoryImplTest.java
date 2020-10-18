package com.epam.figure.repository;

import com.epam.figure.comparator.ComparatorById;
import com.epam.figure.comparator.ComparatorBySurfaceArea;
import com.epam.figure.comparator.ComparatorByVolume;
import com.epam.figure.entity.Point;
import com.epam.figure.observer.CubeObservable;
import com.epam.figure.specification.CubeSpecificationById;
import com.epam.figure.specification.CubeSpecificationBySurfaceAreaRange;
import com.epam.figure.specification.CubeSpecificationByVolumeRange;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CubeRepositoryImplTest {
    private static CubeObservable first;
    private static CubeObservable second;
    private static CubeObservable third;
    private static CubeObservable fourth;
    private static CubeObservable fifth;
    private static CubeRepository cubeRepository;

    @BeforeClass
    public static void setUp(){
        first = new CubeObservable(Arrays.asList(  // v = 48 S=96
                new Point(4, 0, 0), new Point(0, 0, 0),
                new Point(0, 4, 0), new Point(4, 4, 0),
                new Point(4, 0, 4), new Point(0, 0, 4),
                new Point(0, 4, 4), new Point(4, 4, 4)
        ));
        second = new CubeObservable(Arrays.asList(//V=8 S=24
                new Point(2, 0, 0), new Point(0, 0, 0),
                new Point(0, 2, 0), new Point(2, 2, 0),
                new Point(2, 0, 2), new Point(0, 0, 2),
                new Point(0, 2, 2), new Point(2, 2, 2)
        ));
        third = new CubeObservable(Arrays.asList(//V=1 S=6
                new Point(0, 0, 0), new Point(1, 0, 0),
                new Point(1, 1, 0), new Point(0, 1, 0),
                new Point(0, 0, 1), new Point(1, 0, 1),
                new Point(1, 1, 1), new Point(0, 1, 1)

        ));
        fourth = new CubeObservable(Arrays.asList(//V=27 S=54
                new Point(3, 0, 0), new Point(0, 0, 0),
                new Point(0, 3, 0), new Point(3, 3, 0),
                new Point(3, 0, 3), new Point(0, 0, 3),
                new Point(0, 3, 3), new Point(3, 3, 3)
        ));
        fifth = new CubeObservable(Arrays.asList(//V=64 S=96
                new Point(5, 0, 0), new Point(0, 0, 0),
                new Point(0, 5, 0), new Point(5, 5, 0),
                new Point(5, 0, 5), new Point(0, 0, 5),
                new Point(0, 5, 5), new Point(5, 5, 5)
        ));
        cubeRepository = CubeRepositoryImpl.getInstance();
        cubeRepository.addCube(first);
        cubeRepository.addCube(second);
        cubeRepository.addCube(third);
        cubeRepository.addCube(fourth);
        cubeRepository.addCube(fifth);
    }

    @Test
    public void testQueryByIdFromRepository(){
        List<CubeObservable> expected = Arrays.asList(third);

        List<CubeObservable> actual = cubeRepository.query(new CubeSpecificationById(3));

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryBySurfaceAreaFromRepository(){
        List<CubeObservable> expected = Arrays.asList(second, fourth);

        List<CubeObservable> actual = cubeRepository.query(new CubeSpecificationBySurfaceAreaRange(20, 60));

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryByVolumeFromRepository(){
        List<CubeObservable> expected = Arrays.asList(fourth, first);

        List<CubeObservable> actual = cubeRepository.query(new CubeSpecificationByVolumeRange(25, 70));

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortById(){
        List<CubeObservable> expected = Arrays.asList(first, second, third, fourth, fifth);

        cubeRepository.sortByTag(new ComparatorById());
        List<CubeObservable> actual = CubeRepositoryImpl.getInstance().getCubeRepository();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortBySurfaceArea(){
        List<CubeObservable> expected = Arrays.asList(third, second, fourth, first, fifth);

        cubeRepository.sortByTag(new ComparatorBySurfaceArea());
        List<CubeObservable> actual = CubeRepositoryImpl.getInstance().getCubeRepository();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortByVolume(){
        List<CubeObservable> expected = Arrays.asList(third, second, fourth, first, fifth);

        cubeRepository.sortByTag(new ComparatorByVolume());
        List<CubeObservable> actual = CubeRepositoryImpl.getInstance().getCubeRepository();

        Assert.assertEquals(actual, expected);
    }
}
