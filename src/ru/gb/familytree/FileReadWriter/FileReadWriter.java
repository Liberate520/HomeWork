package ru.gb.familytree.FileReadWriter;

import java.io.Serializable;

public interface FileReadWriter extends Serializable {
    void writeLine(String fileName, String line, Boolean type);
    public void writeLine(String fileName, String line);
    public String readFile(String fileName);
}
