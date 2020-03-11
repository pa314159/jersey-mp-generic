package ascelion.employee.client;

import static java.util.UUID.randomUUID;

import ascelion.employee.api.EmployeeResource;
import ascelion.rest.api.ViewResource;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

public class EmployeeApp {
	static public void main(String[] args) {
		final EmployeeResource client = RestClientBuilder.newBuilder()
				.baseUri(ViewResource.baseURI())
				.build(EmployeeResource.class);

		System.out.println(client.getExplicit(randomUUID()));
		System.out.println(client.getGeneric(randomUUID()));
	}
}
