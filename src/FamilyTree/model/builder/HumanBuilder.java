package FamilyTree.model.builder;

import FamilyTree.model.builder.ItemBuilder;
import FamilyTree.model.familyTree.ElementFamilyTree;
import FamilyTree.model.human.Gender;
import FamilyTree.model.human.Human;

import java.time.LocalDate;

public class HumanBuilder<E extends ElementFamilyTree<E>> implements ItemBuilder {

    public E createItem(String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
        Human human = new Human(name, gender, birthDate, deathDate);
        return (E) human;
    }
}
