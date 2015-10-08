[Lazy Initialization pattern](http://martinfowler.com/bliki/LazyInitialization.html)
=================

* Is useful when calculating the value of the field is time consuming and you don't want to do it until you actually need the value. Factory method + Multiton pattern.
  
```
[String - Game2D - String - Game2D - Game3D - Game3D]

Lazy - new java.lang.String
Lazy - new creational.abstractfactory.src.concreteFactory.Game2D
Lazy - new creational.abstractfactory.src.concreteFactory.Game3D

```

References:

* http://kaliko.com/blog/lazy-loading-in-c-net/
* http://www.javaworld.com/article/2077568/learn-java/java-tip-67--lazy-instantiation.html
