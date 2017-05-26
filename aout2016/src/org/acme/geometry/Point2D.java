package org.acme.geometry;

public class Point2D implements Translatable2D, Cloneable {
    private int x;
    private int y;

    public Point2D(int x, int y)  {
        setX(x);
        setY(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point2D))
            return false;
        Point2D point2D = (Point2D) obj;
        return point2D.x == x && point2D.y == y;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0)
            throw new NegativeCoordinate("Negative x: " + x);
        this.x = x;
    }

    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getY() {
        return y;
    }

    public void setY(int y)  {
        if (y < 0)
            throw new NegativeCoordinate("Negative y: " + y);
        this.y = y;
    }

    @Override
    public void translate(int trX, int trY) {
        setX(x + trX);
        setY(y + trY);
    }
}
