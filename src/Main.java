



import family_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        FamilyTree tree = testTree();
        System.out.println(tree);


    }

    static FamilyTree testTree(){


        Human Pavel = new Human(name:"Павел", Gender.Male, LocalDate.of(year:1973, month:8, dayOfMonth:18));
        Human Sveta = new Human(name:"Света", Gender.Female, LocalDate.of(year:1975, month:8 dayOfMonth:7));
        tree.add(Pavel);
        tree.add(Sveta);
        tree.setWedding(Pavel, Sveta);

        Human Tatyana = new Human(name:"Татьяна", Gender.Female, localDate.of(year:1996, month:4, dayOfmonth:11)),
                Pavel, Sveta);
        Human Igor = new Human(name:"Игорь", Gender.Male, LocalDate.of(year:1992, month:10, dayOfMonth:25)),
                Pavel, Sveta);
        tree.add(Tatyana);
        tree.add(Igor);

        Human grandMother = new Human(name:"Антонида", Gender.Female, LocalDate.of(year:1948, month:9, dayOfMonth:22));
        grandMother.addCild(Pavel);
        tree.add(grandMother);

        return tree;

    }
}
