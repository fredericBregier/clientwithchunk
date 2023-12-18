package dummy;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.InputStream;

import static dummy.ApiConstants.HEADER_MAX_SIZE;

@ApplicationScoped
public class ApiClient {
  @RestClient
  ApiInterface apiInterface;

  public int sendInputStream(InputStream inputStream) {
    Response response = apiInterface.simplePost(inputStream).await().indefinitely();
    return Integer.parseInt(response.getHeaderString(HEADER_MAX_SIZE));
  }

  public InputStream getInputStream() {
    return apiInterface.simpleGet().await().indefinitely();
  }
}
