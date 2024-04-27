package family_TREE.model.save;

import family_TREE.model.family_tree.FamilyTree;
import family_TREE.model.human.Human;
import family_TREE.model.save.base.FileHandler;
import java.io.Serializable;

public class FileHandlerForFamilyTree extends FileHandler implements family_tree.writer.Writable {
    private String filePath = "tree.out";

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean save(FamilyTree<Human> tree) {
        return super.save(tree, filePath);
    }

    public FamilyTree<Human> read() {
        return (FamilyTree<Human>)super.read(filePath);
    }
}
