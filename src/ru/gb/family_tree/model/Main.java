package ru.gb.family_tree.model;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.tree.FileHandler;
import ru.gb.family_tree.model.tree.Writeable;


import java.time.LocalDate;

import static ru.gb.family_tree.model.human.Gender.Female;
import static ru.gb.family_tree.model.human.Gender.Male;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Service service = new Service();
        String filePath = "src\\ru\\gb\\family_tree\\tree\\tree.txt";

        Human human1 = service.createElement("Maria", "Pushkin", LocalDate.of(1700, 2, 25), LocalDate.of(1790, 5, 3), Female);
        Human human2 = service.createElement("Pavel", "Pushkin", LocalDate.of(1695, 8, 15), LocalDate.of(1790, 5, 3), Male);
        Human human3 = service.createElement("Alexander", "Pushkin", LocalDate.of(1730, 5, 21), LocalDate.of(1767, 11, 4), Male, human1, human2);
        Human human4 = service.createElement("Michael", "Pushkin", LocalDate.of(1730, 5, 21), LocalDate.of(1759, 5, 14), Male, human1, human2);
        Human human5 = service.createElement("Svetlana", "Pushkin", LocalDate.of(1735, 4, 13), LocalDate.of(1770, 1, 2), Female);
        Human human6 = service.createElement("Alena", "Pushkin", LocalDate.of(1733, 9, 23), LocalDate.of(1772, 5, 1), Female);
        Human human7 = service.createElement("Konstantin", "Pushkin", LocalDate.of(1755, 5, 15), LocalDate.of(1820, 7, 10), Male, human3, human5);
        Human human8 = service.createElement("Polina", "Pushkin", LocalDate.of(1758, 10, 4), LocalDate.of(1825, 2, 25), Female, human4, human6);
        Human human9 = service.createElement("Sergei", "Pushkin", LocalDate.of(1761, 4, 29), LocalDate.of(1827, 12, 31), Male, human4, human6);


        human1.addChilds(human3, human4);
        human2.addChilds(human3, human4);
        human3.addChilds(human7);
        human5.addChilds(human7);
        human4.addChilds(human8, human9);
        human6.addChilds(human8, human9);

        service.addHumansInFamTree(human1, human2, human3, human4
                , human5, human6, human7, human8, human9);

        // Пустые id запоминаются после удаления.
        // Так удобно редактировать любого человека с нуля и не допускать пустых id при добавлении новых людей.

        service.removeHumansFromFamTree(human8);  // В данном случае освободится id 7.

        //Теперь human10 займёт освободившийся id 7, а все остальные останутся на своих местах.
        // Пока есть пустые id, все новые люди будут их себе присваивать, только потом новые.

        Human human10 = service.createElement("Diara", "Pushkin", LocalDate.of(1766, 6, 19), LocalDate.of(1829, 10, 5), Female, human4, human6);

        human4.addChilds(human10);
        human6.addChilds(human10);

        service.addHumansInFamTree(human10);

        familyTree = load(filePath);
//        save(familyTree, filePath);

        service.sortByFirstName();
        service.sortByGender();
        service.sortByDob();
        service.sortByDod();
        service.sortById();

        System.out.println(service.ShowTree());
    }


    private static FamilyTree load(String filePath) {
        Writeable writeable = new FileHandler();
        return (FamilyTree) writeable.read(filePath);
    }


    private static void save(FamilyTree familyTree, String filePath) {
        Writeable writeable = new FileHandler();
        writeable.save(familyTree, filePath);
    }
}
