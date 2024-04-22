import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = newTree();
        System.out.println(tree);
    }

    static FamilyTree newTree(){
        FamilyTree tree = new FamilyTree();
        Human ilya = new Human("Илья", "Шевченко", Gender.Male, LocalDate.of(1984,3,3));
        Human anna = new Human("Анна", "Степанова", Gender.Female, LocalDate.of(1990,9,19));
        tree.add(ilya);
        tree.add(anna);
        Human maria = new Human("Мария", "Шевченко", Gender.Female, LocalDate.of(2012, 9, 17));
        Human varvara = new Human("Варвара", "Шевченко", Gender.Female, LocalDate.of(2019, 10, 27));
        tree.add(maria);
        tree.add(varvara);
        anna.addChild(maria);
        anna.addChild(varvara);
        ilya.addChild(maria);
        ilya.addChild(varvara);
        maria.addParent(anna);
        maria.addParent(ilya);

        return tree;
    }
}
