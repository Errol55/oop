# Question 2

## (a) 
**Encapsulation** : mécanisme permettant de combiner des variables et des méthodes manipulant ces données dans une classe.
Une classe est un type de donnée abstrait formé d'une interface et d'une implémentation. 
Avec l'encapsulation, seule l'interface est visibile en dehors de la classe.

Mécanismes : 
* _Access modifiers_ (`private`, `public`, ...)

## (b)
En Java, `o.variable` utilise un lien statique et `o.method()` utilise un lien dynamique.

**lien statique** : le type de déclaration de la variable détermine dans quelle classe la référence est résolue.

**lien dynamique** : le type de création de la variable détermine dans quelle classe la référence est résolue.

Exemple :
```java
class A {
  public final char variable = 'A';
  
  public char method() {
    return 'A';
  }
}

class B extends A {
  public final char variable = 'B';
  
  public char method() {
    return 'B';
  }
}
```
```java
A o = new B();
System.out.println(o.variable); // prints 'A'
System.out.println(o.method()); // prints 'B'
```

## (c)
```java
synchronized(o) {
  // verrou sur o acquis
}
```
ET
```java
class A {
  public synchronized void foo() {
    // verrou sur `this` acquis
  }
}
```

## (d) 
Le code appelant `o.wait()`, `o.notify()` ou `o.notifyAll()` doit possèder un verrou sur `o`. 

**wait** : Stoppe le thread courant jusqu'à ce qu'un autre thread appelle `notify` ou `notifyAll` sur cet objet. 

**notify** : Réveille un thread qui attend (`wait`) sur cet objet.

**notifyAll** : Réveille tous les threads qui attendent (`wait`) sur cet objet.

## (e)
Avec `transient`.

# Question 3
## (a)
Superficiel
## (b)
InternalError
## (c)
```java
public class Person implements Cloneable 
```
## (d)
```java
public Object clone() {
  try {
    Person person = (Person) super.clone();
    if (addresses != null) {
      person.addresses = new Address[addresses.length];
      for (int i = 0; i < addresses.length; i++)
        person.addresses[i] = (Address) addresses[i].clone();
     }
     return person;
  } catch (CloneNotSupportedException e) {
    throw new InternalError();
  }
}
```
