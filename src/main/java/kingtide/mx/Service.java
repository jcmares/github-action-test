package kingtide.mx;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/v2/products")
@RegisterRestClient
public interface Service {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    String searchProduct(@QueryParam("brand") String brand, @QueryParam("formatted") String formatted, @QueryParam("key") String key);

}
