package dummy;

import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static dummy.ApiConstants.SIZE_5MB;

@QuarkusTest
class ApiProgrammaticSimpleTest {
  private static final Logger LOGGER = Logger.getLogger(ApiProgrammaticSimpleTest.class);
  ApiClientProgrammaticSimple apiClient = null;

  @BeforeEach
  void beforeEach() {
    if (apiClient == null) {
      apiClient = new ApiClientProgrammaticSimple();
    }
  }

  @Test
  void testSending() {
    InputStream inputStream2 = new ByteArrayInputStream(new byte[SIZE_5MB]);
    int size2 = apiClient.sendInputStreamProgrammatic(inputStream2);
    LOGGER.infof("Programmatic Client: %d", size2);
  }

  @Test
  void testReceiving() {
    InputStream inputStream2 = apiClient.getInputStreamProgrammatic();
    int size2 = ApiConstants.maxChunkSizeInputStream(inputStream2);
    LOGGER.infof("Programmatic Client: %d", size2);
  }
}
