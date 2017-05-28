# Question 2
## (a)

**Spécialisation** : Une instance d'un sous-classe est un cas particulier de la super-classe.

Exemple :  
Super-classe : Shape  
Sous-classes : Rectangle, Triangle

**Spécification** : La super-classe définit un certain comportement partagé par toutes ces sous-classes. 

Exemple :  
Super-classe : Drawable   
Sous-classes : Shape, Cursor, Button

## (b) 
:question: 

## (c)
```java
import java.util.Objects;

public class Pair<E> extends AbstractPair<E> {
    private E v1, v2;

    public E get(boolean first) {
        if (first)
            return v1;
        else
            return v2;
    }

    public void set(E value, boolean first) {
        if (first)
            v1 = value;
        else
            v2 = value;
    }

    @Override
    public int hashCode() {
        return v1.hashCode() + v2.hashCode() * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair))
            return false;
        Pair pair = (Pair) obj;
        return Objects.equals(v1, pair.v1) && Objects.equals(v2, pair.v2);
    }
}
```
