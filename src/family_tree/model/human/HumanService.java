package family_tree.model.human;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.writer.FileHandler;

import java.time.LocalDate;

public class HumanService {
    private FamilyTree<Human> familyTree;

    public HumanService() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String surname, String name, String middleName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        Human human = new Human(surname, name, middleName, gender, birthDate, deathDate);
        familyTree.add(human);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public String getFamilyTreeInfo() {
        return familyTree.getInfo();
    }

    public void addSpouse(long humanId1, long humanId2){
        familyTree.setWedding(humanId1, humanId2);
    }

    public void deleteSpouse(long humanId1, long humanId2){
        familyTree.setDivorce(humanId1, humanId2);
    }

    public void setRelationship(long childId, long parentId) {
        familyTree.setRelationship(childId, parentId);
    }

    public void save() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(this.familyTree);
    }

    public FamilyTree<Human> load() {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.load();
    }
}
