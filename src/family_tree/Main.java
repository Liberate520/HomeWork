package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.hunan.Gender;
import family_tree.hunan.Human;

import java.time.LocalDate;
public class Main{
public static void main(String[] args) {
    FamilyTree tree = testTree();
    System.out.println(tree);
}

static FamilyTree testTree() {
    FamilyTree tree = new FamilyTree();
    Human lyuba = new Human("Любоввь", Gender.Female, LocalDate.of(1952, 10, 13));
    Human vladimir = new Human("Владимир", Gender.Male, LocalDate.of(1950, 01, 31));
    tree.add(lyuba);
    tree.add(vladimir);
    tree.setWedding(lyuba, vladimir);
    Human nelli = new Human("Нелли", Gender.Female, LocalDate.of(1973, 10, 13), lyuba, vladimir);
    tree.add(nelli);

    return tree;
}
}