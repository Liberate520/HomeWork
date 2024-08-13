import forView.NewView;
import module.lesson2.familytree.FamilyTree;
import module.lesson2.human.FamilyStatus;
import module.lesson2.human.Gender;
import module.lesson2.human.Human;
import module.lesson2.human.Status;
import module.lesson2.service.Service;
import module.lesson2.writer.WriteReadHuman;
import presenter.NewPresenter;

import java.io.IOException;
import java.time.LocalDate;

public class MainFamily {
    public static void main(String[] args) throws IOException {
        Human human = new Human(1,"DEdvard Hichichickoy", LocalDate.of(1886,11,7), LocalDate.of(1887,5,25), Gender.MAN, FamilyStatus.HUSBAND);
        Human human1 = new Human(2,"CElena Hichichickoy",LocalDate.of(1890,4,20),LocalDate.of(1892,8,5),Gender.WOMAN,FamilyStatus.WIFE);

        human.setDateOfMarriage(LocalDate.of(1907,7,7));
        human1.setDateOfMarriage(LocalDate.of(1907,7,7));

        human.setWhoSpouse(human1);
        human1.setWhoSpouse(human);

        Human human2 = new Human(3,"Betsy Hichichickoy",LocalDate.of(1908,10,9), LocalDate.of(1911,11,12),Gender.WOMAN,FamilyStatus.WIFE);
        Human human3 = new Human(4,"ARebecca Hichichickoy", LocalDate.of(1910,1,5), LocalDate.of(1914,2,12),Gender.WOMAN,FamilyStatus.WIFE);
        human2.addParents(human);
        human2.addParents(human1);
        human3.addParents(human);
        human3.addParents(human1);

        human.addChildren(human2);
        human.addChildren(human3);

        human1.addChildren(human2);
        human1.addChildren(human3);

        FamilyTree<Human> familyTree = new FamilyTree<>();

        familyTree.addPeople(human);
        familyTree.addPeople(human1);
        familyTree.addPeople(human2);
        familyTree.addPeople(human3);

        familyTree.printPeopleList();
        familyTree.printChildren(human);
        familyTree.printChildren(human1);
        familyTree.printParents(human2);
        familyTree.printParents(human3);

        System.out.println("///");
        System.out.println(familyTree.getPeopleList());
        System.out.println("///");

        familyTree.sortByName(familyTree.getPeopleList());
        System.out.println(familyTree.getPeopleList());
        System.out.println("///");
        familyTree.sortByAge(familyTree.getPeopleList());
        System.out.println(familyTree.getPeopleList());


        WriteReadHuman<Human> writeReadHuman = new WriteReadHuman<>();
        System.out.println();
        writeReadHuman.writeHuman(human2);
        System.out.println(writeReadHuman.readHuman().getInfo());
        writeReadHuman.writeHuman(human3);
        System.out.println(writeReadHuman.readHuman().getInfo());

        NewPresenter<Human> newPresenter = new NewPresenter<>(new NewView(), new Service(new FamilyTree<>(), new WriteReadHuman<>()), new Status());
        newPresenter.choice();
    }
}
