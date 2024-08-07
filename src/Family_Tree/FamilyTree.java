package Family_Tree;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FamilyTree<T extends Serializable> implements Serializable {
    private Map<String, T> elements;
    private FileIOInterface<FamilyTree<T>> fileIO;

    public FamilyTree() {
        this.elements = new HashMap<>();
        this.fileIO = new FileIO<>();
    }

    public void addElement(String key, T element) {
        elements.put(key, element);
    }

    public T findElementByKey(String key) {
        return elements.get(key);
    }

    public void saveToFile(String fileName) {
        fileIO.writeToFile(fileName, this);
    }

    public void loadFromFile(String fileName) {
        FamilyTree<T> loadedTree = fileIO.readFromFile(fileName);
        if (loadedTree != null) {
            this.elements = loadedTree.getElements();
        }
    }

    public Map<String, T> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements.values()) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }
}