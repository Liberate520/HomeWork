import family_tree.person.Gender;
import family_tree.person.Human;
import family_tree.service.Service;
import family_tree.tree.FamilyTree;
import family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Human nikita = new Human("Khrushev Nikita Sergeevich", LocalDate.of(1894, 4, 15), Gender.Male);
        nikita.setDeadDate(LocalDate.of(1971, 9, 11));
        Human serega = new Human("Khrushev Sergei Nikitich", LocalDate.of(1935, 7, 2), Gender.Male);
        Human lyonya = new Human("Khrushev Leonid Nikitich", LocalDate.of(1917, 11, 10), Gender.Male);
        Human nina = new Human("Kucharchuk-Khrusheva Nina Petrovna", LocalDate.of(1900, 4, 14), Gender.Female);
        nina.setDeadDate(LocalDate.of(1984, 8, 13));
        Human frosya = new Human("Pisareva Efrosiniya Ivanovna", LocalDate.of(1896, 1, 01), LocalDate.of(1919, 01, 01), Gender.Female, null, null);
        Human juliya1st = new Human("Khrusheva Julia Nitichna", LocalDate.of(1916, 3, 04), LocalDate.of(1981, 4, 03), Gender.Female, nikita, frosya);
        Human rada = new Human("Adjubey(Khrusheva) Rada Nitichna", LocalDate.of(1929, 4, 04), LocalDate.of(2016, 8, 11), Gender.Female, nikita, nina);


        /*
        1-st wife
         */
        nikita.setPartner(frosya);
        nikita.addChildFromThisPartner(frosya, lyonya);
        nikita.addChildFromThisPartner(frosya, juliya1st);

        frosya.setPartner(nikita);
        frosya.addChildFromThisPartner(nikita, lyonya);
        frosya.addChildFromThisPartner(nikita, juliya1st);

        /*
        3-rd wife
         */
        nikita.setPartner(nina);
        nikita.addChildFromThisPartner(nina, serega);
        nikita.addChildFromThisPartner(nina, rada);

        nina.setPartner(nikita);
        nina.addChildFromThisPartner(nikita, serega);
        nina.addChildFromThisPartner(nikita, rada);

        /*
        Add the information about parents
         */
        lyonya.setFather(nikita);
        lyonya.setMother(frosya);

        serega.setFather(nikita);
        serega.setMother(nina);

        /*
        Create the family tree
         */
//        FamilyTree tree = new FamilyTree();
//        tree.addPersonToFamily(nikita, 2);
//        tree.addPersonToFamily(nina, 2);
//        tree.addPersonToFamily(serega, 1);
//        tree.addPersonToFamily(lyonya, 1);
//        tree.addPersonToFamily(frosya, 2);
//        tree.addPersonToFamily(juliya1st, 1);
//        tree.addPersonToFamily(rada, 1);

        /*
        Try to use the Service class
         */
        Service service = new Service();
        service.addHumanToFamilyTree(2, nikita);
        service.addHumanToFamilyTree(2, nina);
        service.addHumanToFamilyTree(1, serega);
        service.addHumanToFamilyTree(1, lyonya);
        service.addHumanToFamilyTree(2, frosya);
        service.addHumanToFamilyTree(1, juliya1st);
        service.addHumanToFamilyTree(1, rada);

        service.addHumanToFamilyTree(3, "Khrushev Sergey Nikanorovich",
                LocalDate.of(1869, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
                LocalDate.of(1938, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
                Gender.Male);
        service.addHumanToFamilyTree(3, "Khrusheva Kseniya Ivanovna",
                LocalDate.of(1872, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
                LocalDate.of(1945, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
                Gender.Male);

        service.setParentsForHuman("Khrushev Nikita Sergeevich", service.findByName("Khrushev Sergey Nikanorovich"));
        service.setParentsForHuman("Khrushev Nikita Sergeevich", service.findByName("Khrusheva Kseniya Ivanovna"));


        String filePathForTree = "src/family_tree/writer/familyTree.out";

        /*
         Serialization using ObjectOutputStream class
         Created the method for writing an object as byte code
         */
        FileHandler fileHandler = new FileHandler();
        fileHandler.writeTreeAsByteCode(service.getFamilyTree(), filePathForTree);

        //Renewing of an object from a byte code file using the class ObjectInputStream

        FamilyTree treeRestored = fileHandler.readFromByteCodeFile(filePathForTree);


        /*
         Different displaying of methods of sorting using the service (List of Humans or List of Names of Humans)
         */
        ArrayList<Human> sortedByNameFamily = service.getFamilyTree().sortByName();

        System.out.println(service.sortByAge());
        System.out.println(("==".repeat(20)));
        System.out.println(service.sortByName());

    }
}