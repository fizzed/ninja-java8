Ninja Framework + Java8 by Fizzed
============================================

 - [Fizzed, Inc.](http://fizzed.com)
 - Joe Lauer (Twitter: [@jjlauer](http://twitter.com/jjlauer))

## Overview

Java8 extensions for Ninja Framework.  Very much a beta and a work-in-progress.

Simply change root package `ninja` to `ninja8` for new Router and ApplicationRoutes
interfaces.  New `with()` method becomes available that accepts a functional
interface.

```java
package conf;

import controllers.Application;
import ninja8.Router;
import ninja8.application.ApplicationRoutes;

public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {

        router.GET().route("/").with(Application::index);

    }
    
}
```

Reverse routing also works

```java
public class Application {
    
    final private ninja8.Router router;
    
    @Inject
    public Application(ninja8.Router router) {
        this.router = router;
    }
    
    public Result index(Context context) {
        return Results
            .ok()
            .template("views/index.ftl.html")
            .render((Object)null);
    }
    
    public Result reverse() {
        String url = router.getReverseRoute(MethodReference.of(this::index));
        log.info("url for index: {}", url);
        
        // rest of method
    }
    
}
```


## Demo

This module is not yet released on Maven central.  You'll need to clone this 
repo and try the demo app:

    mvn -Pninja-run

## License

Copyright (C) 2015 Fizzed, Inc.

This work is licensed under the Apache License, Version 2.0.
