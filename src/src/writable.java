package src;


public interface writable {
    boolean save(Serializable serializable, String file);
    Object read(String file);
}
