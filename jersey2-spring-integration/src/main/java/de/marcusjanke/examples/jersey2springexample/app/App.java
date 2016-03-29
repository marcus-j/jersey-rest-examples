package de.marcusjanke.examples.jersey2springexample.app;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.JerseyResourceContext;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import de.marcusjanke.examples.jersey2springexample.resources.CarResource;

/**
 * 
 * @author Marcus Janke
 *
 */
public class App extends ResourceConfig {

    public App() {
        register(RequestContextFilter.class);
        register(JerseyResourceContext.class);
        register(JacksonFeature.class);	
        register(CarResource.class);	
    }
}