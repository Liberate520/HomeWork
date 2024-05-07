package writer;

import java.io.*;

public class FileHandler implements Writeable {

    String filePath = "src/writer/tree.txt";
    public boolean save(Serializable serializable){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Object read(){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}

