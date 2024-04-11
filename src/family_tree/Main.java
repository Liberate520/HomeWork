package family_tree;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human vladimir = new Human("Vladimir", "Male");
        Human natalya = new Human("Natalya", "Female");
        Human andrey = new Human("Andrey", "Male");
        Human lydmila = new Human("Lydmila", "Female");
        Human mikhail = new Human("Mikhail", "Male");
        Human nina = new Human("Nina", "Female");
        Human ivan = new Human("Ivan", "Male");

        familyTree.addPerson(lydmila);
        familyTree.addPerson(mikhail);
        familyTree.addPerson(nina);
        familyTree.addPerson(ivan);
        familyTree.addChild(natalya, nina, ivan);
        familyTree.addChild(vladimir, lydmila, mikhail);
        familyTree.addPerson(andrey, natalya, vladimir);

        familyTree.displayFamilyTree();
    }
}
