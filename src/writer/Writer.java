package writer;

public interface Writer {
        public void write(Object obj, String fileName);

        public Object read(String fileName) throws ClassNotFoundException;

    }

