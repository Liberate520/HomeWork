package ru.gb2.family_tree7.presenter;

import ru.gb2.family_tree7.service.FamilyTreeService;
import ru.gb2.family_tree7.view.ConsoleFamilyTreeView;
import ru.gb2.family_tree7.view.FamilyTreeView;
import ru.gb2.family_tree7.model.human.Human;
import ru.gb2.family_tree7.model.human.Gender;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreePresenter {
    private final FamilyTreeView view;
    private final FamilyTreeService service;

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        this.service = new FamilyTreeService();
    }

    public FamilyTreePresenter(ConsoleFamilyTreeView view) {
    }

    public void run() {
        while (true) {
            view.displayMenu();
            String choice = view.geyInput("Выберите пункт");
            switch (choice) {
                case "1":
                    addFamilyMember();
                    break;
                case "2":
                    view.showFamilyMembers(service.getFamilyMembers());
                    break;
                case "3":
                    chooseFamilyMember();
                    break;
                case "4":
                    return;
                default:
                    view.showMessage("Неверный выбор, попробуйте снова");
            }
        }
    }

    private void addFamilyMember() {
        String name = view.getInput("Введите имя");
        Gender gender = Gender.valueOf(view.getInput("Введите пол (MALE/FEMALE)").toUpperCase());
        LocalDate birthDate = LocalDate.parse(view.getInput("Введите дату рождения (yyyy-MM-dd)"));
        String deathInput = view.getInput("Введите дату смерти (оставьте пустым, если нет)");
        LocalDate deathDate = deathInput.isBlank() ? null : LocalDate.parse(deathInput);

        Human newMember = new Human(name, gender, birthDate, deathDate);
        service.addFamilyMember(newMember);
        view.showMessage("Член семьи успешно добавлен!");
    }

    private void chooseFamilyMember() {
        String name = view.getInput("Введите имя члена семьи");
        LocalDate birthDate = LocalDate.parse(view.getInput("Введите дату рождения (yyyy-MM-dd)"));
        Human member = service.findFamilyMember(name, birthDate);
        if (member != null) {
            view.showMemberDetails(member);
        } else {
            view.showMessage("Член семьи не найден");
        }
    }
}