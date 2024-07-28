import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);
        }
        private static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();
        Man ann = new Man("Анна", Gender.Female, LocalDate.of(1993, 1,19));
        Man den = new Man("Денис", Gender.Male, LocalDate.of(1990, 2,5));
        tree.addToFamilyTree(ann);
        tree.addToFamilyTree(den);
        tree.setWedding(ann, den);
        Man masha = new Man("Маша", Gender.Female, LocalDate.of(2015, 3,19), ann, den);
        Man sveta = new Man("Света", Gender.Female, LocalDate.of(2015, 3,19), ann, den);

        tree.addToFamilyTree(masha);
        tree.addToFamilyTree(sveta);

        Man grandma = new Man("Маша", Gender.Female, LocalDate.of(1965, 5,18));
        grandma.addChild(den);

        tree.addToFamilyTree(grandma);

        tree.addToFamilyTree(sveta);

        System.out.println(den.getId());
        System.out.println(ann.getChildrens());
        System.out.println(ann.getName());
        System.out.println(den.getParents());
        return tree;

        }
    }