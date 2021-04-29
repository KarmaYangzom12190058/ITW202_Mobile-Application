package edu.gcit.todo_9;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(JUnit4.class)
@SmallTest

public class ExampleUnitTest {
    private Calculator mCalculator;

    @Before
    public void setUp(){
        mCalculator = new Calculator();
    }

    @Test
    public void addTwoNo(){
        double result = mCalculator.add(2d, 3d);
        assertThat(result, is(equalTo(5d)));
    }

    @Test
    public void addTwoNegativeNo(){
        double result = mCalculator.add(-3d, -3d);
        assertThat(result, is(equalTo(-6d)));
    }

    @Test
    public void addTwoFloatNo(){
        double result = mCalculator.add(1.3f, 3.1d);
        assertThat(result, is(closeTo(4.4d, 0.01d)));
    }

    //For subtraction
    @Test
    public void subTwoNumbers(){
        double result = mCalculator.sub(10d, 3d);
        assertThat(result, is(equalTo(7d)));
    }

    @Test
    public void subWorksWithNegativeResults(){
        double result = mCalculator.sub(2d, 4d);
        assertThat(result, is(equalTo(-2d)));
    }

    @Test
    public void subTwoFloatNo(){
        double result = mCalculator.sub(4.4f, 1.5d);
        assertThat(result, is(closeTo(2.9d, 0.01d)));
    }

    //For multiplication
    @Test
    public void mulTwoNumbers(){
        double result = mCalculator.mul(5d, 5d);
        assertThat(result, is(equalTo(25d)));
    }

    @Test
    public void mulTwoNumbersZero(){
        double result = mCalculator.mul(0d, 12d);
        assertThat(result, is(equalTo(0d)));
    }

    //For division
    @Test
    public void divTwoNumbers(){
        double result = mCalculator.div(5d, 5d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void divTwoNumbersZero(){
        double result = mCalculator.div(12d, 0d);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}