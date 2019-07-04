package ru.stqa.ln.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.stqa.ln.sandbox.MyFirstProgram.distance;

public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(9, 10);
        Point p2 = new Point(4, 10);
        Assert.assertEquals(distance(p1, p2), 5);
    }
}
