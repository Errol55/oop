package org.acme.geometry;

public class NegativeCoordinate extends RuntimeException {
    public NegativeCoordinate(String message) {
        super(message);
    }
}
