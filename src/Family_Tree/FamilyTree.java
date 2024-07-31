package Family_Tree;

import java.util.HashMap;
import java.util.Map;

public class FamilyTree<T> {
    private Map<String, T> elements;
    private FileIOInterface<Map<String, T>> fileIO;

    public FamilyTree() {
        this.elements = new HashMap<>();
        this.fileIO = new FileIO<>();
    }

    public void addElement(String key, T element) {
        elements.put(key, element);
    }

    public T getElement(String key) {
        return elements.get(key);
    }

    public Map<String, T> getElements() {
        return elements;
    }

    public void saveToFile(String fileName) {
        fileIO.writeToFile(fileName, elements);
    }

    public void loadFromFile(String fileName) {
        Map<String, T> loadedElements = fileIO.readFromFile(fileName);
        if (loadedElements != null) {
            elements.putAll(loadedElements);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements.values()) {
            sb.append(element.toString()).append("\
");
        }
        return sb.toString();
    }
}