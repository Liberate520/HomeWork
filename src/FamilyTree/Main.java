package FamilyTree;

import FamilyTree.presenter.Presenter;
import FamilyTree.view.ConsoleUI;
import FamilyTree.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Presenter presenter = new Presenter(null);
        View view = new ConsoleUI(presenter);
        presenter.setView(view);

        // Загружаем семейное дерево
        presenter.loadFamilyTree();

        // Если дерево пустое, инициализируем начальные данные
        if (presenter.isFamilyTreeEmpty()) {
            presenter.addInitialFamilyMembers();
            // Сохраняем обновленное дерево
            presenter.saveFamilyTree();
        }

        // Запускаем пользовательский интерфейс
        view.start();

        // Сохраняем дерево при завершении работы программы
        presenter.saveFamilyTree();
    }
}