package rest.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("") //raiz
public class ServiceConfig extends ResourceConfig {
	public ServiceConfig() {
		packages("com.fasterxml.jackson.jarxrs.json");
		packages("rest.resource"); // nome do pacote com o recurso rest
	}
}
