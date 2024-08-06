import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        FileHandler<Human> fileHandler = new FileHandler<>();
        FamilyTreeView<Human> view = new ConsoleFamilyTreeView<>();
        FamilyTreePresenter presenter = new FamilyTreePresenterImpl<>(view, familyTree, fileHandler);

        Human john = new Human("1", "John", "Doe", 60, Human.Gender.Male, LocalDate.of(1964, 1, 1));
        Human jane = new Human("2", "Jane", "Doe", 58, Human.Gender.Female, LocalDate.of(1966, 2, 1));
        Human mary = new Human("3", "Mary", "Smith", 30, Human.Gender.Female, LocalDate.of(1994, 3, 1));
        Human tom = new Human("4", "Tom", "Smith", 32, Human.Gender.Male, LocalDate.of(1992, 4, 1));

        john.addChild(mary);
        jane.addChild(mary);
        mary.setFather(john);
        mary.setMother(jane);

        familyTree.addMember(john);
        familyTree.addMember(jane);
        familyTree.addMember(mary);
        familyTree.addMember(tom);

        while (true) {
            presenter.showMenu();
            int choice = ((ConsoleFamilyTreeView<Human>) view).getInput();
            switch (choice) {
                case 1 -> {
                    System.out.print("Введите ID: ");
                    String id = ((ConsoleFamilyTreeView<Human>) view).getStringInput();
                    presenter.onSearchById(id);
                }
                case 2 -> {
                    System.out.print("Введите имя: ");
                    String name = ((ConsoleFamilyTreeView<Human>) view).getStringInput();
                    presenter.onSearchByName(name);
                }
                case 3 -> {
                    System.out.print("Введите фамилию: ");
                    String surname = ((ConsoleFamilyTreeView<Human>) view).getStringInput();
                    presenter.onSearchBySurname(surname);
                }
                case 4 -> {
                    System.out.print("Введите ID человека для получения информации о его детях: ");
                    String id = ((ConsoleFamilyTreeView<Human>) view).getStringInput();
                    presenter.onShowChildren(id);
                }
                case 5 -> {
                    System.out.print("Введите имя файла для сохранения: ");
                    String filename = ((ConsoleFamilyTreeView<Human>) view).getStringInput();
                    presenter.onSaveTree(filename);
                }
                case 6 -> {
                    System.out.print("Введите имя файла для загрузки: ");
                    String filename = ((ConsoleFamilyTreeView<Human>) view).getStringInput();
                    presenter.onLoadTree(filename);
                }
                case 7 -> presenter.onSortByAge();
                case 8 -> presenter.onSortByGender();
                case 9 -> {
                    presenter.onExit();
                    return;
                }
                default -> view.displayMessage("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}