package ru.stqa.ln.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(9, 10);
        Point p2 = new Point(4, 10);
        Assert.assertEquals(p1.distance(p2), 5.0);
    }
}
