package model.save_and_load;

import model.family_tree.FamilyTree;
import model.family_tree.TreeNode;

import java.io.*;

public class FileHandler<E extends TreeNode<E>> implements Writable<FamilyTree<E>> {
    @Override
    public boolean save(FamilyTree<E> serializable, String file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FamilyTree<E> read(String file){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            return (FamilyTree<E>) objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
