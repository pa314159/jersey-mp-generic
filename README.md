Having an interface

```
interface ViewResource<V> {
    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    V get(@PathParam("id") UUID id);
}
```

... then defining

```
@Path("employee")
interface EmployeeResource extends ViewResource<Employee> {
}
```

... I try to use the interface `EmployeeResource` as a MP rest client. Building the client fails with the following exception

```
Exception in thread "main" java.lang.IllegalArgumentException: Type parameter V not a class or parameterized type whose raw type is a class
at javax.ws.rs.core.GenericType.getClass(GenericType.java:179)
at javax.ws.rs.core.GenericType.<init>(GenericType.java:136)
at org.glassfish.jersey.microprofile.restclient.MethodModel$Builder.returnType(MethodModel.java:561)
at org.glassfish.jersey.microprofile.restclient.MethodModel$Builder.build(MethodModel.java:631)
at org.glassfish.jersey.microprofile.restclient.MethodModel.from(MethodModel.java:107)
at org.glassfish.jersey.microprofile.restclient.RestClientModel.parseMethodModels(RestClientModel.java:113)
at org.glassfish.jersey.microprofile.restclient.RestClientModel.from(RestClientModel.java:70)
at org.glassfish.jersey.microprofile.restclient.RestClientBuilderImpl.build(RestClientBuilderImpl.java:195)
```

Jersey Server is able to use this generic approach (i.e. implement a generic `ViewResourceBase` then a `EmploymentResourceImpl`.
Also the MP rest client from `RestEasy` simply works. First run:

```
./gradlew emp-svc:run
```

... then in a second terminal run

```
./gradlew emp-clt:runWithRestEasy
./gradlew emp-clt:runWithJersey
```

