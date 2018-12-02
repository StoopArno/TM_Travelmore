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
    @Path("findall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLocations() {
        return Response.status(Response.Status.CREATED).entity(locatieService.findAllLocaties()).build();
    }

    @GET
    @Path("find")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Locatie getLocationById(@QueryParam("id") int id) {
        return locatieService.findLocationById(id);
    }

    @POST
    @Path("add")
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

    @POST
    @Path("delete")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteLocation(@QueryParam("id") int id){
        Locatie locatie = locatieService.findLocationById(id);
        locatieService.delete(id);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("update")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateLocation(Locatie locatie){
        if(locatieService.findLocationById(locatie.getId()) != null){
            locatieService.update(locatie);
            return Response.status(Response.Status.OK).entity(locatie).build();
        } else{
            return Response.status(Response.Status.NOT_MODIFIED).entity("supply a valid, existing object").build();
        }
    }
}
