package de.marcusjanke.examples.jersey2swagger.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import de.marcusjanke.examples.jersey2swagger.resources.GreetResource;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

public class Jersey2SwaggerApplication extends Application {

	public Jersey2SwaggerApplication() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost(System.getProperty("your.jvm.host.param", "localhost") + ":8080");
		beanConfig.setBasePath("/jersey2-swagger/api");
		beanConfig.setResourcePackage("de.marcusjanke.examples.jersey2swagger.resources");
		beanConfig.setScan(true);
		beanConfig.setPrettyPrint(true);
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(ApiListingResource.class);
		classes.add(SwaggerSerializers.class);
		classes.add(GreetResource.class);
        return classes;
	}
}
