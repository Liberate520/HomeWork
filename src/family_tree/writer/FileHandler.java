package family_tree.writer;

import family_tree.person.Human;
import family_tree.tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {


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

    public boolean writeHumanAsByteCode(Serializable outputObject, String fileNameForPeople) {
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

    public Human readHumanFromByteCodeFile(String fileNameForPeople) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileNameForPeople))){
            return (Human) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
