# Question 2
## (a) 
```java
public boolean equals(Object obj) {
  // (...)
}
```
La fonction doit être :
1. Symétrique
2. Transitive
3. Réflexive
4. Consistante
5. Si `x` n'est pas `null`, `x.equals(null) == false`  

Lorsque `equals` est définie, `hashcode` doit être définie.
```java 
public int hashCode() {
  // (...)
}
```
Cette fonction retourne un hash de l'objet tel que `a.equals(b)` implique `a.hashcode() == b.hashcode()`.

## (b)
```
false
```

## (c)
```java
import java.util.Arrays;

public class Triangle3D {
    private double[] points;

    public Triangle3D(
            double p1_x, double p1_y, double p1_z,
            double p2_x, double p2_y, double p2_z,
            double p3_x, double p3_y, double p3_z
    ) {
        points = new double[]{p1_x, p1_y, p1_z, p2_x, p2_y, p2_z, p3_x, p3_y, p3_z};
    }

    @Override
    public int hashCode() {
        int result = 93;
        for (int i = 0; i < points.length; i++)
            result += result * 31 + Double.hashCode(points[i]);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Triangle3D))
            return false;
        Triangle3D triangle3D = (Triangle3D) obj;
        return Arrays.equals(points, triangle3D.points);
    }

    public double[] getPoint(int number) throws ParameterOutOfBoundsException {
        if ((number < 1) || (number > 3))
            throw new ParameterOutOfBoundsException();
        int offset = (number - 1) * 3;
        return Arrays.copyOfRange(points, offset, offset + 3);
    }
}
```
