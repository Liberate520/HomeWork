package family_tree.model.human;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.writer.FileHandler;
import family_tree.model.writer.Writer;

import java.time.LocalDate;

public class HumanService implements HumanServiceInterface {
    private FamilyTree<Human> familyTree;
    private Writer writer;

    public HumanService() {
        this.writer = new FileHandler();
        familyTree = new FamilyTree<>();
    }

    @Override
    public void addHuman(String surname, String name, String middleName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        Human human = new Human(surname, name, middleName, gender, birthDate, deathDate);
        familyTree.add(human);
    }

    @Override
    public void sortByName() {
        familyTree.sortByName();
    }

    @Override
    public void sortByAge() {
        familyTree.sortByAge();
    }

    @Override
    public String getFamilyTreeInfo() {
        return familyTree.getInfo();
    }

    @Override
    public void addSpouse(long humanId1, long humanId2){
        familyTree.setWedding(humanId1, humanId2);
    }

    @Override
    public void deleteSpouse(long humanId1, long humanId2){
        familyTree.setDivorce(humanId1, humanId2);
    }

    @Override
    public void setRelationship(long childId, long parentId) {
        familyTree.setRelationship(childId, parentId);
    }

    @Override
    public void save() {
        writer.save(this.familyTree);
    }

    @Override
    public void load() {
        familyTree = (FamilyTree) writer.load();
    }
}
