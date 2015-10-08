[Multiton pattern](http://en.wikipedia.org/wiki/Singleton_pattern)
=================

* Expands on the singleton concept to manage a map of named instances as key-value pairs by means of registers.
  
```
getInstance(AudioContainer.class) ->
    Create and register new instance: [class AudioContainer,creational.multiton.src.model.AudioContainer@1ed4004b]
getInstance(MenuContainer.class) ->
    Create and register new instance: [class MenuContainer,creational.multiton.src.model.MenuContainer@25bbe1b6]
getInstance(SceneContainer.class) ->
    Create and register new instance: [class SceneContainer,creational.multiton.src.model.SceneContainer@69ea3742]

getInstance(AudioContainer.class) -> 
    get : creational.multiton.src.model.AudioContainer@1ed4004b
getInstance(MenuContainer.class) -> 
    get : creational.multiton.src.model.MenuContainer@25bbe1b6
getInstance(SceneContainer.class) -> 
    get : creational.multiton.src.model.SceneContainer@69ea3742

```