package com.iqmsoft.payara.mongo.users.boundary;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("users")
public class UsersResource {

    @GET
    public Response get() {
        return Response.ok("OK").build();
    }

}
