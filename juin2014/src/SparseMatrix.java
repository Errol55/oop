import java.util.Arrays;

public class SparseMatrix implements MatrixInterface, Cloneable {

    private int height;
    private int width;
    private double[] data;
    private int[] indices;
    private int[] indptr;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public SparseMatrix(double[][] matrix) throws DimensionException {
        height = matrix.length;
        width = matrix[0].length;

        int nnz = 0;
        for (int i = 0; i < height; i++) {
            if (matrix[i].length != width)
                throw new DimensionException();
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] != 0.0)
                    nnz++;
            }
        }

        data = new double[nnz];
        indptr = new int[height + 1];
        indices = new int[nnz];

        nnz = 0;
        for (int i = 0; i < height; i++) {
            indptr[i] = nnz;
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] != 0.0) {
                    data[nnz] = matrix[i][j];
                    indices[nnz] = j;
                    nnz++;
                }
            }
        }
        indptr[height] = nnz;
    }


    @Override
    public double getValue(int i, int j) {
        int start = indptr[i];
        int end = indptr[i + 1];
        int n = Arrays.binarySearch(indices, start, end, j);
        if(n >= 0)
            return data[n];
        else
            return 0.0;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int hashCode() {
        return Matrices.hashOf(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MatrixInterface && Matrices.areEqual(this, (MatrixInterface) obj);
    }



}
