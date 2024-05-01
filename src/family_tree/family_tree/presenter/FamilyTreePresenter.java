package family_tree.family_tree.presenter;

import family_tree.family_tree.service.FamilyTreeService;
import family_tree.family_tree.view.FamilyTreeView;
import family_tree.human.Gender;

import java.time.LocalDate;

public class FamilyTreePresenter {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                view.displayFamilyMembers(service.getFamilyMembers());
                break;
            case 2:
                addNewFamilyMember();
                break;
            case 3:
                service.sortFamilyMembersByName();
                view.displaySortedFamilyMembers(service.getFamilyMembers());
                break;
            case 4:
                service.sortFamilyMembersByBirthDate();
                view.displaySortedFamilyMembers(service.getFamilyMembers());
                break;
            case 5:
                view.closeScanner();
                view.displayMessage("Программа завершена.");
                break;
            default:
                view.displayErrorMessage("Некорректный выбор. Пожалуйста, выберите действие из списка.");
        }
    }

    private void addNewFamilyMember() {
        String name = view.promptForName();
        LocalDate dob = view.promptForDateOfBirth();
        Gender gender = view.promptForGender();
        service.addNewFamilyMember(name, dob, gender);
        view.displayMessage("Новый член семьи успешно добавлен.");
    }
}
