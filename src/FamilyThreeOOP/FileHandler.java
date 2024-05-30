package FamilyThreeOOP;

import java.io.*;

public class FileHandler implements Rewritable{

    @Override
    public boolean saveToFile(Serializable tree, String fileName){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            outputStream.writeObject(tree);
            return true;
        }
        catch (Exception message) {
            message.printStackTrace();
            return false;
        }
    }

    @Override
    public FamilyTree loadFromFile(String fileName){
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))){
            return (FamilyTree) inputStream.readObject();
        }
        catch (Exception message){
            message.printStackTrace();
            return null;
        }
    }
}
