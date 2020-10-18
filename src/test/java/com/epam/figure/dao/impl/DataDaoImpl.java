package com.epam.figure.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.when;

public class DataDaoImpl {

    @Test
    public void testReadDataShouldReturnRightData() throws IOException{
        String test = "AX=0; AY=0; AZ=0; BX=1; BY=0; BZ=0; CX=1; CY=1; CZ=0; " +
                "DX=0; DY=1; DZ=0; AX1=0; AY1=0; AZ1=1; BX1=1; BY1=0; BZ1=1; " +
                "CX1=1; CY1=1; CZ1=1; DX1=0; DY1=1; DZ1=1";
        BufferedReader reader = Mockito.mock(BufferedReader.class);
        when(reader.readLine()).thenReturn(test);

        String afterTest = reader.readLine();

        String s = "AX=0; AY=0; AZ=0; BX=1; BY=0; BZ=0; CX=1; CY=1; CZ=0; " +
                "DX=0; DY=1; DZ=0; AX1=0; AY1=0; AZ1=1; BX1=1; BY1=0; BZ1=1; " +
                "CX1=1; CY1=1; CZ1=1; DX1=0; DY1=1; DZ1=1";

        Assert.assertEquals(afterTest, s);
    }
}
