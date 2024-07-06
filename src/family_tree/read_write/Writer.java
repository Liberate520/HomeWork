package family_tree.read_write;

import java.io.Serializable;
import java.util.Map;

public interface Writer<K, V extends Serializable> {
    void setPath(String path);
    void writeMap(Map<K, V> map, String fileName);
    Map<K, V> readMap(String fileName);
}

