import familytree.FamilyTree;
import human.FamilyStatus;
import human.Gender;
import human.Human;
import ru.geekbrains.lesson2.WriteReadHuman;
import sortHuman.IterableHuman;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainFamily {
    public static void main(String[] args) {
        Human human = new Human("Edvard Hichichickoy", LocalDate.of(1886,11,7), LocalDate.of(1920,5,25), Gender.MAN, FamilyStatus.HUSBAND);
        Human human1 = new Human("Elena Hichichickoy",LocalDate.of(1890,4,20),LocalDate.of(1930,8,5),Gender.WOMAN,FamilyStatus.WIFE);

        human.setDateOfMarriage(LocalDate.of(1907,7,7));
        human1.setDateOfMarriage(LocalDate.of(1907,7,7));

        human.setWhoSpouse(human1);
        human1.setWhoSpouse(human);

        Human human2 = new Human("Betsy Hichichickoy",LocalDate.of(1908,10,9), LocalDate.of(1960,11,12),Gender.WOMAN,FamilyStatus.WIFE);
        Human human3 = new Human("Rebecca Hichichickoy", LocalDate.of(1910,1,5), LocalDate.of(1990,2,12),Gender.WOMAN,FamilyStatus.WIFE);
        human2.addParents(human);
        human2.addParents(human1);
        human3.addParents(human);
        human3.addParents(human1);

        human.addChildren(human2);
        human.addChildren(human3);

        human1.addChildren(human2);
        human1.addChildren(human3);

        FamilyTree familyTree = new FamilyTree();
        ArrayList<Human> newHumanList = familyTree.getPeopleList();
        newHumanList.add(human);
        newHumanList.add(human1);
        newHumanList.add(human2);
        newHumanList.add(human3);

        familyTree.printPeopleList();
        familyTree.printChildren(human);
        familyTree.printChildren(human1);
        familyTree.printParents(human2);
        familyTree.printParents(human3);

        IterableHuman iterableHuman = new IterableHuman();
        iterableHuman.addHuman(human);
        iterableHuman.addHuman(human);
        iterableHuman.addHuman(human);
        iterableHuman.addHuman(human1);

        System.out.println("///");
        for (Human oneHuman: iterableHuman) {
            System.out.println(oneHuman.getInfo());
        }
        System.out.println("///");
        System.out.println(newHumanList);
        System.out.println("///");
        Collections.sort(newHumanList);
        System.out.println(newHumanList);
        System.out.println("///");
        newHumanList.sort(Comparator.comparingInt(w -> w.howManyYears(w.getDateDeath(), w.getDateBirth())));
        System.out.println(newHumanList);


        WriteReadHuman<Human> writeReadHuman = new WriteReadHuman<>();
        System.out.println();
        writeReadHuman.writeHuman(human2);
        System.out.println(writeReadHuman.readHuman().getInfo());
        writeReadHuman.writeHuman(human3);
        System.out.println(writeReadHuman.readHuman().getInfo());
    }
}
