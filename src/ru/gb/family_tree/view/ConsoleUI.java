package ru.gb.family_tree.view;
import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.presenter.Presenter;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;


    public ConsoleUI(Presenter presenter) {
        this.presenter = presenter;
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);

    }


    @Override
    public void start() {
        System.out.println("Привествую!");
        while (work){
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            //метод проверки данных на валидность
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }
    }

    public void addHuman() {
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Укажите пол (мужской/женский): ");
        String genderInput = scanner.nextLine().toLowerCase();
        Gender gender = Gender.valueOf(genderInput.toLowerCase());
        System.out.println("Введите дату рождения (ГГГГ-ММ-ДД): ");
        String birthDateInput = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateInput);

        presenter.addHuman(lastName, name, genderInput, birthDateInput);
        saveFamilyTree();
    }

    public void findHumanByName() {
        System.out.println("Введите имя человека для поиска: ");
        String nameHuman = scanner.nextLine();
        presenter.findHumanByName(nameHuman);
    }

    public void findHumanById() {
        System.out.println("Введите ID человека для поиска: ");
        long id = Long.parseLong(scanner.nextLine());
        presenter.findHumanById(id);
    }

    public void getFamilyTree() {
        presenter.getFamilyTree();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
        getFamilyTree();
    }

    public void sortByName() {
        presenter.sortByName();
        getFamilyTree();
    }

    public void finish() {
        saveFamilyTree();
        System.out.println("До новых встреч!");
        work = false;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    private void saveFamilyTree() {
        presenter.saveFamilyTree();
    }

    private void loadFamilyTree() {
        presenter.loadFamilyTree();
    }


    public void addChildByID() {
        System.out.println("Введите ID родителя: ");
        long parentId = Long.parseLong(scanner.nextLine());
        System.out.println("Введите ID ребенка: ");
        long childId = Long.parseLong(scanner.nextLine());

        presenter.addChildById(parentId, childId);
        saveFamilyTree();
    }

    public void delHuman(){
        System.out.println("Введите ID человека, которого нужно удалить: ");
        long id = Long.parseLong(scanner.nextLine());
        presenter.delHuman(id);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

        loadFamilyTree();
    }
}
