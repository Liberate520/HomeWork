package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.sorter.HumanSorter;

import java.time.LocalDate;

public class Service {
    private FamilyTree familyTree;

    public Service() {
        familyTree = new FamilyTree();
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = new Human(name, birthDate, gender);
        familyTree.addHuman(human);
    }

    public void HumanSortByName() {
        HumanSorter.sortByName(familyTree.getPeople());
    }

    public void HumanSortByAge() {
        HumanSorter.sortByBirthDate(familyTree.getPeople());
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n");
        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}