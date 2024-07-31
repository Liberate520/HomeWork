
// import writer.FileHandler;
import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;

public class Main {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        fillingFamilyTree(familyTree);
        System.out.println(familyTree);

        // familyTree.sortByAge();
        // System.out.println(familyTree);

        // familyTree.sortByName();
        // System.out.println(familyTree);

        // familyTree.sortByGender();
        // System.out.println(familyTree);

        /**
         * Для записи в файл
         */
        // FileHandler handler = new FileHandler();
        // handler.write(familyTree, "FamilyTree.bin");

        // FamilyTree ft;
        // ft = handler.read("FamilyTree.bin");
        // System.out.println(ft);
    }

    @SuppressWarnings("unchecked")
    public static void fillingFamilyTree(@SuppressWarnings("rawtypes") FamilyTree familyTree) {
        Human grandfather1 = new Human("Константин", Gender.Male, 1940, 7, 25);
        Human grandmother1 = new Human("Валентина", Gender.Female, 1942, 11, 5);

        grandfather1.setSpouse(grandmother1);

        Human grandfather2 = new Human("Андрей", Gender.Male, 1943, 2, 24);
        Human grandmother2 = new Human("Анастасия", Gender.Female, 1943, 8, 16);

        grandfather2.setSpouse(grandmother2);

        Human father = new Human("Александр", Gender.Male, 1963, 3, 17);
        father.setParents(grandfather1, grandmother1);

        Human mother = new Human("Наталья", Gender.Female, 1964, 8, 24);
        mother.setParents(grandfather2, grandmother2);

        father.setSpouse(mother);

        Human child = new Human("Алексей", Gender.Male, 1985, 6, 11);
        child.setParents(father, mother);

        familyTree.addHuman(grandfather1);
        familyTree.addHuman(grandmother1);
        familyTree.addHuman(grandfather2);
        familyTree.addHuman(grandmother2);
        familyTree.addHuman(father);
        familyTree.addHuman(mother);
        familyTree.addHuman(child);
    }
}