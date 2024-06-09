package Model.FileHandlerFilse;

public interface Writable<T> {
    void save(T t, String filePath);
    void load(String Path);
}
