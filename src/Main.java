import java.util.ArrayList;
import Human.Human;
import family_tree1.FamilyTree;
import writer.FileHandler;

public static void main(String[] args) throws ClassNotFoundException {
    FamilyTree familyTree = new FamilyTree();
    fillingFamilyTree(familyTree);
    System.out.println(familyTree);

    FileHandler handler = new FileHandler();
    handler.write(familyTree, "FamilyTree.bin");

    FamilyTree ft;
    ft = handler.read("FamilyTree.bin");
    System.out.println(ft);
}

public static void main(String[] args) {

    Human h1 = new Human(0,"Daniil", 2017, "Male");

    Human h1_1 = new Human(1, "Julia", 2021, "Female");

    Human h2 = new Human(2, "Gleb Father", 1992, "Male");

    Human h3 = new Human(3, "Maria mother", 1993, "Female");

    Human h2_1 = new Human(4, "Vadim grandfather(father)", 1970,  "Male");

    Human h2_2 = new Human(5, "Elena grandmother(father)", 1970, "Female");

    Human h3_1 = new Human(6, "Victor grandfather(mother)", 1952, 2021, "Male");

    Human h3_2 = new Human(7, "Marina grandmother(mother)", 1968, "Female");

    h1.setFather(h2);
    h1.setMother(h3);
    h1_1.setFather(h2);
    h1_1.setMother(h3);


    h2.setFather(h2_1);
    h2.setMother(h2_2);

    h3.setFather(h3_1);
    h3.setMother(h3_2);


    ArrayList<Human> HumansFamily = new ArrayList<>();
    HumansFamily.add(h1);
    HumansFamily.add(h1_1);
    HumansFamily.add(h2);
    HumansFamily.add(h3);
    HumansFamily.add(h2_1);
    HumansFamily.add(h2_2);
    HumansFamily.add(h3_1);
    HumansFamily.add(h3_2);
    FamilyTree F1 = new FamilyTree(0, "Tseer", HumansFamily);


    System.out.println(F1.HumansFamily);

    System.out.println(F1.HumansFamily.get(0));
    System.out.println(F1.HumansFamily.get(1));
    System.out.println(F1.HumansFamily.get(2));
    System.out.println(F1.HumansFamily.get(3));

    System.out.println();
    FamilyTree.sortByName();
    for (HumansFamily person : familyTree) {
        System.out.println(person);
    }

    System.out.println();
    FamilyTree.sortByBirthDate();
    for (HumansFamily person : familyTree) {
        System.out.println(person);
    }
}

