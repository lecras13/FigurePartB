package com.epam.figure.validation;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class ValidatorDataFileTest {

    @DataProvider
    public static Object[][] testProvider(){
        Object[][] objects = {
                {Arrays.asList("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
                        "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"), true},
                {Arrays.asList("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
                        "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"), false},
                {Arrays.asList("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
                        "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "XD", "1", "1"), false}

        }; return objects;
    }

    @Test
    @UseDataProvider("testProvider")
    public void testCheckDataToCorrect(List<String> list, boolean flag){
        ValidatorData validatorData = new ValidatorDataFile();
        boolean result = validatorData.checkData(list);

        Assert.assertEquals(result, flag);
    }
}
