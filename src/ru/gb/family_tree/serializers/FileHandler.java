package ru.gb.family_tree.serializers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.gb.family_tree.FamilyTree;

public class FileHandler implements PersistenceHandler{

    private String filename;


    public FileHandler(String fileName) {

        this.filename = fileName;
    }

    public String getFileName() {
        return  this.filename;
    }


    @Override
    public FamilyTree readObject() {
        
        FamilyTree restoredObject = null;
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.filename))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            // Файл или класс не найден. Ничего не делаем
            //ex.printStackTrace();
        }
        // Возвращаем null в случае неудачного чтения
        return restoredObject;
    }

    @Override
    public void writeObject(FamilyTree obj) {
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.filename))) {
            oos.writeObject(obj);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}