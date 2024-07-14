package family_tree.family;

import family_tree.writer.FileHandier;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public FamilyTree ft_create(){
        Human paternalGrandfather = new Human(
                "Petr", "Ivanov", "Sergeevich",
                LocalDate.of(1940, 4, 18),
                null, null, Gender.MALE
        );

        Human paternalGrandmother = new Human(
                "Anna", "Ivanova", "Ivanovna",
                LocalDate.of(1945, 7, 22),
                null, null, Gender.FEMALE
        );

        Human maternalGrandfather = new Human(
                "Sergey", "Petrov", "Alekseevich",
                LocalDate.of(1938, 3, 12),
                null, null, Gender.MALE
        );

        Human maternalGrandmother = new Human(
                "Elena", "Petrova", "Nikolaevna",
                LocalDate.of(1942, 11, 5),
                null, null, Gender.FEMALE
        );

        Human father = new Human(
                "Ivan", "Ivanov", "Petrovich",
                LocalDate.of(1970, 1, 15),
                paternalGrandfather, paternalGrandmother, Gender.MALE
        );

        Human mother = new Human(
                "Maria", "Ivanova", "Sergeevna",
                LocalDate.of(1975, 5, 10),
                maternalGrandfather, maternalGrandmother, Gender.FEMALE
        );

        Human child1 = new Human(
                "Sergey", "Ivanov", "Ivanovich",
                LocalDate.of(2000, 6, 25),
                father, mother, Gender.MALE
        );

        Human child2 = new Human(
                "Olga", "Ivanova", "Ivanovna",
                LocalDate.of(2005, 8, 30),
                father, mother, Gender.FEMALE
        );

        Human child3 = new Human(
                "Nikolay", "Ivanov", "Ivanovich",
                LocalDate.of(2010, 12, 15),
                father, mother, Gender.MALE
        );

        paternalGrandfather.addChild(father);
        paternalGrandmother.addChild(father);

        maternalGrandfather.addChild(mother);
        maternalGrandmother.addChild(mother);
        father.addChild(child1);
        father.addChild(child2);
        father.addChild(child3);

        mother.addChild(child1);
        mother.addChild(child2);
        mother.addChild(child3);

        FamilyTree ft = new FamilyTree();
        ft.addHuman(maternalGrandfather);
        ft.addHuman(maternalGrandmother);
        ft.addHuman(paternalGrandfather);
        ft.addHuman(paternalGrandmother);
        ft.addHuman(father);
        ft.addHuman(mother);
        ft.addHuman(child1);
        ft.addHuman(child2);
        ft.addHuman(child3);

        System.out.println(ft.findHuman("Ivan", "Ivanov", "Petrovich"));
        System.out.println(ft.getDescendants(ft.findHuman("Ivan", "Ivanov", "Petrovich")));
        System.out.println(ft.getAncestors(ft.findHuman("Ivan", "Ivanov", "Petrovich")));
        System.out.println(ft.getFamily_tree());
        return ft;

    }
    public static void main(String[] args) throws IOException {
        FileHandier fh = new FileHandier();
        FamilyTree ft = fh.Input("src/out.out");
        System.out.println(ft);
    }
}
