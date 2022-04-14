package de.hsh.pizza;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("bestellungen")
public class BestellungenResource {

    @Inject
    BestellungRepository bestellungRepository;

    @GET
    public List<Bestellung> listAll(){
        return new ArrayList<Bestellung>(this.bestellungRepository.list().values());
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id")Long id){
        Bestellung bestellung = bestellungRepository.read(id);
        if (bestellung == null){
            return Response.status(404).build();
        } else {
            return Response.ok().entity(bestellung).build();
        }
    }

    @GET
    @Path("{id}/pizzas")
    public Response getPizzas(@PathParam("id")Long id){
        Bestellung bestellung = bestellungRepository.read(id);
        if (bestellung == null){
            return Response.status(404).build();
        } else {
            return Response.ok().entity(bestellung.getPizzas()).build();
        }
    }

    @POST
    public Response create(Bestellung bestellung, @Context UriInfo uriInfo){
        
        if (this.bestellungRepository.read(bestellung.getId()) != null){
            return Response.status(409).build();
        } else {
            this.bestellungRepository.create(bestellung);
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Long.toString(bestellung.getId()));
            bestellung = this.bestellungRepository.read(bestellung.getId());
            return Response.created(uriBuilder.build()).entity(bestellung).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Bestellung bestellung, @Context UriInfo uriInfo){
        if (this.bestellungRepository.read(id) == null){
            return Response.status(404).build();
        } else {
            this.bestellungRepository.update(id, bestellung);
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Long.toString(bestellung.getId()));
            bestellung = this.bestellungRepository.read(bestellung.getId());
            return Response.ok(uriBuilder.build()).entity(bestellung).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        if (this.bestellungRepository.read(id) == null) {
            return Response.status(404).build();
        } else {
            this.bestellungRepository.delete(id);
            return Response.ok().build();
        }
    }
}
