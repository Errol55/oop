
# Question 2

## (a)

**Variable de classe** : Variable dont la valeur est partagée par toutes les instances d'une classe. Mémorisée *dans* la classe.  
**Variable d'instance** : Variable dont la valeur est propre à une instance donnée d'une classe. Mémorisée *dans* l'instance (= dans l'objet).  
**Variable locale** : Variable existant seulement dans le bloc où elle est définie. Mémorisée sur la pile. 

## (b)

**Chaînage de constructeurs** : Appel à un constructeur depuis un autre constructeur. 
Un autre constructeur peut être appelé avec `this(...)` si c'est la première instruction du constructeur. 
De la même manière, un constructeur de la super-classe peut être appelé avec `super(...)` si c'est la première instruction du constructeur. 

## (c)
Comme une `interface`, une classe abstraite définit une interface implémentable par d'autres classes. 
Une classe abstraite ne peut donc pas être instanciée. 
Cependant, elle peut contenir des variables et méthodes supplémentaires qui seront partagées par toutes les sous-classes.

## (d)
Classe générique normale : 
```java
public class A<T> {
  // (...)
}
```
Classe générique bornée : 
```java
public class A<T extends B> {
  // (...)
}
```
Utile si la classe `T` doit satisfaire certaines propriétés.

Exemple : Classe `Mean` qui calcule une moyenne d'éléments d'un type donné. 
```java
public class Mean<T extends Number> {
  private Vector<T> numbers = new Vector<>();
  
  public void add(T element) {
    numbers.add(element);
  }
  
  public double mean() {
    double sum = 0.0;
    for(T element: numbers) 
      sum += element.doubleValue();
     return sum / numbers.size();
  }
}
```

# Question 3

(a) :x:  
(b) :x:  
(c) :heavy_check_mark:  
(d) :heavy_check_mark:  
(e) :x:  
(f) :x:  

