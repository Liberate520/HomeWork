import java.time.LocalDate;

public class main {
    public main(String[] args) {
        FamilyTree tree = new FamilyTree();
        System.out.println(tree);
        Human egor = new Human("egor", Gender.Male, LocalDate.of(1980, 6, 15));
        Human michail = new Human("michail;", Gender.Male, LocalDate.of(1973, 8, 13));
        Human maria = new Human("maria", Gender.Female, LocalDate.of(1994, 7, 15));
        Human svetlana = new Human("svetlana", Gender.Female, LocalDate.of(2000, 10, 01));

        tree.addToParents(egor);
        tree.addToParents(michail);
        tree.addToChildren(maria);
        tree.addToChildren(svetlana);

    }

}


