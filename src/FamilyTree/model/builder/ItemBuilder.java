package FamilyTree.model.builder;

import FamilyTree.model.familyTree.ElementFamilyTree;
import FamilyTree.model.human.Gender;

import java.time.LocalDate;

public interface ItemBuilder<E extends ElementFamilyTree<E>> {
    E createItem(String name, Gender gender, LocalDate birthDate, LocalDate deathDate);
}
