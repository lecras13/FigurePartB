package com.epam.figure.logic;

import com.epam.figure.entity.Point;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseStringDataTest {

    @Test
    public void testParseLinesShouldGiveRightStringCoordinates(){
        String test = "AX=0; AY=0; AZ=0; BX=1; BY=0; BZ=0";
        List<String> toCompare = Arrays.asList("0", "0", "0", "1", "0", "0");

        ParserStringData parserStringData = new ParserStringData();
        List<String> testList = parserStringData.parseLines(test);

        Assert.assertEquals(testList, toCompare);
    }

    @Test
    @UseDataProvider("testProvider")
    public void testParseLinesShouldGiveRightListPoints(){
        List<String> test = Arrays.asList("0", "0", "0", "1", "0", "0");
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        List<Point> toCompare = new ArrayList<>();
        toCompare.add(a);
        toCompare.add(b);

        ParserStringData parserStringData = new ParserStringData();
        List<Point> testList = parserStringData.parseLinesToPoints(test);

        Assert.assertEquals(testList, toCompare);
    }
}
