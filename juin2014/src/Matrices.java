public class Matrices {

    private Matrices() {
        throw new AssertionError();
    }


    public static boolean areEqual(MatrixInterface m1, MatrixInterface m2) {
        if (m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight())
            return false;
        for (int i = 0; i < m1.getHeight(); i++) {
            for (int j = 0; j < m1.getWidth(); j++) {
                if (m1.getValue(i, j) != m2.getValue(i, j))
                    return false;
            }
        }
        return true;
    }

    public static int hashOf(MatrixInterface matrix) {
        int result = 11;
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                long l = Double.doubleToLongBits(matrix.getValue(i, j));
                result += result * 31 + (int) (l ^ (l >>> 32));
            }
        }
        return result;
    }



}
