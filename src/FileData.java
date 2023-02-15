import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface FileData extends Serializable {

    void save(Serializable serializable, String filename) throws IOException;
    Object read(String filename) throws IOException, ClassNotFoundException;
}
