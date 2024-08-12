import tree.FamilyTree;
import human.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        FamilyTree myTree = buildTree();

        System.out.println(myTree);

    }

    private static FamilyTree buildTree(){
        FamilyTree tree = new FamilyTree();

        Human oleg = new Human("Олег", Gender.MALE, LocalDate.of(2010,11,2));
        Human olia = new Human("Ольга", Gender.FEMALE, LocalDate.of(2013, 3,13));
        Human zhora = new Human("Георгий", Gender.MALE, LocalDate.of(1988,12,4));
        Human lisa = new Human("Елизавета", Gender.FEMALE, LocalDate.of(1990, 4,21) );
        Human potap = new Human("Потап", Gender.MALE, LocalDate.of(1960,02,3),
                LocalDate.of(2013, 4,5));
        Human dusia = new Human("Дуся", Gender.FEMALE, LocalDate.of(1965, 5,12),
                LocalDate.of(2020, 7,23));

        tree.add(oleg);
        tree.add(zhora);
        tree.add(lisa);
        tree.add(olia);
        tree.add(potap);
        potap.addChildren(zhora);
        zhora.addParent(potap);
        zhora.addChildren(oleg);
        zhora.addChildren(olia);
        lisa.addChildren(oleg);
        lisa.addChildren(olia);
        oleg.addParent(zhora);
        oleg.addParent(lisa);
        olia.addParent(zhora);
        olia.addParent(lisa);
        zhora.setSpouse(lisa);
        tree.add(dusia);
        dusia.setSpouse(potap);
        dusia.addChildren(zhora);
        zhora.addParent(dusia);

        return tree;
    }
}