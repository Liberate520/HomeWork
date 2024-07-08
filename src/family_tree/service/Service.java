package family_tree.service;

import family_tree.family_tree1.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service () {
        familyTree = new FamilyTree<>();
    }

    public Human addHuman(String name, LocalDate dob, Gender gender) {
        Human human = new Human(name, dob, null, gender, null, null, new ArrayList<>());
        familyTree.addHuman(human);
        return human;
    }

    public void sortByName () {
        familyTree.sortByName();
    }

    public void sortByDateBirth() {
        familyTree.sortByDateBirth();
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");

        for (Object human : familyTree) {
            stringBuilder.append(human).append("\n");
        }

        return stringBuilder.toString();
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;

    }

    public Human findHumanById(int searchId) {
        return familyTree.findHumanById(searchId);
    }

    public List<Human> findHumansByName(String searchInput) {
        return familyTree.findHumansByName(searchInput);
    }



}
