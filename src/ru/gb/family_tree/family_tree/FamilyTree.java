package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.util.List;
import java.util.ArrayList;


public class FamilyTree {

    private long humanId;
    private List<Human> humanList;


    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }


    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);

            addParentsRelations(human);
            addChildrenRelations(human);

            return true;
        }
        return false;
    }


    private void addParentsRelations(Human human) {
        Human mother = human.getMother();
        if (mother != null) {
            mother.addChild(human);
        }

        Human father = human.getFather();
        if (father != null) {
            father.addChild(human);
        }
    }


    private void addChildrenRelations(Human human) {
        if (human.getChildren().size() > 0) {
            for (Human child : human.getChildren()) {
                if (human.getGender() == Gender.female) {
                    child.setMother(human);
                } else {
                    child.setFather(human);
                }
            }
        }
    }


    public Human findById(long id) {
        for (Human human: humanList) {
            if (human.getId() == id) {
                System.out.println(human);
                return human;
            }
        }
        return null;
    }


    public List<Human> findByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList) {
            if (human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        for (Human human : res) {
            System.out.println(human);
        }
        return res;
    }


    public String getAboutFamily() {
        StringBuilder sb = new StringBuilder();
        sb.append("Humans in family: ");
        sb.append(humanList.size() + "\n\n------------\nThey are:\n\n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
            sb.append("-----------\n");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return getAboutFamily();
    }

}


//---------------------------------------------------------
