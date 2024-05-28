package src;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String file = "Familytree/homeWork/src/src/tree.txt";
        FamilyTree tree = tree();
     //   FamilyTree tree = load(file);
        System.out.println(tree);

        save(tree, file);
    }

    private static FamilyTree load(String file){
        writable writable = new FileHandler();
        return (FamilyTree) writable.read(file);
    }

    private static void save(FamilyTree tree, String file){
        writable writable = new FileHandler();
        writable.save(tree, file);
    }

    private static FamilyTree tree() {
        FamilyTree tree = new FamilyTree();

        Human maria = new Human("Мария", Gender.Female, LocalDate.of(1995, 1, 1));
        Human sergej = new Human("Сергей", Gender.Male, LocalDate.of(1993, 5, 5));


        tree.add(maria);
        tree.add(sergej);

        Human misha = new Human("Миша", Gender.Male, LocalDate.of(2014, 12, 24));
        misha.addParent(maria);
        misha.addParent(sergej);
        tree.add(misha);

        Human ded = new Human("Дед Валера", Gender.Male,LocalDate.of(1950, 4, 19));
        ded.addChild(maria);
        tree.add(ded);


        return tree;
    }
}