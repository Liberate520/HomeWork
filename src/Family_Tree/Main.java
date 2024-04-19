package Family_Tree;

import Family_Tree.FamilyTree.FamilyTree;
import Family_Tree.Human.Gender;
import Family_Tree.Human.Human;
import Family_Tree.Writer.Writer;

import java.io.IOException;
import java.time.LocalDate;


public class Main {
    public Main() throws IOException {
    }

    public void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = testFamilyTree();
        tree.sortByName();
        System.out.println(tree.getInfo());
        tree.sortByAge();
        System.out.println(tree.getInfo());
    }

    public FamilyTree testFamilyTree() throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        Human Ivan = new Human("Иван", Gender.Male, LocalDate.of(1978, 9, 4));
        Human Oleg = new Human("Олег",Gender.Male,LocalDate.of(1971,7,5));
        Human Anton = new Human("Антон",Gender.Female,LocalDate.of(1977,1,7));
        tree.add(Ivan);
        tree.add(Oleg);
        tree.add(Anton);
        Writer human = new Writer();
        human.save(Ivan);
        human.save(Oleg);
        human.save(Anton);
        human.read(Ivan);
        human.read(Oleg);
        human.read(Anton);
        return tree;
    }
}
