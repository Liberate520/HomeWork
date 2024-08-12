package Model.Builders;

import Model.Creature.Creature;
import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.Save;

public class SaveBuilder {
    private final Save save;

    public SaveBuilder(){
        this.save = new Save();
    }

    public SaveBuilder setFamilyTreeName(String fileName){
        this.save.setFileName(fileName);

        return this;
    }

    public SaveBuilder setDescription(String description){
        this.save.setDescription(description);

        return this;
    }

    public SaveBuilder setFamilyTree(FamilyTree<Creature> familyTree){
        this.save.setFamilyTree(familyTree);

        return this;
    }

    public Save build(){
        return this.save;
    }
}
