[Singleton thread-safe pattern](http://en.wikipedia.org/wiki/Singleton_pattern)
=================

* Singleton thread-safe representing a single instance in a thread context for manager scenes.

```
Singleton tread-safe with [double-checked locking](http://en.wikipedia.org/wiki/Double-checked_locking).

Expected     creational.singletonthreadsafe.src.SceneManagerImpl@38b44a31
SceneManager creational.singletonthreadsafe.src.SceneManagerImpl@38b44a31

Assert read name 9 ok
Assert write name 14 ok
Assert read name 15 ok
Assert read name 1 ok
Assert write name 15 ok
Assert read name 14 ok
Assert write name 9 ok
Assert read name 13 ok
Assert read name 10 ok
Assert read name 12 ok
Assert read name 4 ok
Assert write name 2 ok
Assert write name 3 ok
Assert write name 7 ok
Assert read name 8 ok
Assert read name 16 ok
Assert write name 6 ok
Assert read name 16 ok
Assert write name 11 ok

```
