package FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human root = new Human("Smit", "Adam", Gender.MAN, LocalDate.of(1955, 11, 25));
        root.setParent(new Human("Smit", "Tony", Gender.MAN, LocalDate.of(1935, 1, 20)));
        root.setParent(new Human("Luis", "Sofa", Gender.WOMAN, LocalDate.of(1936, 12, 20)));

        root.addChildren(new Human("Smit", "Lusy", Gender.WOMAN, LocalDate.of(1975, 12, 10)));
        root.addChildren(new Human("Smit", "Rob", Gender.MAN, LocalDate.of(1977, 1, 10)));

        familyTree.addAllKinInTree(root);

        familyTree.getAllFamilyTree().forEach(System.out::println);

        //зарегистрируем смерть
        familyTree.mortRegistration(2, LocalDate.of(1980, 12, 12));

        // после регистрации брака партнер автоматически добавляется в дерево, вместе со своей родней
        Human newKin = new Human("Doe", "John", Gender.MAN, LocalDate.of(1974, 10, 5));

        familyTree.marriageRegistration(newKin, 4);

        System.out.println("\n супруг ");
        System.out.println(familyTree.getHusband(4));

        System.out.println("\n новый список (после изменений)");
        familyTree.getAllFamilyTree().forEach(System.out::println);

        System.out.printf("\n%s. \n----дети: \n", root);
        familyTree.getChildren(1).forEach(System.out::println);

        System.out.printf("\n%s. \n----родители: \n", root);
        familyTree.getParent(1).forEach(System.out::println);
    }
}
