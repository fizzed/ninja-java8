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
        // nothing to bind yet, maybe we'd eventually swap out Impl's for Java8 Impls
    }
    
}