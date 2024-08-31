package GB_Homework.Model.Service;

import GB_Homework.Model.Family_Tree.FamilyTree;
import GB_Homework.Model.Gender.Gender;
import GB_Homework.Model.Human.Human;
import GB_Homework.Model.Human.HumanBuilder;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;

    public FamilyTreeService() {
        this.familyTree = new FamilyTree<>();
        this.humanBuilder = new HumanBuilder();
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = humanBuilder.build(name, birthDate, gender);
        familyTree.addHuman(human);
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        Human human = humanBuilder.build(name, birthDate, deathDate, gender);
        familyTree.addHuman(human);
    }

    public void addChild(Human human, Human child) {
        human.addChild(child);
    }

    public void addMother(Human human, Human mother) {
        human.addMother(mother);
    }

    public void addFather(Human human, Human father) {
        human.addFather(father);
    }

    public int getAge(Human human) {
        return human.getAge();
    }

    public Human getById(int id) {
        return familyTree.getById(id);
    }

    public List<Human> getByName(String name) {
        return familyTree.getByName(name);
    }

    public List<Human> getSiblings(int id) {
        return familyTree.getSiblings(id);
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void printNameFamilyTree() {
        for (Human h : familyTree) {
            System.out.println(h.getName());
        }
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByData() {
        familyTree.sortByData();
    }

    public void addSpouse(Human human, Human spouse) {
        human.addSpouse(spouse);
    }
}
