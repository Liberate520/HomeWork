package com.oop.homeWorkOOP.fileWork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.oop.homeWorkOOP.lineAge.LineageTree;

public class LineAgeFile implements LineAgeSaveable {

    @Override
    public boolean saveLineAge(LineageTree tree, String file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));) {
            objectOutputStream.writeObject(tree);
            return true;
        } catch (IOException e) {
            System.out.println("Что-то пошло не так, сохранение не удалось!");
            System.out.println(e);
            return false;
        }

    }

    @Override
    public LineageTree loadLineAge(String file) {
        LineageTree res;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));) {
            res = (LineageTree) objectInputStream.readObject();
            return res;
        } catch (Exception e) {
            System.out.println("Что-то пошло не так, загрузить не удалось!");
            return null;
        }
    }

}
