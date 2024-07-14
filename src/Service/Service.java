package Service;

import java.time.LocalDate;
import FamilyTree.FamilyTree;
import FamilyTree.ItemFamilyTree;
import Humans.Gender;
import Humans.Human;
import Humans.HumanBuilder;

public class Service<U extends ItemFamilyTree<U>> {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;
    
    public Service(){
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
    }

    public void addHuman(String name, LocalDate dateOfBorn, LocalDate dateOfDeath, Gender gender){
        Human human =  humanBuilder.build(name, dateOfBorn, dateOfDeath, gender);
        familyTree.addHuman(human);
    }

}
