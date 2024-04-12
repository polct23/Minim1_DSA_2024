package edu.upc.dsa.services;

import edu.upc.dsa.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Api(value = "/Drons", description = "Endpoint to Product Service")
@Path("/Drons")
public class DronServices {
    private DronsManager dm;
    public DronServices() {
        this.dm = DronsManagerImp.getInstance();


        dm.addDron("1", "x1","upc","c3");
        dm.addDron("2", "x2", "upc", "a1");
        dm.addDron("3", "w2", "upc", "a1");
        dm.saveDron("3");
        dm.addPilot("1", "Pol", "Carreno");
        dm.addPilot("2", "Juan", "Gomez");
        dm.reservar("1",23,16,30,124,231,126,252,"2");
        dm.reservar("2",10,16,3,124,231,126,252,"1");


    }

    @GET
    @ApiOperation(value = "List of Pilots by the hours", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Pilot.class, responseContainer="List"),
    })
    @Path("/pilotsByHours")

    @Produces(MediaType.APPLICATION_JSON)
    public Response getPilotsByHours() {

        List<Pilot> pilot = this.dm.pilotByHours();

        System.out.println("size: "+pilot.size());
        for (Pilot p: pilot) {
            System.out.println(p.getName());
        }

        GenericEntity<List<Pilot>> entity = new GenericEntity<List<Pilot>>(pilot) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "List of Drones by hours", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Drons.class, responseContainer="List"),
    })
    @Path("/dronesByHours")

    @Produces(MediaType.APPLICATION_JSON)
    public Response getDronesByHours() {

        List<Drons> drones = this.dm.dronsByHours();

        GenericEntity<List<Drons>> entity = new GenericEntity<List<Drons>>(drones) {};
        return Response.status(201).entity(entity).build()  ;

    }



    @PUT
    @ApiOperation(value = "Mantenimiento Drones", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/mantenimientoDrones")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response mantenimientoDrones() {

        this.dm.repairDron();
        return Response.status(201).entity("").build();
    }

    @GET
    @ApiOperation(value = "list the flies of a Pilot", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Pilot.class, responseContainer="List"),
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFliesByPilot(@PathParam("id") String id) {

        List<reserva> res = this.dm.reservasByPilot(id);

        GenericEntity<List<reserva>> entity = new GenericEntity<List<reserva>>(res) {};
        return Response.status(201).entity(entity).build()  ;

    }
}
