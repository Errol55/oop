
# Question 2 :pizza: 
## 1. 
```java
Pizza p = new HawaiianPizza();
p.displayIngredients();
System.out.println(p.name);
```
Compilation: :heavy_check_mark:

Output: 
```
Tomato 
Cheese
Ham
Pineapple 
Base
```
## 2. 
```java
HawaiianPizza hp = new HawaiianPizza();
hp.displayIngredients();
System.out.println(hp.name);
```
Compilation: :heavy_check_mark:

Output: 
```
Tomato 
Cheese
Ham
Pineapple 
Hawaiian
```

## 3. 
```java
MargheritaPizza mp = new Pizza();
```
Compilation: :x:

Correction:
```java
Pizza p = new Pizza();
```

# Question 3
`++value` = *fetch* + *increment* + *update*

## (a)

| Thread 1 | Thread 2 |
|----------|----------|
| fetch | |
| | fetch |
| increment | |
| | increment |
| update | |
| | update |

`increment()` is called twice but the counter is incremented by 1.

## (b)

```java
public class Counter {

  private int value = 0;

  public synchronized void increment() {
    ++value;
  }
  
  public int getValue() {
    return value;
  }
}
```
## (c)
```java
public class Counter20Thread extends Thread {

    private final Counter counter;

    public Counter20Thread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++)
            counter.increment();
    }
}


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread[] threads = new Thread[20];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Counter20Thread(counter);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++)
            threads[i].join();

        System.out.println("Value: " + counter.getValue());

    }
}
```

OU
```java
public class Main {

    public static  void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable runnable = () -> {
            for (int j = 0; j < 20; j++)
                counter.increment();
        };

        Thread[] threads = new Thread[20];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for (Thread thread : threads) thread.join();

        System.out.println("Value: " + counter.getValue());

    }
}
```
