package src.family_tree;


public interface Writable {
    boolean save(Serializable serializable, String file);
    Object read(String file);
}
