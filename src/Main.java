import family.human.Gender;
import family.HumanService;
import family.tree.FamilyTree;

import java.time.LocalDate;
import java.time.Month;

import java.io.IOException;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HumanService humanService = new HumanService();

        humanService.addHumanToTree("Maria", LocalDate.of(1975, Month.JANUARY, 12), Gender.Female);
        humanService.addHumanToTree("Egor", LocalDate.of(1973, Month.JUNE, 11), Gender.Male);
        humanService.addHumanToTree("Vladimir", LocalDate.of(2001, Month.APRIL, 15), Gender.Male);
        humanService.addHumanToTree("Victor", LocalDate.of(2011, Month.JULY, 10), Gender.Male);
        humanService.addHumanToTree("Egor", LocalDate.of(2003, Month.NOVEMBER, 7), Gender.Male);
        humanService.addHumanToTree("Elena", LocalDate.of(2003, Month.OCTOBER, 17), Gender.Female);
        humanService.addHumanToTree("Alexandr", LocalDate.of(2022, Month.SEPTEMBER, 5), Gender.Male);

//        Human Maria = builder.createHuman("Maria", LocalDate.of(1975, Month.JANUARY, 12), Gender.Female);
//        Human Egor = builder.createHuman("Egor", LocalDate.of(1973, Month.JUNE, 11), Gender.Male);
//        Human Vladimir = builder.createHuman("Vladimir", LocalDate.of(2001, Month.APRIL, 15), Gender.Male, Maria, Egor);
//        Human Victor = builder.createHuman("Victor", LocalDate.of(2011, Month.JULY, 100), Gender.Male, Maria, Egor);
//        Human Egor = builder.createHuman("Egor", LocalDate.of(2003, Month.NOVEMBER, 7), Gender.Male, Maria, Egor);
//        Human Elena = builder.createHuman("Elena", LocalDate.of(2003, Month.OCTOBER, 17), Gender.Female, Maria, Egor);
//        Human Alexandr = builder.createHuman("Alexandr", LocalDate.of(2022, Month.SEPTEMBER, 5), Gender.Male, Elena, Vladimir);

        System.out.println(humanService.printTreeInfo());
        humanService.setParent(2,0);
        humanService.setParent(2, 1);
        humanService.setParent(4,0);
        humanService.setParent(4,1);
        humanService.setParent(5,0);
        humanService.setParent(6,5);
        humanService.setParent(6,2);
        humanService.setRelationships();
        System.out.println(humanService.getById(2).getParents());
        System.out.println(humanService.getSiblings(2));
        System.out.println(humanService.getAncestors(6,2));
        System.out.println(humanService.getDescendants(0,2));
        humanService.sortByName();
        System.out.println(humanService.printTreeInfo());
        humanService.sortByAge();
        System.out.println(humanService.printTreeInfo());
        humanService.sortById();
        System.out.println(humanService.printTreeInfo());

        humanService.save();

        FamilyTree tree = humanService.load();

        System.out.println("=========================");
        System.out.println(tree.getById(0));

    }
}