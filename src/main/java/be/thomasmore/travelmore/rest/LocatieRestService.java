package be.thomasmore.travelmore.rest;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("locaties")
public class LocatieRestService {

    @Inject
    private LocatieService locatieService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLocations() {
        return Response.status(Response.Status.CREATED).entity(locatieService.findAllLocaties()).build();
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addLocation(Locatie locatie) {
        if(locatie.getLand() != ""){
            locatieService.insert(locatie);
            return Response.status(Response.Status.CREATED).entity(locatie).build();
        } else{
            return Response.status(Response.Status.NOT_MODIFIED).entity("locatie naam should be set.").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Locatie getLocationById(@PathParam("id") int id) {
        return locatieService.findLocationById(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteLocation(@PathParam("id") int id){
        Locatie locatie = locatieService.findLocationById(id);
        locatieService.delete(id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateLocation(@PathParam("id") int id, Locatie locatie){
        if(id != 0){
            locatie.setId(id);
            locatieService.update(locatie);
            return Response.status(Response.Status.OK).entity(locatie).build();
        } else{
            return Response.status(Response.Status.NOT_MODIFIED).entity("supply a valid, existing object").build();
        }
    }
}
