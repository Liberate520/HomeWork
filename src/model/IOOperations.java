package model;
import Presenter.*;
import java.io.IOException;
import java.util.List;

public abstract class IOOperations<T> {
    public abstract void saveTree(List<T> nodeList, String filename) throws IOException;
    public abstract List<T> loadTree(String filename) throws IOException, ClassNotFoundException;
}
