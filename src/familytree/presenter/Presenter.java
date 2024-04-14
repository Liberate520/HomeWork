package familytree.presenter;

import familytree.model.familytree.FamilyTree;
import familytree.model.human.Human;
import familytree.model.service.Service;
import familytree.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        this.view = view;
        service = new Service(familyTree);
    }

    public void addFamilyMember(String name, String gender, int birthYear, int birthMonth, int birthDay ,int deathYear, int deathMonth, int deathDay) {
        Human human = new Human(name, gender);
        human.SetDateOfBirth(birthYear, birthMonth, birthDay);
        if (human.isDead(deathYear)) {human.SetDateOfDeath(deathYear, deathMonth, deathDay);}
        service.addFamilyMember(human);
        service.getTreeInfo();
    }

//    public void setMotherAndFather(Human human, Human mother, Human father) {
//        human.setMother(mother);
//        human.setFather(father);
//    }

    public void showFamilyTree() {
        String info = service.getTreeInfo();
        view.printAnswer(info);
    }

//    public void addChildren(List<Human> children, Human parent, String parentName, String childName, String childGender, int childBirthYear, int childBirthMonth, int childBirthDay, int childDeathYear, int childDeathMonth, int childDeathDay)  {
//        if (parent.getName().equals(parentName)) {
//            Human child = new Human(childName, childGender);
//            child.SetDateOfBirth(childBirthYear, childBirthMonth, childBirthDay);
//            if (child.isDead(childDeathYear)) {child.SetDateOfDeath(childDeathYear, childDeathMonth, childDeathDay);}
//            parent.setChildren(children);
//            parent.addChild(children, child);
//        } else {
//            String info = "Такого человека нет в древе!";
//            view.printAnswer(info);
//        }
//    }

    public void sortByName() {
        service.sortByName();
        service.getTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        service.getTreeInfo();
    }
}
