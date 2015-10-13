package conf;

import ninja.AssetsController;
import controllers.Application;
import ninja8.Router;
import ninja8.application.ApplicationRoutes;

public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {
        router.GET().route("/").with(Application::index);
        router.GET().route("/reverse").with(Application::reverse);
        
        router.GET().route("/assets/w/{fileName: .*}").with(AssetsController.class, "serveWebJars");
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");
    }
    
}