package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import org.slf4j.Logger;

/**
 *
 * @author joelauer
 */
@Singleton
public class Application {
    
    private final Logger log;
    
    @Inject
    public Application(Logger log) {
        this.log = log;
    }
    
    public Result index(Context context) {
        return Results
            .ok()
            .template("views/index.ftl.html")
            .render((Object)null);
    }
    
}
