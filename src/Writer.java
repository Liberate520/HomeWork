import java.io.Serializable;
import java.util.Objects;

public interface Writer {
    void save(Serializable serializable);
    Objects read();
    void setPath(String path);


}
