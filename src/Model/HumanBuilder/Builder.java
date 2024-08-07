package Model.HumanBuilder;

import Model.FamilyTree.ItemFamilyTree;
import Model.Human.Gender;

import java.time.LocalDate;

public interface Builder <T extends ItemFamilyTree<T>>{
    public T buildHuman(String name, LocalDate dateBrith, Gender gender);
}
