package Family_Tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        FamilyTree tree = testFamilyTree();
        System.out.print(tree);
    }
    static FamilyTree testFamilyTree() {
        FamilyTree tree = new FamilyTree();

        Human Ivan = new Human("Василий", Gender.Male, LocalDate.of(1978, 9, 4));
        tree.add(Ivan);
        return tree;
    }
}
