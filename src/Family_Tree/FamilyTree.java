package Family_Tree;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FamilyTree<T extends Serializable> {
    private Map<String, T> elements;

    public FamilyTree() {
        this.elements = new HashMap<>();
    }

    public void addElement(String key, T element) {
        elements.put(key, element);
    }

    public T findElementByKey(String key) {
        return elements.get(key);
    }

    public Map<String, T> getElements() {
        return elements;
    }
}