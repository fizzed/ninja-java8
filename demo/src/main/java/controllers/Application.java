package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja8.MethodReference;
import org.slf4j.Logger;

/**
 *
 * @author joelauer
 */
@Singleton
public class Application {
    
    final private Logger log;
    final private ninja8.Router router;
    
    @Inject
    public Application(Logger log, ninja8.Router router) {
        this.log = log;
        this.router = router;
    }
    
    public Result index(Context context) {
        return Results
            .ok()
            .template("views/index.ftl.html")
            .render((Object)null);
    }
    
    public Result reverse() {
        // calculate reverse route!
        String url = router.getReverseRoute(MethodReference.of(this::index));
        log.info("url for index: {}", url);
        
        return Results
            .ok()
            .template("views/index.ftl.html")
            .render((Object)null);
    }
    
}
