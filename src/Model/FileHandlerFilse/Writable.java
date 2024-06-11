package Model.FileHandlerFilse;

public interface Writable<T> {
    void changePath(String path);
    void save(T t);
    void load();
}
