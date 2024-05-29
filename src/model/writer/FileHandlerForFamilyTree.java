package model.writer;

import model.familyTree.FamilyTree;
import model.human.Human;
import model.writer.base.FileHandler;

public class FileHandlerForFamilyTree extends FileHandler implements Writable{
    private String filePath = "tree.txt";

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean save(FamilyTree<Human> tree) {
        return super.save(tree, filePath);
    }

    @Override
    public FamilyTree<Human> read() {
        return (FamilyTree<Human>)super.read(filePath);
    }
}