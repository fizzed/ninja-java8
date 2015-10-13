package ninja8;

import com.google.inject.AbstractModule;

/**
 * 
 * Placeholder in case we want to override default bindings to actually
 * implement Java8.
 * 
 * @author jjlauer
 *
 */
public class NinjaJava8Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(ninja8.Router.class).to(ninja8.RouterImpl.class).asEagerSingleton();
    }
    
}