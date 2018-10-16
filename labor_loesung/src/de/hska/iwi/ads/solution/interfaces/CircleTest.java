package de.hska.iwi.ads.solution.interfaces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
    }
    catch (IllegalArgumentException e){
        System.out.println("Negative radius not Allowed \n"+e);
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
    System.out.println(testCircle.getDimension());
  }

  /*
   * Create a Circle with radius 1.0.
   * Check that the area is nearly Math.PI.
   */
  @Test
  void testArea1() {
    Circle testCircle = new Circle(1);
      System.out.println("Pi: "+Math.PI);
      System.out.println("Area: "+testCircle.area());
  }

  /*
   * Create a Circle with radius 2.0.
   * Check that the area is nearly 4.0 * Math.PI.
   */
  @Test
  void testArea2() {
    Circle testCircle = new Circle(2.0);
    System.out.println("4.0 * Math.Pi: "+4.0*Math.PI);
    System.out.println("Area: "+testCircle.area());
  }

  /*
   * Create a Circle with radius 1.0.
   * Check that the radius is near 1.0.
   */
  @Test
  void testGetRadius1() {
    Circle testCircle = new Circle(1.0);
    System.out.println(testCircle.getDimension());
  }

}
