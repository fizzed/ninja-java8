package conf;

import com.google.inject.AbstractModule;
import ninja8.NinjaJava8Module;

public class Module extends AbstractModule {

    @Override
    protected void configure() {
        install(new NinjaJava8Module());
    }

}