package familly_tree;
import java.util.List;

public interface FileIO {

    void writeToFile(String filename, List<String> data);


    List<String> readFromFile(String filename);
}


