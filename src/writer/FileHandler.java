package writer;

import FamilyTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

    public class FileHandler implements Writer {

        public void write(Object obj, String fileName) {
            ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(fileName, false));
                oos.writeObject(obj);
                oos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public FamilyTree read(String fileName) throws ClassNotFoundException {
            ObjectInputStream ois;
            FamilyTree obj = new FamilyTree();
            try {
                ois = new ObjectInputStream(new FileInputStream(fileName));
                obj = (FamilyTree) ois.readObject();
                ois.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
            return obj;
        }
    }

