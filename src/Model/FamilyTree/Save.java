package Model.FamilyTree;

import Model.Creature.Creature;

import java.io.Serializable;
import java.util.Objects;

public class Save implements Serializable {
    private String description;
    private FamilyTree<Creature> familyTree;
    private String fileName;

    public String getDescription() {
        return description;
    }

    public FamilyTree<Creature> getFamilyTree() {
        return familyTree;
    }

    public String getFileName() {
        return fileName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFamilyTree(FamilyTree<Creature> familyTree) {
        this.familyTree = familyTree;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.description, this.familyTree, this.fileName);
    }
}
