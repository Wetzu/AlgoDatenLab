package de.hska.iwi.ads.solution.Tests;

import static org.junit.jupiter.api.Assertions.*;

import de.hska.iwi.ads.solution.interfaces.Circle;
import org.junit.jupiter.api.Test;
import java.lang.IllegalArgumentException;

/**
 * A few simple tests for Circle.
 * 
 * Use {@link Circle#Circle(double)} to create a Circle instance.
 */
class CircleTest {

  /**
   * Create a Circle with a negative radius -10.0.
   * Check with a try-catch-statement 
   * that the constructor throws an IllegalArgumentException.
   */
  @Test
  void testCircleDouble() {
    try{
        Circle testCircle = new Circle(-10);
        fail();
    }
    catch (IllegalArgumentException e){
    }
    catch (Exception e){
      fail();
    }
  }
  
  /*
   * Create a Circle with radius 1.5.
   * Scale it by a factor of 2.0.
   * Check that afterwards the Circle 
   * has a radius near 3.0.
   */
  @Test
  void testScale1() {
    Circle testCircle = new Circle(1.5);
    testCircle.scale(2);
    assertEquals(3, testCircle.getDimension());
  }

  /*
   * Create a Circle with radius 1.0.
   * Check that the area is nearly Math.PI.
   */
  @Test
  void testArea1() {
    Circle testCircle = new Circle(1);
    assertEquals(Math.PI, testCircle.area());
  }

  /*
   * Create a Circle with radius 2.0.
   * Check that the area is nearly 4.0 * Math.PI.
   */
  @Test
  void testArea2() {
    Circle testCircle = new Circle(2.0);
    assertEquals(4.0 * Math.PI, testCircle.area());
  }

  /*
   * Create a Circle with radius 1.0.
   * Check that the radius is near 1.0.
   */
  @Test
  void testGetRadius1() {
    Circle testCircle = new Circle(1.0);
    assertEquals(1.0, testCircle.getDimension());
  }

}
