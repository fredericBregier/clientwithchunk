package dummy;

import java.io.IOException;
import java.io.InputStream;

public class ApiConstants {
  public static final int SIZE_5MB = 50000000;
  public static final int BUFFER_SIZE = 131072;
  public static final String HEADER_MAX_SIZE = "X-MAXSIZE";
  public static final String ROOT_NORMAL = "/test";
  public static final String ROOT_PROGRAMMATIC = "/testprogrammatic";

  public static int maxChunkSizeInputStream(InputStream inputStream) {
    int max = 0;
    int read = 0;
    byte[] bytes = new byte[BUFFER_SIZE * 2];
    try {
      while ((read = inputStream.read(bytes, 0, bytes.length)) >= 0) {
        max = Math.max(max, read);
      }
      inputStream.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return max;
  }
}
