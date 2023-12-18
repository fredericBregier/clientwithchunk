package dummy;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.ws.rs.core.Response;

import java.io.InputStream;
import java.net.URI;

import static dummy.ApiConstants.BUFFER_SIZE;
import static dummy.ApiConstants.HEADER_MAX_SIZE;

public class ApiClientProgrammatic {
  private final ApiInterfaceProgrammatic service;

  public ApiClientProgrammatic() {
    service = QuarkusRestClientBuilder.newBuilder().baseUri(URI.create("http://127.0.0.1:8081/"))
        .property("io.quarkus.rest.client.max-chunk-size", BUFFER_SIZE).build(ApiInterfaceProgrammatic.class);
  }

  public int sendInputStreamProgrammatic(InputStream inputStream) {
    Response response = service.simplePost(inputStream).await().indefinitely();
    return Integer.parseInt(response.getHeaderString(HEADER_MAX_SIZE));
  }

  public InputStream getInputStreamProgrammatic() {
    return service.simpleGet().await().indefinitely();
  }
}
