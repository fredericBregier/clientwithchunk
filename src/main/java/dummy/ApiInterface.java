package dummy;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.io.InputStream;

import static dummy.ApiConstants.ROOT_NORMAL;

@RegisterRestClient
@Path(ROOT_NORMAL)
public interface ApiInterface extends AutoCloseable {

  @POST
  Uni<Response> simplePost(InputStream inputStream);

  @GET
  Uni<InputStream> simpleGet();
}
