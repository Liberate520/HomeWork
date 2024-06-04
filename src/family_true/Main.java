package family_true;

import family_true.model.family_tree.Entity;
import family_true.api.Externalizable;
import family_true.model.family_tree.FamilyTree;
import family_true.model.family_tree.Service;
import family_true.model.family_tree.defalt_comporator.ComparatorIndexId;
import family_true.model.human.Gender;
import family_true.model.human.Human;
import family_true.impl.FileHandler;
import family_true.view.ConsoleUI;
import family_true.view.View;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
        //testData();
    }

    public static void testData() {
        Service service = new Service();

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

        List<Human> humans = List.of(father0, mother0,
                father1, father2, father3, father4,
                mother1, mother2, mother3, mother4,
                child1, child2, child3, child4, child5, child6, child7, child8);

        for (Human human : humans) {
            service.addHumanToLastTree(human);
        }

        Externalizable ext = new FileHandler(service);
        // Записываем объект List<FamilyTree> в файл
        ext.writeAllExternal(service.getFamilyTreeGroup().getFamilyTreeList());

        // Получаем объект из файла
        List<FamilyTree<Human>> familyTreeList = ext.readExternal();

        System.out.println("=========================SORT BY LAST NAME=============================");
        service.sortFamilyTreesEntitiesByLastName(familyTreeList);
        System.out.println(familyTreeList.toString());
        System.out.println("==================================================================\n");

        Human father9 = new Human("Владимир", "Ильич", "Левин", Gender.MALE, LocalDate.of(1953, 10, 11));
        Human mother9 = new Human("Мария", "Вячеславовна", "Левин", Gender.FEMALE, LocalDate.of(1955, 7, 15));
        mother9.setSpouse(father9);

        Human child9 = new Human("Митрофан", "Иванович", "Иванов", Gender.MALE, LocalDate.of(1986, 1, 11), mother9, father9);
        Human child10 = new Human("Петр", "Петрович", "Петров", Gender.MALE, LocalDate.of(1988, 2, 12), mother9, father9);

        List<Human> humans2 = List.of(mother9, child9, child10);

        service.addHumanToNewTree(father9);
        for (Human human : humans2) {
            service.addHumanToLastTree(human);
        }

        // Обновляем объект List<FamilyTree> и перезаписываем в файл
        ext.updateExternal(service.addHumanToLastTree(child10));

        // Получаем объект из файла
        List<FamilyTree<Human>> familyTreeList2 = ext.readExternal();

        System.out.println("=========================SORT BY DATE=============================");
        service.sortFamilyTreesEntitiesByBirthDay(familyTreeList2);
        System.out.println(familyTreeList2.toString());
        System.out.println("==================================================================\n");
        Collections.reverse(familyTreeList2);
        System.out.println("=========================SORT FAMILY TREE BY ID=============================");
        Collections.sort(familyTreeList2, new ComparatorIndexId<Entity>());
        System.out.println(familyTreeList2.toString());
        System.out.println("==================================================================\n");

        for (FamilyTree familyTree : familyTreeList2) {
            Collections.reverse(familyTree.getEntities());
        }
        System.out.println(familyTreeList2.toString());
        System.out.println("=========================SORT HUMANS BY ID=============================");
        service.sortFamilyTreesEntitiesById(familyTreeList2);
        System.out.println(familyTreeList2.toString());
        System.out.println("==================================================================\n");
    }
}
