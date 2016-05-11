package de.marcusjanke.examples.jersey2swagger.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * Bootstrapping Swagger
 * 
 * @author Marcus Janke
 *
 */
public class SwaggerBootstrap extends HttpServlet {

	private static final long serialVersionUID = -5785531793421673981L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost(System.getProperty("avs.host", "localhost") + ":8080");
		beanConfig.setBasePath("/jersey2-swagger/api");
		beanConfig.setResourcePackage("de.marcusjanke.examples.jersey2swagger.resources");
		beanConfig.setScan(true);
		beanConfig.setPrettyPrint(true);
	}
}