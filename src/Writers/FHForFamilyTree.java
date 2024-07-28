package Writers;

import model.FamilyTree.FamilyTree;
import model.Humans.Human;

public class FHForFamilyTree extends FileHandler implements Writer {
    private String filePath = "familyTree.out";

    @Override
    public boolean save(FamilyTree<Human> familyTree) {
        return super.save(familyTree, filePath);
    }

    @Override
    public FamilyTree<Human> read() {
        return (FamilyTree<Human>) super.read(filePath);
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
