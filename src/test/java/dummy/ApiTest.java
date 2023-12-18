package dummy;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static dummy.ApiConstants.SIZE_5MB;

@QuarkusTest
class ApiTest {
  private static final Logger LOGGER = Logger.getLogger(ApiTest.class);
  @Inject
  ApiClient apiClient;

  @Test
  void testSending() {
    InputStream inputStream = new ByteArrayInputStream(new byte[SIZE_5MB]);
    int size = apiClient.sendInputStream(inputStream);
    LOGGER.infof("Standard Client: %d", size);
  }

  @Test
  void testReceiving() {
    InputStream inputStream = apiClient.getInputStream();
    int size = ApiConstants.maxChunkSizeInputStream(inputStream);
    LOGGER.infof("Standard Client: %d", size);
  }
}
