package ascelion.employee.server;

import ascelion.rest.api.ViewResource;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class EmployeeApp extends ResourceConfig {
	static public void main(String[] args) {
		GrizzlyHttpServerFactory.createHttpServer(ViewResource.baseURI(), new EmployeeApp());
	}

	public EmployeeApp() {
		register(EmployeeEndpoint.class);
		property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL, "INFO");
		property(LoggingFeature.LOGGING_FEATURE_VERBOSITY, "PAYLOAD_TEXT");
	}
}
