import familytree.FamilyTree;
import person.Person;
import presenter.Presenter;
import view.ConsoleTreeView;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        ConsoleTreeView view = new ConsoleTreeView();
        Presenter presenter = new Presenter(familyTree, view);

        // Пример взаимодействия с пользователем через консоль
        presenter.displayAllPersons();

        // Добавление нового человека
        presenter.addPerson("John", LocalDate.of(1980, 1, 1), null, "male");

        // Поиск человека
        presenter.findPerson("John");

        // Сортировка и вывод всех людей
        presenter.sortByName();
        presenter.displayAllPersons();
    }
}
