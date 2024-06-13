import java.io.*;
import java.io.Serializable;

public class FileHandler implements Writable {
    @Override
    public boolean save(Serializable serializable, String fileName){
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject((serializable));
            //objectOutputStream.close();
            return  true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String fileName) {
        FamilyTree tree = new FamilyTree();
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            return objectInputStream.readObject();
            //objectInputStream.close();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
