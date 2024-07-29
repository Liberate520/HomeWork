package Writer;

import java.io.*;

public class FileHandler implements Serializable {
    private String filePath;
    private Object serializable;

    public FileHandler(String filePath) {
        this.filePath = filePath;

    }

     public boolean save() {
         try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
             objectOutputStream.writeObject(serializable);
             return true;
         } catch (IOException e) {
             e.printStackTrace();
             return false;
         }
     }


     public Object load() {
         try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
             return objectInputStream.readObject();
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }
     public void setPath (String filePath){
             this.filePath = filePath;
         }
     }
