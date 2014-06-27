[Front Controller pattern](http://martinfowler.com/eaaCatalog/frontController.html)
=================

* The front controller design pattern is used to provide a centralized request handling mechanism so that all requests 
  will be handled by a single handler.
  
  Front Controller - Single handler for all kind of request coming to the application.
  Dispatcher - Front Controller may use a dispatcher object which can dispatch the request to corresponding specific handler.
  View - Are the object for which the requests are made.
  

```
Game Menu

Play Game!!!   - actual();
Exit           - back();
Load Game      - back();
Configuration  - back();
Play Game!!!   - back();
Exit           - back();
Play Game!!!   - next();
Configuration  - next();
Load Game      - next();
Exit           - next();
Play Game!!!   - next();
Configuration  - next();
Play Game!!!   - next();
Configuration  - next();
Load Game      - next();
Configuration  - back();
...

```

