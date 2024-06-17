package model;
import java.io.IOException;
import java.util.List;

public interface TreeIO<N> {
    void saveTree(List<N> nodeList, String filename) throws IOException;
    List<N> loadTree(String filename) throws IOException, ClassNotFoundException;
}
