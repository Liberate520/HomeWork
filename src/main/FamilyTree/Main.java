package FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //создам человека с родителями и 2мя детьми
        Human root = Human.create("Smit", "Adam", Gender.MAN, LocalDate.of(1955, 11, 25));
        root.setParent(Human.create("Smit", "Tony", Gender.MAN, LocalDate.of(1935, 1, 20)));
        root.setParent(Human.create("Luis", "Sofa", Gender.WOMAN, LocalDate.of(1936, 12, 20)));

        root.addChildren(Human.create("Smit", "Lusy", Gender.WOMAN, LocalDate.of(1975, 12, 10)));
        root.addChildren(Human.create("Smit", "Rob", Gender.MAN, LocalDate.of(1977, 1, 10)));

        //  создадим фамильное дерево для человека
        FamilyTree familyTree = new FamilyTree(root);

        familyTree.getAllFamilyTree().forEach(System.out::println);

        //зарегистрируем смерть
        familyTree.mortRegistration(2, LocalDate.of(1980, 12, 12));

        //добавим родственников в дерево
        //добавим супруга:
        Human newKin = Human.create("Doe", "John", Gender.MAN, LocalDate.of(1974, 10, 5));
        familyTree.addHusband(4, newKin);

        System.out.printf("\n супруг %s: \n", familyTree.getInfo(4));
        System.out.println(familyTree.getHusband(4));

        //добавим ребенка
        familyTree.addChildren(4, Human.create("Doe", "Ann", Gender.WOMAN, LocalDate.of(1990, 1, 1)));
        // установим ребенку воторого родителя
        familyTree.addParent(7, 6);
        System.out.printf("\n----родители (%s): \n", familyTree.getInfo(7));
        familyTree.getParent(7).forEach(System.out::println);


        System.out.println("\n новый список (после изменений)");
        familyTree.getAllFamilyTree().forEach(System.out::println);

        System.out.printf("\n----дети (%s): \n", root);
        familyTree.getChildren(1).forEach(System.out::println);

        System.out.printf("\n----родители (%s): \n", root);
        familyTree.getParent(1).forEach(System.out::println);
    }
}
