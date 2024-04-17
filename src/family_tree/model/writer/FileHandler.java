package family_tree.model.writer;

import family_tree.model.person.TreeNode;
import family_tree.model.tree.FamilyTree;

import java.io.*;

public class FileHandler<T extends TreeNode<T>> implements Writable<T> {


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

    public boolean writeSubjectAsByteCode(Serializable outputObject, String fileNameForPeople) {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileNameForPeople))){
            out.writeObject(outputObject);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public FamilyTree<T> readTreeFromByteCodeFile(String fileNameForTree) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileNameForTree))){
            return (FamilyTree) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public T readSubjectFromByteCodeFile(String fileNameForPeople) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileNameForPeople))){
            return (T) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
