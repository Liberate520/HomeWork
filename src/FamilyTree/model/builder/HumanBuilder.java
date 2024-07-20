package FamilyTree.model.builder;

import FamilyTree.model.element.ElementFamilyTree;
import FamilyTree.model.element.Gender;
import FamilyTree.model.element.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanBuilder <E extends ElementFamilyTree<E>> implements ItemBuilder<Human>{

    @Override
    public Human createItem(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother, List<Human> children, Human spouse) {
        if(father == null){
            father = new Human();
        }
        if(mother == null){
            mother = new Human();
        }
        if(spouse == null){
            spouse = new Human();
        }
        if(children.isEmpty() || children.getFirst() == null){
            children = new ArrayList<>();
        }
        return new Human(name, gender, birthDate, deathDate, father, mother, children, spouse);
    }
}
