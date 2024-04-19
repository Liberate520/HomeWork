import Dogs.Dog;
import FamilyTree.FamilyTree;
import Human.Human;
import Writer.FileHandler;
import Human.Gender;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        FamilyTree humanTree = new FamilyTree();
        FamilyTree dogTree = new FamilyTree();

        Human human1 = new Human("Иван", Gender.Мужской, LocalDate.of(1928, 5, 15));
        Human human2 = new Human("Мария", Gender.Женский, LocalDate.of(1929, 10, 13));
        Human human3 = new Human("Сергей", Gender.Мужской, LocalDate.of(1957, 5, 15));
        Human human4 = new Human("Федор", Gender.Мужской, LocalDate.of(1984, 7, 9));
        Human human5 = new Human("Светлана", Gender.Женский, LocalDate.of(1985, 3, 8));
        Human human6 = new Human("Василий", Gender.Мужской, LocalDate.of(1988, 12, 12));

        human1.setDod(LocalDate.of(2013, 10, 19));
        human3.setFather(human1);
        human3.setMother(human2);
        human4.setFather(human3);
        human5.setMother(human2);
        human1.addChildren(human3);
        human2.addChildren(human5);
        human3.addSpouse(human5);


        humanTree.addMembertoTree(human1);
        humanTree.addMembertoTree(human2);
        humanTree.addMembertoTree(human3);
        humanTree.addMembertoTree(human4);
        humanTree.addMembertoTree(human5);
        humanTree.addMembertoTree(human6);
        //System.out.println(tree);
        List<String>NameList = new ArrayList<>();

        for (Object element : humanTree) {
            if (element instanceof Human) {
                Human humanElement = (Human) element;
                NameList.add(humanElement.getName());
            }
        }


        Dog dog1 = new Dog("Zevs", Dogs.Gender.Мужской,LocalDate.of(2021, 3, 8));
        Dog dog2 = new Dog("Riso", Dogs.Gender.Женский,LocalDate.of(2022, 10, 07));
        Dog dog3 = new Dog("Kay", Dogs.Gender.Мужской,LocalDate.of(2022, 3, 8));
        Dog dog4 = new Dog("Wasabi", Dogs.Gender.Женский,LocalDate.of(2019, 7, 18));
        Dog dog5 = new Dog("Naruto", Dogs.Gender.Мужской,LocalDate.of(2009, 5, 13));

        dog4.setFather(dog1);
        dog4.setMother(dog2);
        dog5.setFather(dog3);
        dog1.addChildren(dog4);
        dog4.addSpouse(dog5);


        humanTree.addMembertoTree(human1);
        humanTree.addMembertoTree(human2);
        humanTree.addMembertoTree(human3);
        humanTree.addMembertoTree(human4);
        humanTree.addMembertoTree(human5);
        humanTree.addMembertoTree(human6);

        dogTree.addMembertoTree(dog1);
        dogTree.addMembertoTree(dog2);
        dogTree.addMembertoTree(dog3);
        dogTree.addMembertoTree(dog4);
        dogTree.addMembertoTree(dog5);

        dogTree.sortByName();
        dogTree.sortByDateOfBirth();
        System.out.println(dogTree);

    }
}
