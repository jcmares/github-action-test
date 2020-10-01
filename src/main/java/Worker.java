import io.vertx.core.json.JsonObject;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("demo/")
public class Worker {

    private final String path = "https://api.barcodelookup.com";

    private final String key = "7ol7d6ecyglpc1udokxjec66rix6wh";

    @Inject
    @RestClient
    Service service;

    @GET
    @Tag(name = "demo")
    @Path("/search/{brand}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get information about the barcode using one of the providers")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(responseCode = "400", content = @Content(mediaType = MediaType.TEXT_PLAIN), description = "Invalid barcode")
    })
    public Response request(@PathParam("brand") String brand)  {


        String response = service.searchProduct(brand, "y", key );

        JsonObject json = new JsonObject(response);

        return Response.ok(json).build();
    }
}
