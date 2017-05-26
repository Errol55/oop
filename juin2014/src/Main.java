public class Main {

    private static void show(MatrixInterface matrix) {
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++)
                System.out.print(matrix.getValue(i, j) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws DimensionException, CloneNotSupportedException {
        double[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        Matrix m = new Matrix(a);
        SparseMatrix sm = new SparseMatrix(a);
        SparseMatrix m1 = (SparseMatrix) sm.clone();
        show(m);
        System.out.println();
        show(m1);

    }
}
