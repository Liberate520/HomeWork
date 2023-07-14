import java.io.IOException;

public interface ReadAndWrite {
    public Object read(String path) throws IOException, ClassNotFoundException;
    public void write(Object object, String path) throws IOException;
}