package com.epam.figure.observer;

import com.epam.figure.entity.Parameters;
import com.epam.figure.entity.Point;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Map;

@RunWith(DataProviderRunner.class)
public class CubeObserverTest {

    @DataProvider
    public static Object[][] testProvider(){
        CubeObservable first = new CubeObservable(Arrays.asList(
                new Point(0, 0, 0), new Point(1, 0, 0),
                new Point(1, 1, 0), new Point(0, 1, 0),
                new Point(0, 0, 1), new Point(1, 0, 1),
                new Point(1, 1, 1), new Point(0, 1, 1)));

        Object[][] objects = {{first}};
        return objects;
    }

    @Test
    @UseDataProvider("testProvider")
    public void testUpdateShouldSetRightNewParametersInObserverMap(CubeObservable first){
        CubeObserver cubeObserver = CubeObserver.getCubeObserver();
        Parameters expected = new Parameters(6, 1);

        cubeObserver.update(first);
        Map<Long, Parameters> map = CubeObserver.getMap();
        Parameters actual = map.get(first.getId());

        Assert.assertEquals(actual, expected);
    }
}
