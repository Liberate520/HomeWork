package View;

import java.time.LocalDate;
import java.util.List;
import Human.Human;
import Human.Gender;
import Presenter.FamilyTreePresenter;
// import Writer.FamilyTreeFileHandler;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    private FamilyTreePresenter presenter;
    private final ConsoleInputHandler inputHandler;

    public ConsoleFamilyTreeView(FamilyTreePresenter presenter, ConsoleInputHandler inputHandler) {
        this.presenter = presenter;
        this.inputHandler = inputHandler;
    }

    @Override
    public void setPresenter(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println("1. Добавить человека");
            System.out.println("2. Показать семейное дерево");
            System.out.println("3. Сортировать по имени");
            System.out.println("4. Сортировать по дате рождения");
            System.out.println("5. Сортировать по возрасту");
            System.out.println("6. Очистить дерево");
            System.out.println("7. Сохранить дерево");
            System.out.println("8. Загрузить дерево");
            System.out.println("9. Выход");

            int choice = inputHandler.getIntInput("Выберите действие: ");
            switch (choice) {
                case 1:
                    addHuman();
                    break;
                case 2:
                    presenter.onShowFamilyTree();
                    break;
                case 3:
                    presenter.onSortByName();
                    break;
                case 4:
                    presenter.onSortByBirthDate();
                    break;
                case 5:
                    presenter.onSortByAge();
                    break;
                case 6:
                    presenter.onClearFamilyTree();
                    break;
                case 7:
                    saveFamilyTree();
                    break;
                case 8:
                    loadFamilyTree();
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    @Override
    public void showFamilyTree(List<Human> familyMembers) {
        for (Human human : familyMembers) {
            System.out.println(human);
        }
    }

    @Override
    public void displayFamilyTree(List<Human> familyMembers) {
        for (Human human : familyMembers) {
            System.out.println(human);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showError(String message) {
        System.err.println("Ошибка: " + message);
    }

    private void addHuman() {
        String name = inputHandler.getStringInput("Введите имя: ");
        LocalDate birthDate = inputHandler.getDateInput("Введите дату рождения (YYYY-MM-DD): ");
        LocalDate deathDate = inputHandler.getDateInput("Введите дату смерти (YYYY-MM-DD) или оставьте пустым: ");
        Gender gender = inputHandler.getGenderInput("Введите пол (MALE/FEMALE): ");

        String fatherName = inputHandler.getStringInput("Введите имя отца (или оставьте пустым): ");
        Human father = fatherName.isEmpty() ? null : presenter.findByName(fatherName);
        
        String motherName = inputHandler.getStringInput("Введите имя матери (или оставьте пустым): ");
        Human mother = motherName.isEmpty() ? null : presenter.findByName(motherName);

        presenter.onAddHuman(name, birthDate, deathDate, gender, father, mother);
    }

    private void saveFamilyTree() {
        String filename = inputHandler.getStringInput("Введите имя файла для сохранения: ");
        presenter.onSave(filename);
    }

    private void loadFamilyTree() {
        String filename = inputHandler.getStringInput("Введите имя файла для загрузки: ");
        presenter.onLoad(filename);
    }
}

