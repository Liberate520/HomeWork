package ru.gb.family_tree.Model.Family.Tree;

import ru.gb.family_tree.Model.Family.Family.Gender;
import ru.gb.family_tree.Model.Family.Family.Human;
import ru.gb.family_tree.Model.Family.Tree.FamilyTree;

import java.time.LocalDate;

public class CreationTreeHuman {
    private FamilyTree familyTree;

    public CreationTreeHuman(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }
    public static FamilyTree addTree() {
        FamilyTree familyTree1;
        familyTree1 = test();
        return familyTree1;
    }

    static FamilyTree test(){
        FamilyTree tree  = new FamilyTree();
        Human human1 = new Human("Петрова Наталья Ивановна", Gender.Female,
                LocalDate.of(1937, 12, 12), LocalDate.of(2010, 11, 11));
        Human human2 = new Human("Петров Михаил Сергеевич", Gender.Male,
                LocalDate.of(1933, 6, 12),LocalDate.of(2011,12,21));
        Human human3 = new Human("Петров Сергей  Михайлович", Gender.Male,
                LocalDate.of(1967, 12, 12), human1, human2);
        Human human4 = new Human("Иванова Анна Михайловна", Gender.Female,
                LocalDate.of(1967, 6, 12), human1, human2);
        Human human5 = new Human("Куликова Елена Анатольевна", Gender.Female,
                LocalDate.of(1964, 10, 12));
        Human human6 = new Human("Иванов Aндрей Юрьевич", Gender.Male,
                LocalDate.of(1964, 2, 10));
        Human human7 = new Human("Петров Сергей Сергеевич", Gender.Male,
                LocalDate.of(1989, 2, 10), human5, human3);

        tree.add(human1);
        tree.add(human2);
        tree.add(human3);
        tree.add(human4);
        tree.add(human5);
        tree.add(human6);
        tree.add(human7);

        tree.setWedding(human1, human2);
        tree.setWedding(human3, human5);
        tree.setWedding(human4, human6);


        return tree;
    }
}
