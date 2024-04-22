import family_tree.view.ConsoleUI;
import family_tree.view.View;


public class Main {
    public static void main(String[] args) {

//        Human nikita = new Human("Khrushev Nikita Sergeevich", LocalDate.of(1894, 4, 15), Gender.Male);
//        nikita.setDeadDate(LocalDate.of(1971, 9, 11));
//        Human serega = new Human("Khrushev Sergei Nikitich", LocalDate.of(1935, 7, 2), Gender.Male);
//        Human lyonya = new Human("Khrushev Leonid Nikitich", LocalDate.of(1917, 11, 10), Gender.Male);
//        Human nina = new Human("Kucharchuk-Khrusheva Nina Petrovna", LocalDate.of(1900, 4, 14), Gender.Female);
//        nina.setDeadDate(LocalDate.of(1984, 8, 13));
//        Human frosya = new Human("Pisareva Efrosiniya Ivanovna", LocalDate.of(1896, 1, 01), LocalDate.of(1919, 01, 01), Gender.Female, null, null);
//        Human juliya1st = new Human("Khrusheva Julia Nitichna", LocalDate.of(1916, 3, 04), LocalDate.of(1981, 4, 03), Gender.Female, nikita, frosya);
//        Human rada = new Human("Adjubey(Khrusheva) Rada Nitichna", LocalDate.of(1929, 4, 04), LocalDate.of(2016, 8, 11), Gender.Female, nikita, nina);
//
//
//        /*
//        1-st wife
//         */
//        System.out.println("1-st wife");
//        nikita.setPartner(frosya);
//        nikita.addChildFromThisPartner(frosya, lyonya);
//        nikita.addChildFromThisPartner(frosya, juliya1st);
//
//
//        /*
//        3-rd wife
//         */
//        System.out.println("2-nd");
//        nikita.setPartner(nina);
//        nikita.addChildFromThisPartner(nina, serega);
//        nikita.addChildFromThisPartner(nina, rada);
//
//
//        /*
//        Try to use the Service class
//         */
//        Service humanService = new Service<>(Human.class);
//        humanService.addSubjectToFamilyTree(nikita,2);
//        humanService.addSubjectToFamilyTree(nina,2);
//        humanService.addSubjectToFamilyTree(serega,1);
//        humanService.addSubjectToFamilyTree(lyonya,1);
//        humanService.addSubjectToFamilyTree(juliya1st,2);
//        humanService.addSubjectToFamilyTree(frosya,1);
//        humanService.addSubjectToFamilyTree(rada,1);
//
//
//        humanService.addSubjectToFamilyTree("Khrushev Sergey Nikanorovich",
//                LocalDate.of(1869, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
//                LocalDate.of(1938, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
//                Gender.Male, 3,Human.class);
//        humanService.addSubjectToFamilyTree("Khrusheva Kseniya Ivanovna",
//                LocalDate.of(1872, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
//                LocalDate.of(1945, new Random().nextInt(1, 13), new Random().nextInt(1, 28)),
//                Gender.Female, 3,Human.class);
//
//        humanService.setParentsForSubject("Khrushev Nikita Sergeevich", humanService.findByName("Khrushev Sergey Nikanorovich"));
//        humanService.setParentsForSubject("Khrushev Nikita Sergeevich", humanService.findByName("Khrusheva Kseniya Ivanovna"));
//
//        Human papaNikity = (Human) humanService.findByName("Khrushev Sergey Nikanorovich");
//        if (papaNikity != null) {
//            humanService.findByName("Khrushev Sergey Nikanorovich").
//                    setPartner(humanService.findByName("Khrusheva Kseniya Ivanovna") != null ?
//                            humanService.findByName("Khrusheva Kseniya Ivanovna") : null);
//        }
//
//
//        String filePathForTree = "src/family_tree/writer/familyTree.out";
//
//        /*
//         Serialization using ObjectOutputStream class using the service.
//         Created the method for writing an object as byte code
//         */
//        humanService.initializationFileHandler();
//        humanService.writeTreeAsByteCode(humanService.getFamilyTree(), filePathForTree);
//
//
//        //Renewing of an object from a byte code file using the class ObjectInputStream
//        FamilyTree treeRestored = humanService.readTreeFromByteCodeFile(filePathForTree);
//
//
//        /*
//         Different displaying of methods of sorting using the service (List of Humans or List of Names of Humans)
//         */
//        //ArrayList<Human> sortedByNameFamily = service.getFamilyTree().sortByName();
//        //System.out.println(service.getListOfNames(sortedByNameFamily));
//
//
//        //System.out.println(service.getListOfNames(service.getFamilyTree().sortByAge()));
//
//        System.out.println(("==".repeat(20)));
//        //System.out.println(service.sorting());
//
//        Scanner in = new Scanner(System.in);
//        int request = 0;
//        while ((request < 1) || (request > 3)) {
//            System.out.println("Enter the number of type of sorting (by Name is 1, by Age is 2 or by Date of birth is 3): ");
//            try {
//                request = in.nextInt();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println(humanService.getFamilyTree());

        View view = new ConsoleUI();
        view.start();

    }
}