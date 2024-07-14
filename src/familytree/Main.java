package familytree;

import familytree.model.FamilyTree;
import familytree.model.Gender;
import familytree.model.Human;
import familytree.presenter.FamilyTreePresenter;
import familytree.view.FamilyTreeConsoleView;
import familytree.view.FamilyTreeView;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = createFamilyTree();
        FamilyTreeView view = new FamilyTreeConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, view);

        // Сохранение дерева в файл
        presenter.saveTree("src/familytree/writer/tree.txt");

        // Чтение дерева из файла
        presenter.loadTree("src/familytree/writer/tree.txt");

        // Отображение деталей человека
        presenter.displayHumanDetails("Иван");

        // Сортировка и вывод по имени
        presenter.sortAndDisplayByName();

        // Сортировка и вывод по дате рождения
        presenter.sortAndDisplayByBirthDate();
    }

    private static FamilyTree createFamilyTree() {
        FamilyTree familyTree = new FamilyTree();

        Human ivan = new Human("Иван", LocalDate.of(1974, 6, 1), Gender.MALE);
        Human maria = new Human("Мария", LocalDate.of(1979, 8, 15), Gender.FEMALE);
        Human mikhail = new Human("Михаил", LocalDate.of(2004, 11, 30), Gender.MALE);
        Human anna = new Human("Анна", LocalDate.of(2006, 5, 25), Gender.FEMALE);

        // Устанавливаем дату смерти (для демонстрации)
        maria.setDeathDate(LocalDate.of(2023, 4, 10));

        ivan.addChild(mikhail);
        ivan.addChild(anna);

        familyTree.addHuman(ivan);
        familyTree.addHuman(maria);
        familyTree.addHuman(mikhail);
        familyTree.addHuman(anna);

        return familyTree;
    }
}