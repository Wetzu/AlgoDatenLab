package de.hska.iwi.ads.solution.Tests;

import static org.junit.jupiter.api.Assertions.*;

import de.hska.iwi.ads.interfaces.Vector;
import de.hska.iwi.ads.interfaces.VectorTest;
import de.hska.iwi.ads.solution.interfaces.CartesianVector;
import org.junit.jupiter.api.Test;

public class CartesianVectorTest extends VectorTest {
    @Override
    public Vector createVector(double x, double y) {
        return new CartesianVector(x, y);
    }

    @Test
    void testGetDimension1() {
        assertEquals(2, createVector(Math.sqrt(2), Math.sqrt(2)).getDimension());
    }
}
