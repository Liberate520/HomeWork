package family_tree.writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writer{
        
    private String filePath = "src/family_tree/writer/tree.txt";

        @Override
        public void save (Serializable serializable){
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
                objectOutputStream.writeObject(serializable);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public Object read (){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
                Object object = objectInputStream.readObject();
                return object;
            } catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public void setPath (String filePath){
            this.filePath = filePath;
        }
}
