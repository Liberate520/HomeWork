package model;
import Presenter.*;
import java.io.IOException;
import java.util.List;

public interface IOOperations<T> {
    void saveTree(List<T> nodeList, String filename) throws IOException;
    List<T> loadTree(String filename) throws IOException, ClassNotFoundException;
}
