public class Matrix implements MatrixInterface, Cloneable {

    private double[][] values;

    public Matrix(double[][] values) throws DimensionException {
        int height = values.length;
        int width = values[0].length;

        this.values = new double[height][];
        for (int i = 0; i < height; i++) {
            if (values[i].length != width)
                throw new DimensionException();
            this.values[i] = values[i].clone();
        }
    }

    @Override
    public double getValue(int i, int j) {
        return values[i][j];
    }

    @Override
    public int getHeight() {
        return values.length;
    }

    @Override
    public int hashCode() {
        return Matrices.hashOf(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MatrixInterface && Matrices.areEqual(this, (MatrixInterface) obj);
    }

    @Override
    public int getWidth() {
        return values[0].length;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Matrix matrix = (Matrix) super.clone();
        for (int i = 0; i < values.length; i++)
            matrix.values[i] = values[i].clone();
        return matrix;
    }
}
