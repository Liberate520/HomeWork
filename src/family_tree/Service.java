package family_tree;

import human.Gender;
import human.Human;
import human.HumanBuilder;

import java.time.LocalDate;

public class Service<E extends FamilyTreeItem>{
    private FamilyTree familyTree;
    private HumanBuilder humanBuilder;

    public Service(){
        familyTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate){
        Human human = humanBuilder.setName(name).setGender(gender).setBirthDate(birthDate).build();
        familyTree.add((E) human);
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }
}
