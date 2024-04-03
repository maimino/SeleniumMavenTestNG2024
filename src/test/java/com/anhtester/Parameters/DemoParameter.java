package com.anhtester.Parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameter {
    @Test
    @Parameters({"number1", "number2"})
    public void testSum(int a, int b){
        System.out.println(a+b);
    }
}
