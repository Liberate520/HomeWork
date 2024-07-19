package com.example.familytree.mvp;

public interface FileOperationsPresenter {
    void saveToFile(String filename);
    void loadFromFile(String filename);
}