package ru.gb.family_tree.model.tools.writer;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.io.*;


public class FileHandler<E extends FamilyTreeElement<E>> implements Writable<FamilyTree<E>>  {

    @Override
    public boolean write(FamilyTree<E> serializable, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FamilyTree<E> read(String path) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            FamilyTree<E> treeRead = (FamilyTree<E>) objectInputStream.readObject();
            return treeRead;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


//-------------------------------------------------------------------------