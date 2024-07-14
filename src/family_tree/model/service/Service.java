package family_tree.model.service;

import family_tree.model.family_tree1.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service implements FamilyTreeService{
    private FamilyTree<Human> familyTree;
    private FileFamilyTreeService fileFamilyTreeService;

    public Service () {
        this.fileFamilyTreeService = new FileFamilyTreeService();
        this.familyTree = new FamilyTree<>();
        this.familyTree = fileFamilyTreeService.loadFamilyTree();
    }

    public Human addHuman(String name, LocalDate dob, Gender gender) {
        Human human = new Human(name, dob, null, gender, null, null, new ArrayList<>());
        familyTree.addHuman(human);
        fileFamilyTreeService.saveFamilyTree();
        return human;
    }

    public void setParents(int childId, Integer fatherId, Integer motherId) {
        Human child = findHumanById(childId);
        if (child != null) {
            Human father = (fatherId != null) ? findHumanById(fatherId) : null;
            Human mother = (motherId != null) ? findHumanById(motherId) : null;
            child.setFather(father);
            child.setMother(mother);

            if (father != null) {
                father.getChildren().add(child);
            }

            if (mother != null) {
                mother.getChildren().add(child);
            }

            fileFamilyTreeService.saveFamilyTree();
        }
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

    public Human findHumanById(int searchId) {
        return familyTree.findHumanById(searchId);
    }

    public List<Human> findHumansByName(String searchInput) {
        return familyTree.findHumansByName(searchInput);
    }

    public void finish() {
        fileFamilyTreeService.saveFamilyTree();
    }
}
