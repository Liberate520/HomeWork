package family_tree.model.writer;

import family_tree.model.person.TreeNode;
import family_tree.model.tree.FamilyTree;

import java.io.*;

public class FileHandler<T extends TreeNode<T>> implements Writable<T> {
    private String filePathForTree = "src/family_tree/model/writer/familyTree.out";
    private String filePathForSubject = "src/family_tree/model/writer/subjects.out";

    private static FileHandler fileHandler;
    public static FileHandler getFileHandler(){
        if(fileHandler == null){
            fileHandler = new FileHandler();
        }
        return fileHandler;
    }
    private FileHandler(){
    }

    public String getFilePathForTree() {
        return filePathForTree;
    }

    public void setFilePathForTree(String filePathForTree) {
        this.filePathForTree = filePathForTree;
    }

    public String getFilePathForSubject() {
        return filePathForSubject;
    }

    public void setFilePathForSubject(String filePathForSubject) {
        this.filePathForSubject = filePathForSubject;
    }

    public boolean writeTreeAsByteCode(Serializable outputObject) {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filePathForTree))){
            out.writeObject(outputObject);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean writeSubjectAsByteCode(Serializable outputObject) {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filePathForSubject))){
            out.writeObject(outputObject);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FamilyTree<T> readTreeFromByteCodeFile() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePathForTree))){
            return (FamilyTree) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T readSubjectFromByteCodeFile() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePathForSubject))){
            return (T) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
