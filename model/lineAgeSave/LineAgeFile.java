package com.oop.homeWorkOOP.model.lineAgeSave;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.oop.homeWorkOOP.model.lineAge.LineAgeItem;
import com.oop.homeWorkOOP.model.lineAge.LineageTree;

public class LineAgeFile<T extends LineAgeItem<T>> implements LineAgeSaveable<T> {
    private String file;

    public LineAgeFile(String file) {
        this.file = file;
    }

    @Override
    public boolean saveLineAge(LineageTree<T> tree) {
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
    public LineageTree<T> loadLineAge() {
        LineageTree<T> res;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.file));) {
            res = (LineageTree<T>) objectInputStream.readObject();
            return res;
        } catch (Exception e) {
            System.out.println("Что-то пошло не так, загрузить не удалось!");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
