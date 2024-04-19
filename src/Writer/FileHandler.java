package Writer;

import FamilyTree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {
    public boolean save (Serializable serializable, String filePath) {

        try {
            FileOutputStream fs = new FileOutputStream(filePath);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(serializable);
            os.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public FamilyTree read (String filePath) {
        //прочитываем из файла
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
            FamilyTree serialisableRestore = (FamilyTree) is.readObject();
            return serialisableRestore;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }
}

