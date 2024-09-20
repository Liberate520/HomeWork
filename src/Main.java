import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        FamilyTree familyTree = new FamilyTree();
        Human petr = new Human("Petr", "Petrov", LocalDate.of(1990, 1, 1), Gender.male);
        Human elena = new Human("Elena", "Ivanova", LocalDate.of(1990, 2, 25), Gender.female);
        Human polina = new Human("Polina", "Petrova", LocalDate.of(2010, 3, 15), Gender.female);
        Human igor = new Human("Igor", "Petrov", LocalDate.of(1950, 10, 13), LocalDate.of(2010, 8, 18), Gender.male);
        Human maksim = new Human("Maksim", "Petrov", LocalDate.of(2010, 3, 15), Gender.male, elena, petr);
        Human petrov = new Human("Petrov", "Petro", LocalDate.of(2010, 3, 15), Gender.male, elena, petr);

        elena.addChildren(polina);
        petr.addChildren(polina);
        petr.setParent(igor);


        familyTree.addHuman(petr);
        familyTree.addHuman(elena);
        familyTree.addHuman(polina);
        familyTree.addHuman(igor);
        familyTree.addHuman(maksim);
        familyTree.addHuman(petrov);
        familyTree.setWedding(petr, elena);

        System.out.println(familyTree);
        System.out.println(polina.infoSiblings());

        System.out.println(familyTree.findByName("Petrov"));


        String filePath = "C:/Users/Алёна/IdeaProjects/homeWorkFamilyTree/fam_tree.txt";
        save(familyTree, filePath);

    }

    private static FamilyTree load(String filePath) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);
    }

    private static void save(FamilyTree tree, String filePath) {
        Writable writable = new FileHandler();
        writable.save(tree, filePath);
    }
}
