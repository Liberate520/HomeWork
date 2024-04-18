package family_tree.family_tree.presenter;

import family_tree.family_tree.model.FamilyTreeModel;
import family_tree.family_tree.view.FamilyTreeView;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeModel model;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeModel model, FamilyTreeView view) {
        this.model = model;
        this.view = view;
    }

    public void startApplication() {
        int choice = 0;
        while (choice != 5) {
            view.displayMenu();
            choice = view.getUserChoice();
            switch (choice) {
                case 1:
                    displayFamilyMembers();
                    break;
                case 2:
                    addNewFamilyMember();
                    break;
                case 3:
                    sortByName();
                    break;
                case 4:
                    sortByBirthDate();
                    break;
                case 5:
                    view.closeScanner();
                    System.out.println("Программа завершена.");
                    break;
                default:
                    view.displayErrorMessage("Некорректный выбор. Пожалуйста, выберите действие из списка.");
            }
        }
    }

    private void displayFamilyMembers() {
        List<Human> familyMembers = model.getFamilyMembers();
        view.displayFamilyMembers(familyMembers);
    }

    private void addNewFamilyMember() {
        String name = view.promptForName();
        LocalDate dob = view.promptForDateOfBirth();
        Gender gender = view.promptForGender();
        Human newMember = new Human(name, dob, gender);
        model.addFamilyMember(newMember);
        view.displayMessage("Новый член семьи успешно добавлен.");
    }

    private void sortByName() {
        model.sortFamilyMembersByName();
        view.displaySortedFamilyMembers(model.getFamilyMembers());
    }

    private void sortByBirthDate() {
        model.sortFamilyMembersByBirthDate();
        view.displaySortedFamilyMembers(model.getFamilyMembers());
    }

    // Другие методы для обработки действий пользователя
}
