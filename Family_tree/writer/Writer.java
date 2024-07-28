package Family_tree.writer;

// import java.io.IOException;
import java.io.Serializable;

public interface Writer {
    Object read(); 
    void save(Serializable serializable);
}