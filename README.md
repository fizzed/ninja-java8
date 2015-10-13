Ninja Framework + Java8 by Fizzed
============================================

 - [Fizzed, Inc.](http://fizzed.com)
 - Joe Lauer (Twitter: [@jjlauer](http://twitter.com/jjlauer))

## Overview

Java8 extensions for Ninja Framework.  Very much a beta and a work-in-progress.

```java
package conf;

import controllers.Application;
import ninja8.Router;
import ninja8.application.ApplicationRoutes;

public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {

        router.GET().route("/or").with(Application::index);

    }
    
}
```

## License

Copyright (C) 2015 Fizzed, Inc.

This work is licensed under the Apache License, Version 2.0.
