package ru.gb.family_tree.model.writer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler implements Writer{

    public FileHandler() {
    }

    @Override
    public void saveObject(Object obj, String fileName) throws IOException {
        File file = new File("save\\" + fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    @Override
    public Object readObject(String fileName) throws IOException, ClassNotFoundException {
        File file = new File("save\\" + fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }

    public List<String> showSaves(){
        File dir = new File("save");
        File[] listOfFiles = dir.listFiles();
        List<String> saveFiles = new ArrayList<>();
        if (dir.listFiles() != null){
            for (File file : listOfFiles){
                if (file.isFile() && file.getName().contains(".fmt")){
                    saveFiles.add(file.getName());
                }
            }
        }
        return saveFiles;
    }
}
