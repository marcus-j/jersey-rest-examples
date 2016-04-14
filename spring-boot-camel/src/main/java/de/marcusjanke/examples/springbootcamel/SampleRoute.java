package de.marcusjanke.examples.springbootcamel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SampleRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:hello").to("log:world");
	}
}