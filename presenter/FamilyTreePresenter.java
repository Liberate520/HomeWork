package homeWork.presenter;

import homeWork.model.FamilyTree;
import homeWork.model.Human;
import homeWork.view.FamilyTreeView;

public class FamilyTreePresenter {
    private final FamilyTree<Human> model;
    private final FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Human> model, FamilyTreeView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        int choice = 0;
        do {
            view.displayFamilyTree(model.getInfo());
            view.promptUserInput("Выберите действие (1 - добавить нового члена семьи, 2 - завершить программу): ");
            choice = view.getUserChoice();
            switch (choice) {
                case 1:
                    addNewFamilyMember();
                    break;
                case 2:
                    view.displayMessage("Завершение программы.");
                    break;
                default:
                    view.displayMessage("Неверный выбор. Повторите попытку.");
                    break;
            }
        } while (choice != 2);
        view.closeScanner();
    }

    public void addNewFamilyMember() {
        view.displayMessage("Функция добавления нового члена семьи еще не реализована.");
    }
}
