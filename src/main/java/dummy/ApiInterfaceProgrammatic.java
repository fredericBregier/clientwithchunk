package dummy;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.io.InputStream;

import static dummy.ApiConstants.ROOT_PROGRAMMATIC;

@RegisterRestClient
@Path(ROOT_PROGRAMMATIC)
public interface ApiInterfaceProgrammatic extends AutoCloseable {

  @POST
  Uni<Response> simplePost(InputStream inputStream);

  @GET
  Uni<InputStream> simpleGet();
}
