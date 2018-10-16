package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.Vector;

public class Circle extends de.hska.iwi.ads.interfaces.AbstractCircle {

    public Circle(double radius) {
        super(radius);
    }

    public Circle(Vector middlePoint, double radius) {
        super(middlePoint, radius);
    }

    @Override
    public void scale(double factor) {
        this.radius = this.radius * factor;
    }

    @Override
    public double getDimension() {
        return this.radius;
    }

    @Override
    public double area() {
        return (Math.pow(radius, 2) * Math.PI);
    }
}
