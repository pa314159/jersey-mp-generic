package ascelion.rest.api;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URI;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.UriBuilder;

public interface ViewResource<V> {

	static URI baseURI() {
		return UriBuilder.fromUri("http://localhost/")
				.port(3142)
				.path("/api")
				.build();
	}

	@GET
	@Path("{id}")
	@Produces(APPLICATION_JSON)
	V getGeneric(@PathParam("id") UUID id);
}
