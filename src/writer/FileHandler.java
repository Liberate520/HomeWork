package writer;



import family_tree.FamilyTree;

import java.io.*;


public class FileHandler implements Writeble{


    public boolean save(Serializable serializable, String pathFile) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathFile))){
            objectOutputStream.writeObject(serializable);
            System.out.println("Процесс записи завершен");
            return true;
        }catch (Exception e){
            System.out.println("Процесс записи не удался");
            e.printStackTrace();
        return false;
        }
    }

       public Object read(String pathFile) {
        try (ObjectInputStream objectinputStream = new ObjectInputStream(new FileInputStream(pathFile))){
            return  objectinputStream.readObject();

        }catch (Exception e){
            System.out.println("Процесс чтения не удался");
            e.printStackTrace();
            return null;}
    }
}
