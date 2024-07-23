package model.services;

public interface StorageService {
    void save(String filename, Object data);
    Object load(String filename);
}
