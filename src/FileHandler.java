import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Savable{

    public boolean save(Serializable serializable, String path){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path))){
        objectOutputStream.writeObject(serializable);
        return true;
    } catch(Exception e){
        e.printStackTrace();
        return false;
    }
}
    public FamilyTree load(String path){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path))){
        return (FamilyTree) objectInputStream.readObject();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}