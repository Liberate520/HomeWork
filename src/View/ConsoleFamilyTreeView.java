package View;

import java.time.LocalDate;
import java.util.List;
import Human.Human;
import Human.Gender;
import Presenter.FamilyTreePresenter;
import Writer.FamilyTreeFileHandler;

public class ConsoleFamilyTreeView implements FamilyTreeView, Displayable, FamilyTreeViewer {
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
            System.out.println("2. Показать дерево семьи");
            System.out.println("3. Отсортировать по имени");
            System.out.println("4. Отсортировать по дате рождения");
            System.out.println("5. Отсортировать по возрасту");
            System.out.println("6. Сохранить в файл");
            System.out.println("7. Выгрузить из файла");
            System.out.println("8. Очистить дерево");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");
            int choice = Integer.parseInt(inputHandler.getInput("Выберите опцию:"));

            switch (choice) {
                case 1 -> addHuman();
                case 2 -> presenter.onShowFamilyTree();
                case 3 -> presenter.onSortByName();
                case 4 -> presenter.onSortByBirthDate();
                case 5 -> presenter.onSortByAge();
                case 6 -> saveToFile();
                case 7 -> loadFromFile();
                case 8 -> presenter.onClearFamilyTree();
                case 0 -> running = false;
                default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private void addHuman() {
        String name = inputHandler.getInput("Введите имя:");
        LocalDate birthDate = LocalDate.parse(inputHandler.getInput("Введите дату рождения (YYYY-MM-DD):"));
        String deathDateInput = inputHandler.getInput("Введите дату смерти (если есть) (YYYY-MM-DD):");
        LocalDate deathDate = deathDateInput.isEmpty() ? null : LocalDate.parse(deathDateInput);
        Gender gender = Gender.valueOf(inputHandler.getInput("Введите пол (Male/Female):"));
        Human father = presenter.findByName(inputHandler.getInput("Введите имя отца (если есть):"));
        Human mother = presenter.findByName(inputHandler.getInput("Введите имя матери (если есть):"));

        presenter.onAddHuman(name, birthDate, deathDate, gender, father, mother);
    }

    private void saveToFile() {
        String filename = inputHandler.getInput("Введите имя файла для сохранения:");
        presenter.onSave(new FamilyTreeFileHandler(), filename);
    }

    private void loadFromFile() {
        String filename = inputHandler.getInput("Введите имя файла для загрузки:");
        presenter.onLoad(new FamilyTreeFileHandler(), filename);
    }

    @Override
    public void showFamilyTree(List<Human> family) {
        for (Human human : family) {
            System.out.println(human);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showError(String message) {
        System.err.println(message);
    }
}

