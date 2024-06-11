package FamilyTree.model.builder;

import FamilyTree.model.element.ElementFamilyTree;
import FamilyTree.model.element.Gender;
import FamilyTree.model.element.Human;

import java.time.LocalDate;
import java.util.List;

public interface ItemBuilder<E extends ElementFamilyTree<E>> {
    Human createItem(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, E father, E mother, List<E> children, E spouse);
}
