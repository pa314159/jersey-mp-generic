package ascelion.employee.api;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import ascelion.rest.api.ViewResource;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("employee")
public interface EmployeeResource extends ViewResource<Employee> {
	@GET
	@Path("explicit/{id}")
	@Produces(APPLICATION_JSON)
	Employee getExplicit(@PathParam("id") UUID id);
}
