package writer;

public interface Writable {
    void save(Object object);
    Object load();
}
