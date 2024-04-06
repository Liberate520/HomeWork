import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree =TestTree();


        Human human1 = new Human();
        human1.setName("Иван");
        human1.setDob(LocalDate.of(1928, 5, 15));
        human1.setDod(LocalDate.of(2013, 10, 19));
        human1.setGender(Gender.Мужской);

        Human human2 = new Human();
        human2.setName("Мария");
        human2.setDob(LocalDate.of(1929, 10, 13));
        human2.setGender(Gender.Женский);

        Human human3 = new Human();
        human3.setName("Сергей");
        human3.setDob(LocalDate.of(1957, 5, 15));
        human3.setGender(Gender.Мужской);
        human3.setFather(human1);
        human3.setMother(human2);


        Human human4 = new Human();
        human4.setName("Федор");
        human4.setDob(LocalDate.of(1984, 7, 9));
        human4.setGender(Gender.Мужской);
        human4.setFather(human3);
        //human4.setMother(human5);
        //human4.addchildren(human6);

        Human human5 = new Human();
        human5.setName("Светлана");
        human5.setDob(LocalDate.of(1985, 3, 8));
        human5.setGender(Gender.Женский);
        human5.setFather(human2);

        human1.addChildren(human3);
        human2.addChildren(human3);
        human3.addSpouse(human5);

        tree.addHumantoTree(human1);
        tree.addHumantoTree(human2);
        tree.addHumantoTree(human3);
        tree.addHumantoTree(human4);
        tree.addHumantoTree(human5);

        System.out.println(tree);


//        System.out.println(human1 + "\n");
//        System.out.println(human2 + "\n");
//        System.out.println(human3 + "\n");
//        //System.out.println(human2.getChildrenList(human2));
//        System.out.println(human1.equals(human2));
//        System.out.println();
//        System.out.println(human1.getGender());
//        System.out.println(human2.getGender());
//        System.out.println(human3.getGender());
//        System.out.println(human4.getGender());
//        System.out.println(human4.addParents(human2));
//        System.out.println(human4.getParents());


    }

    private static FamilyTree TestTree() {
        return new FamilyTree();
    }


}