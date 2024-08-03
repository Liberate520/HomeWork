package com.oop.homeWorkOOP.lineAgeSave;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.oop.homeWorkOOP.lineAge.LineageTree;

public class LineAgeFile implements LineAgeSaveable {
    private String file;

    public LineAgeFile(String file) {
        this.file = file;
    }

    @Override
    public boolean saveLineAge(LineageTree tree) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.file));) {
            objectOutputStream.writeObject(tree);
            return true;
        } catch (IOException e) {
            System.out.println("Что-то пошло не так, сохранение не удалось!");
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public LineageTree loadLineAge() {
        LineageTree res;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.file));) {
            res = (LineageTree) objectInputStream.readObject();
            return res;
        } catch (Exception e) {
            System.out.println("Что-то пошло не так, загрузить не удалось!");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
