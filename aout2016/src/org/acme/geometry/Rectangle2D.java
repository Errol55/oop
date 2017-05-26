package org.acme.geometry;

public class Rectangle2D implements Translatable2D, Cloneable {

    private Point2D corner1;
    private Point2D corner2;

    public Rectangle2D(Point2D corner1, Point2D corner2) {
        this.corner1 = corner1;
        this.corner2 = corner2;
    }

    @Override
    public int hashCode() {
        int r = 93;
        int h1 = corner1.hashCode();
        int h2 = corner2.hashCode();
        if (h1 > h2) {
            int tmp = h1;
            h1 = h2;
            h2 = tmp;
        }
        r += 31 * r + h1;
        r += 31 * r + h2;
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle2D))
            return false;
        Rectangle2D rectangle2D = (Rectangle2D) obj;
        return (corner1.equals(rectangle2D.corner1) && corner2.equals(rectangle2D.corner2)) ||
                (corner1.equals(rectangle2D.corner2) && corner2.equals(rectangle2D.corner1));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Rectangle2D rectangle2D = (Rectangle2D) super.clone();
        rectangle2D.corner1 = (Point2D) corner1.clone();
        rectangle2D.corner2 = (Point2D) corner2.clone();
        return rectangle2D;
    }

    @Override
    public void translate(int trX, int trY) {
        corner1.translate(trX, trY);
        corner2.translate(trX, trY);
    }

    public Point2D getCorner1() {
        return corner1;
    }

    public void setCorner1(Point2D corner1) {
        this.corner1 = corner1;
    }

    public Point2D getCorner2() {
        return corner2;
    }

    public void setCorner2(Point2D corner2) {
        this.corner2 = corner2;
    }
}
