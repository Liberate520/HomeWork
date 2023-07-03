package com.romanovcopy.gmail.Genealogy;

import java.io.*;

public class WriteStrem {
    private String path;

    public WriteStrem(String path) {
        this.path = path;
    }

    /**
     * запись объекта на диск
     * @param obj
     * @return
     */
    public boolean write(Object obj) {
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(obj);
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка при записи объекта на диск: " + e.getMessage());
            return false;
        }
    }
}
