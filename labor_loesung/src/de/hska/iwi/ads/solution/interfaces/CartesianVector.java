package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.Vector;
public class CartesianVector implements Vector {
    private double x;
    private double y;

    public CartesianVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public double getDirection() {
        return Math.atan2(this.y, this.x);
    }

    @Override
    public Vector add(Vector addend) {
        return new CartesianVector(this.x + addend.getX(), this.y + addend.getY());
    }

    @Override
    public void scale(double factor) {
        this.x = x * factor;
        this.y = y * factor;
    }

    @Override
    public double getDimension() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
}
