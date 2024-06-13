import java.io.*;
import java.io.Serializable;

public interface  Writable {
    boolean save(Serializable serializable, String fileName);
    Object read(String fileName);
    /*
    public String writeTree(FamilyTree tree, String FileName) throws IOException {
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FileName));
            objectOutputStream.writeObject((tree));
            objectOutputStream.close();
        } catch (Exception e){
            return e.toString();
        }
        return "ок";
    }
    public FamilyTree readTree(String FileName) throws IOException {
        FamilyTree tree = new FamilyTree();
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FileName));
            tree = (FamilyTree)  objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e){
            return null;
        }
        return tree;
    }
    */
}
