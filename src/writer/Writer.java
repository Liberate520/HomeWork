package writer;

import java.io.IOException;

public interface Writer {
      void write() throws IOException;
      void restore() throws IOException, ClassNotFoundException;
}
