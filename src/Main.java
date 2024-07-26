import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         *Создаем людей
         * */
        Human ivan = new Human("Иван", Gender.Make, LocalDate.of(1990, 1, 1), null, new ArrayList<>(), new ArrayList<>());
        Human luda = new Human("Людмила", Gender.Female, LocalDate.of(1992, 2, 2), null, new ArrayList<>(), new ArrayList<>());
        Human larisa = new Human("Лариса", Gender.Female, LocalDate.of(2010, 3, 3), null, new ArrayList<>(), new ArrayList<>());
        Human petr = new Human("Петр", Gender.Make, LocalDate.of(2012, 4, 4), null, new ArrayList<>(), new ArrayList<>());

        /**
         *Создаем отношения между людьми
         */
        ivan.children.add(luda);
        luda.parents.add(ivan);
        ivan.children.add(larisa);
        larisa.parents.add(ivan);
        luda.children.add(petr);
        petr.parents.add(luda);

        /**
         *Создаем генеалогическое древо
         */
        FamilyTree tree = new FamilyTree(ivan);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя члена семьи:");
        String name = scanner.nextLine();

        Human person = findPersonByName(tree.getRoot(), name);
        if (person != null) {
            System.out.println("Родители:");
            for (Human parent : person.getParents()) {
                System.out.println(parent.name);
            }

            System.out.println("Дети:");
            for (Human child : person.getChildren()) {
                System.out.println(child.name);
            }
        } else {
            System.out.println("Такой человек не найден!");
        }
    }

    private static Human findPersonByName(Human person, String name) {
        if (person.name.equals(name)) {
            return person;
        }

        for (Human child : person.children) {
            Human found = findPersonByName(child, name);
            if (found != null) {
                return found;
            }
        }

        return null;
    }
}
