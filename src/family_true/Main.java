package family_true;

import family_true.api.Externalizable;
import family_true.impl.FileHandler;

import java.time.LocalDate;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        long treeId = 1;
        FamilyTree familyTree = new FamilyTree(treeId++);

        Human father0 = new Human("Степан", "Юрьевич", "Степанов", Gender.MALE, LocalDate.of(1956, 1, 1));
        Human mother0 = new Human("Марина", "Ильинична", "Степанова", Gender.FEMALE, LocalDate.of(1958, 5, 5));
        mother0.setSpouse(father0);

        Human father1 = new Human("Иван", "Степанович", "Иванов", Gender.MALE, LocalDate.of(1976, 1, 1));
        Human father2 = new Human("Петр", "Петрович", "Петров", Gender.MALE, LocalDate.of(1978, 2, 2));
        Human father3 = new Human("Сидр", "Сидорович", "Сидоров", Gender.MALE, LocalDate.of(1979, 3, 3));
        Human father4 = new Human("Ярослав", "Ярославович", "Ярый", Gender.MALE, LocalDate.of(1981, 4, 4));

        Human mother1 = new Human("Марфа", "Петровна", "Иванова", Gender.FEMALE, LocalDate.of(1978, 5, 5));
        Human mother2 = new Human("Елена", "Степановна", "Петрова", Gender.FEMALE, LocalDate.of(1981, 6, 6));
        Human mother3 = new Human("Ольга", "Николаевна", "Сидорова", Gender.FEMALE, LocalDate.of(1983, 7, 7));
        Human mother4 = new Human("Валентина", "Антоновна", "Ярая", Gender.FEMALE, LocalDate.of(1985, 8, 8));

        father1.setFather(father0);
        father1.setMother(mother0);

        mother2.setFather(father0);
        mother2.setMother(mother0);

        mother1.setSpouse(father1);
        mother2.setSpouse(father2);
        mother3.setSpouse(father3);
        mother4.setSpouse(father4);

        Human child1 = new Human("Митрофан", "Иванович", "Иванов", Gender.MALE, LocalDate.of(1996, 1, 11), mother1, father1);
        Human child2 = new Human("Петр", "Петрович", "Петров", Gender.MALE, LocalDate.of(1998, 2, 12), mother2, null);
        child2.setFather(father2);
        Human child3 = new Human("Сидр", "Сидорович", "Сидоров", Gender.MALE, LocalDate.of(1999, 3, 13), null, father3);
        child3.setMother(mother3);
        Human child4 = new Human("Ярослав", "Ярославович", "Ярый", Gender.MALE, LocalDate.of(2001, 4, 14));
        child4.setMother(mother4);
        child4.setFather(father4);

        Human child5 = new Human("Марфа", "Ивановна", "Иванова", Gender.MALE, LocalDate.of(1998, 5, 15), mother1, father1);
        Human child6 = new Human("Елена", "Петровна", "Петрова", Gender.MALE, LocalDate.of(2001, 6, 16), mother2, null);
        child6.setFather(father2);
        Human child7 = new Human("Ольга", "Сидоровна", "Сидорова", Gender.MALE, LocalDate.of(2003, 7, 17), null, father3);
        child7.setMother(mother3);
        Human child8 = new Human("Валентина", "Ярославовна", "Ярая", Gender.MALE, LocalDate.of(2005, 8, 18));
        child8.setMother(mother4);
        child8.setFather(father4);

        familyTree.addHuman(father0);
        familyTree.addHuman(mother0);

        familyTree.addHuman(father1);
        familyTree.addHuman(father2);
        familyTree.addHuman(father3);
        familyTree.addHuman(father4);

        familyTree.addHuman(mother1);
        familyTree.addHuman(mother2);
        familyTree.addHuman(mother3);
        familyTree.addHuman(mother4);

        familyTree.addHuman(child1);
        familyTree.addHuman(child2);
        familyTree.addHuman(child3);
        familyTree.addHuman(child4);
        familyTree.addHuman(child5);
        familyTree.addHuman(child6);
        familyTree.addHuman(child7);
        familyTree.addHuman(child8);

        Externalizable ext = new FileHandler();
        ext.writeExternal(Collections.singletonList(familyTree));

        String str =  ext.readExternal().toString();
        System.out.println(str);
    }
}
