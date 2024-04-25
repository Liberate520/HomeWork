package family_tree.family_tree.presenter;

import family_tree.family_tree.service.FamilyTreeService;
import family_tree.family_tree.view.FamilyTreeView;
import family_tree.human.Gender;

import java.time.LocalDate;

public class FamilyTreePresenter {
    private FamilyTreeService service; // Заменил FamilyTreeModel на FamilyTreeService
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeView view) { // Заменил FamilyTreeModel на FamilyTreeService в конструкторе
        this.service = service;
        this.view = view;
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                displayFamilyMembers();
                break;
            case 2:
                addNewFamilyMember();
                break;
            case 3:
                service.sortFamilyMembersByName(); // Заменил model на service
                view.displaySortedFamilyMembers(service.getFamilyMembers()); // Заменил model на service
                break;
            case 4:
                service.sortFamilyMembersByBirthDate(); // Заменил model на service
                view.displaySortedFamilyMembers(service.getFamilyMembers()); // Заменил model на service
                break;
            case 5:
                view.closeScanner();
                System.out.println("Программа завершена.");
                break;
            default:
                view.displayErrorMessage("Некорректный выбор. Пожалуйста, выберите действие из списка.");
        }
    }

    private void displayFamilyMembers() {
        view.displayFamilyMembers(service.getFamilyMembers()); // Заменил model на service
    }

    private void addNewFamilyMember() {
        String name = view.promptForName();
        LocalDate dob = view.promptForDateOfBirth();
        Gender gender = view.promptForGender();
        service.addNewFamilyMember(name, dob, gender); // Заменил model на service
        view.displayMessage("Новый член семьи успешно добавлен.");
    }

    
    // private void sortByName() {
    //     service.sortFamilyMembersByName();
    //     view.displaySortedFamilyMembers(service.getFamilyMembers());
    // }

    // private void sortByBirthDate() {
    //     service.sortFamilyMembersByBirthDate();
    //     view.displaySortedFamilyMembers(service.getFamilyMembers());
    // }

    // Другие методы для обработки действий пользователя
}
