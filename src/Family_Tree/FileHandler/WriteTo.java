package Family_Tree.FileHandler;
import java.io.Serializable;

public interface WriteTo {

    boolean save(Serializable serializable, String filepath);
    Objeact read(String filepath);
}
