[Abstract Factory pattern](http://en.wikipedia.org/wiki/Abstract_factory_pattern)
=================

* Abstract Factory that creates 2D and 3D games with their respective levels and resources.

```
FactoryGame game2D = new Game2D()
    Resource : class creational.abstractfactory.src.resources.type.HexaTile
    Level    : class creational.abstractfactory.src.level.type.Level2D

FactoryGame game3D = new Game3D()
    Resource : class creational.abstractfactory.src.resources.type.Model
    Level    : class creational.abstractfactory.src.level.type.Level3D
```
