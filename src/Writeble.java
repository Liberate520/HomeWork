import java.io.Serializable;

interface Writable {
    boolean save(Serializable serializable, String file);
    Object read(String file);
}
