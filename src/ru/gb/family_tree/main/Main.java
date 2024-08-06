package ru.gb.family_tree.main;

import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.models.Human;
import ru.gb.family_tree.presenter.FamilyTreePresenter;
import ru.gb.family_tree.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        ConsoleView<Human> view = new ConsoleView<>();
        FamilyTreePresenter<Human> presenter = new FamilyTreePresenter<>(familyTree, view);

        // Создание членов семьи
        Human alice = new Human(1, "Alice", "01-01-1970", "женский");
        Human eugen = new Human(2, "Eugen", "21-08-1965", "мужской");
        Human bob = new Human(3, "Bob", "01-01-2000", "мужской");
        Human charlie = new Human(4, "Charlie", "01-01-2005", "мужской");

        // Добавление членов семьи в дерево
        presenter.addMember(alice);
        presenter.addMember(eugen);
        presenter.addMember(bob);
        presenter.addMember(charlie);

        // Установление супружеской связи
        presenter.setSpouse(1, 2);

        // Установление родительских связей
        presenter.setParent(3, 1); // Alice - мать Bob
        presenter.setParent(3, 2); // Eugen - отец Bob
        presenter.setParent(4, 1); // Alice - мать Charlie
        presenter.setParent(4, 2); // Eugen - отец Charlie

        // Отображение всего дерева
        presenter.showAllMembers();
    }
}
