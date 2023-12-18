package dummy;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static dummy.ApiConstants.HEADER_MAX_SIZE;
import static dummy.ApiConstants.ROOT_PROGRAMMATIC;
import static dummy.ApiConstants.SIZE_5MB;

@ApplicationScoped
@Path(ROOT_PROGRAMMATIC)
public class ApiServerProgrammatic implements ApiInterface {
  private static final Logger LOGGER = Logger.getLogger(ApiServerProgrammatic.class);

  @Override
  @Blocking
  public Uni<Response> simplePost(final InputStream inputStream) {
    return Uni.createFrom().emitter(em -> {
      int max = ApiConstants.maxChunkSizeInputStream(inputStream);
      LOGGER.infof("Max estimated Chunk size: %d", max);
      em.complete(Response.ok().header(HEADER_MAX_SIZE, max).build());
    });
  }

  @Override
  @Blocking
  public Uni<InputStream> simpleGet() {
    return Uni.createFrom().emitter(em -> {
      em.complete(new ByteArrayInputStream(new byte[SIZE_5MB]));
    });
  }

  @Override
  public void close() throws Exception {

  }
}
