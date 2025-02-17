package Homework6_OOP.WritersClasses;

import Homework6_OOP.WriterInterface.IDataHandler;

import java.io.Serializable;

public class FileManager implements IDataHandler {
    private final IDataHandler dataHandler;

    public FileManager(IDataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public boolean save(Serializable serializable, String filename) {
        return dataHandler.save(serializable, filename);
    }

    public Object load(String filename) {
        return dataHandler.load(filename);
    }
}