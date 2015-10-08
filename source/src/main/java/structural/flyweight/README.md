[Flyweight pattern](http://www.programcreek.com/2013/02/java-design-pattern-flyweight/)
=================

* Is used for minimizing memory usage. What it does is sharing as much data as possible with other similar objects.

```
Component{player2D=Player: Mario Color: java.awt.Color[r=255,g=0,b=0] Position: [0.0,0.0]}
Component{player2D=Player: Luigi Color: java.awt.Color[r=0,g=255,b=0] Position: [0.0,0.0]}
Component{player2D=Player: SuperMario Color: java.awt.Color[r=255,g=255,b=255] Position: [39800.0,39800.0]}

Component{player2D=Player: Mario Color: java.awt.Color[r=255,g=0,b=0] Position: [39800.0,39800.0]}
Component{player2D=Player: Luigi Color: java.awt.Color[r=0,g=255,b=0] Position: [0.0,0.0]}
Component{player2D=Player: SuperMario Color: java.awt.Color[r=255,g=0,b=0] Position: [39800.0,39800.0]}
```

