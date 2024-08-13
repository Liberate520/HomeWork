package Family_tree.model.family_tree;

import Family_tree.model.human.Human;

public class RelationsManager extends FamilyTree<Human> {

    void addToFather(Human human){
        if (human.getFather() != null){
            human.getFather().addChild(human);
        }
    }

    void addToMother(Human human){
        if (human.getMother() != null){
            human.getMother().addChild(human);
        }
    }
    
    
    void addToChildren(Human human){
        for (Human child : human.getChildren()) {
            child.addFather(human);
            child.addMother(human);
        }
    }

    public void getMarried(Human human1, Human human2) {
        if (human1.getSpouse() == null || human1.getSpouse() == human2 && human2.getSpouse() == null || human2.getSpouse() == human1) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            human1.setChildren(human2.getChildren());
            human2.setChildren(human1.getChildren());
        }
    }

    public boolean getDivorsed(Human human1, Human human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

}
