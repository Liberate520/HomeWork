package ru.gb.FamilyTree;
import java.io.*;

public  class FileHandler implements Writable {
    //    @Override
//    public void saveFileByte(ru.gb.FamilyTree.FamilyTree familyTree) throws IOException {
//        ObjectOutputStream  objectOutputStream = new ObjectOutputStream
//                (new FileOutputStream("family.out"));
//        objectOutputStream.writeObject(familyTree);
//        objectOutputStream.close();
//    }
//    public FamilyTree loadFileBite() throws IOException, ClassNotFoundException {
//        ObjectInputStream objectInputStream = new ObjectInputStream
//                (new FileInputStream("family.out"));
//        FamilyTree familyTree =(FamilyTree) objectInputStream.readObject();
//        return familyTree;
//    }
    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}