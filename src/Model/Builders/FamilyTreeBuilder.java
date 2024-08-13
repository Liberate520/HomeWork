package Model.Builders;

import Model.Creature.Creature;
import Model.FamilyTree.FamilyTree;

public class FamilyTreeBuilder {
    public FamilyTree<Creature> build(){
        return new FamilyTree<>();
    }
}
