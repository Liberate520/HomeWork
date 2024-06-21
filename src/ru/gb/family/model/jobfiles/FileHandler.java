package ru.gb.family.model.jobfiles;



import ru.gb.family.model.familyTree.FamilyTree;
import ru.gb.family.model.familyTree.ItemFamilyTrees.humans.Human;
import ru.gb.family.model.service.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Writable {

    public List<String> getListSaveTree(String pathDir){
        List<String> listFiles = new ArrayList<>();
        File dir = new File(pathDir);
        File[] filesList = dir.listFiles();
        for (File file : filesList) {
            if (file.isFile()) {
                listFiles.add(file.getName());

            }
        }
        return listFiles;
    }


    @Override
    public boolean save (Serializable serializable, String filePath) {

        try {ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
             objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public Object read(String pathFile) {
        try {
            //System.out.println(pathFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathFile));
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
             throw new RuntimeException(e);
            //return new Service();
        }

    }

    @Override
    public boolean chekFile(String filePath) {
        File file = new File(filePath);
        return (file.exists() && !file.isDirectory());
    }

    @Override
    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();

    }



}
