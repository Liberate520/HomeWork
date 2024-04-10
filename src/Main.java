import family_tree.person.Gender;
import family_tree.person.Human;
import family_tree.service.Service;
import family_tree.tree.FamilyTree;


import java.time.LocalDate;
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
        System.out.println("1-st wife");
        nikita.setPartner(frosya);
        nikita.addChildFromThisPartner(frosya, lyonya);
        nikita.addChildFromThisPartner(frosya, juliya1st);


        /*
        3-rd wife
         */
        System.out.println("2-nd");
        nikita.setPartner(nina);
        nikita.addChildFromThisPartner(nina, serega);
        nikita.addChildFromThisPartner(nina, rada);


        /*
        Try to use the Service class
         */
        Service<Human> humanService = new Service<>(Human.class);
        humanService.addHumanToFamilyTree(2, nikita);
        humanService.addHumanToFamilyTree(2, nina);
        humanService.addHumanToFamilyTree(1, serega);
        humanService.addHumanToFamilyTree(1, lyonya);
        humanService.addHumanToFamilyTree(2, frosya);
        humanService.addHumanToFamilyTree(1, juliya1st);
        humanService.addHumanToFamilyTree(1, rada);


        humanService.addHumanToFamilyTree(3, "Khrushev Sergey Nikanorovich",
                LocalDate.of(1869, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
                LocalDate.of(1938, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
                Gender.Male, Human.class);
        humanService.addHumanToFamilyTree(3, "Khrusheva Kseniya Ivanovna",
                LocalDate.of(1872, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
                LocalDate.of(1945, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
                Gender.Female, Human.class);

        humanService.setParentsForHuman("Khrushev Nikita Sergeevich", humanService.findByName("Khrushev Sergey Nikanorovich"));
        humanService.setParentsForHuman("Khrushev Nikita Sergeevich", humanService.findByName("Khrusheva Kseniya Ivanovna"));

        Human papaNikity = humanService.findByName("Khrushev Sergey Nikanorovich");
        if( papaNikity != null){
            humanService.findByName("Khrushev Sergey Nikanorovich").
                    setPartner(humanService.findByName("Khrusheva Kseniya Ivanovna") != null ?
                            humanService.findByName("Khrusheva Kseniya Ivanovna"): null);
        }



        String filePathForTree = "src/family_tree/writer/familyTree.out";

        /*
         Serialization using ObjectOutputStream class using the service.
         Created the method for writing an object as byte code
         */
        humanService.initializationFileHandler();
        humanService.writeTreeAsByteCode(humanService.getFamilyTree(), filePathForTree);


        //Renewing of an object from a byte code file using the class ObjectInputStream
        FamilyTree treeRestored = humanService.readTreeFromByteCodeFile(filePathForTree);


        /*
         Different displaying of methods of sorting using the service (List of Humans or List of Names of Humans)
         */
        //ArrayList<Human> sortedByNameFamily = service.getFamilyTree().sortByName();
        //System.out.println(service.getListOfNames(sortedByNameFamily));


        //System.out.println(service.getListOfNames(service.getFamilyTree().sortByAge()));

        System.out.println(("==".repeat(20)));
        //System.out.println(service.sorting());


//        HumanIterator<Human> iterator= new HumanIterator<>(service.getFamilyTree().
//                convertToList(service.getFamilyTree().getFamilyTree()));
//        System.out.println(service.getFamilyTree().getInfo());


    }
}