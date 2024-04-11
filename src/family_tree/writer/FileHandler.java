package family_tree.writer;

import family_tree.person.BasicUnit;
import family_tree.tree.FamilyTree;

import java.io.*;

public class FileHandler<T extends BasicUnit> implements Writable<T> {


    public boolean writeTreeAsByteCode(Serializable outputObject, String fileNameForTree) {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileNameForTree))){
            out.writeObject(outputObject);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean writeUnitAsByteCode(Serializable outputObject, String fileNameForPeople) {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileNameForPeople))){
            out.writeObject(outputObject);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public FamilyTree readTreeFromByteCodeFile(String fileNameForTree) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileNameForTree))){
            return (FamilyTree) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public T readUnitFromByteCodeFile(String fileNameForPeople) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileNameForPeople))){
            return (T) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
