package ru.gb.family.model.familyTree.jobfiles;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Writable, Serializable {

    private static final long serialVersionUID = 1L;
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
             objectOutputStream.flush();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public Object read(String pathFile) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathFile));
            return objectInputStream.readObject();
        } catch (IOException e) {
             e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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
