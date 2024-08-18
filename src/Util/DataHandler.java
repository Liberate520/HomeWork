package Util;

public interface DataHandler<T> {
    void saveFamilyTree(T data, String saveFilename);
    T loadFamilyTree(String saveFilename);
}
