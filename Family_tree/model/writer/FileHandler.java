package Family_tree.model.writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
// import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Family_tree.model.family_tree.FamilyTree;

    public class FileHandler implements Writer{

        @Override
        public void save(String filename, FamilyTree tree){
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))){
                objectOutputStream.writeObject(tree);
            } catch (Exception e) {
                // return e.printStackTrace();
            }
        }

        public Object read(String filename) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))){
                Object object = objectInputStream.readObject();
                return object;
            } catch (Exception e) {
                // return e.printStackTrace();
                return null;
            }
        }
}
