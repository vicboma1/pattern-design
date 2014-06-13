[Multiton Double-Checked Locking pattern](http://en.wikipedia.org/wiki/Singleton_pattern)
=================

* Expands on the singleton concept to manage a map of named instances as key-value pairs by means of registers with Double-Checked Locking.
  
```
getInstance(AudioContainer.class) ->
    Create and register new instance: [class AudioContainer,creational.multitondoublecheckedlocking.src.model.AudioContainer@123bs321]
getInstance(MenuContainer.class) ->
    Create and register new instance: [class MenuContainer,creational.multitondoublecheckedlocking.src.model.MenuContainer@bb39876f]
getInstance(AudioContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.AudioContainer@123bs321
getInstance(SceneContainer.class) ->
    Create and register new instance: [class SceneContainer,creational.multitondoublecheckedlocking.src.model.SceneContainer@3342aab3]
getInstance(MenuContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.MenuContainer@bb39876f
getInstance(SceneContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.SceneContainer@3342aab3
getInstance(AudioContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.AudioContainer@123bs321
getInstance(MenuContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.MenuContainer@bb39876f
getInstance(SceneContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.SceneContainer@3342aab3
getInstance(AudioContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.AudioContainer@123bs321
getInstance(MenuContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.MenuContainer@bb39876f
getInstance(SceneContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.SceneContainer@3342aab3
getInstance(AudioContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.AudioContainer@123bs321
getInstance(MenuContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.MenuContainer@bb39876f
getInstance(SceneContainer.class) -> 
    get : creational.multitondoublecheckedlocking.src.model.SceneContainer@3342aab3

```
