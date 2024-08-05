package familyTree.view;

import familyTree.model.human.Gender;
import familyTree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean flag;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        flag = true;
        menu = new MainMenu(this);
    }


    @Override
    public void start() {
        while (flag) {
            System.out.println(menu.menuInfo());
            String strChoice = scanner.nextLine();
            try {
                int choice = Integer.parseInt(strChoice);
                menu.execute(choice);
            } catch (Exception e) {
                error();
            }
        }
    }

    public void finish() {
        System.out.println("До свидания!");
        flag = false;
    }

    public void getFamilyTree() {
        presenter.getFamilyTree();
    }

    public void sortByID() {
        presenter.sortByID();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void saveTree() {
        presenter.saveFile();
    }

    public void loadTree() {
        presenter.loadFile();
    }

    public void addParent() {
        int idHuman;
        int idParent;
        try {
            idHuman = Integer.parseInt(idHuman());
            idParent = Integer.parseInt(idParent());
            presenter.addParent(idHuman, idParent);
        } catch (Exception e) {
            System.out.println("Ошибка ввода id");
        }

    }

    public void addChild() {
        int idHuman;
        int idChild;
        try {
            idHuman = Integer.parseInt(idHuman());
            idChild = Integer.parseInt(idChild());
            presenter.addChild(idHuman, idChild);
        } catch (Exception e) {
            System.out.println("Ошибка ввода id");
        }

    }

    public void addHuman() {
        System.out.println("Введите Имя (Обязательно)");
        String firstName = scanner.nextLine();
        System.out.println("Введите Фамилию(Обязательно)");
        String lastName = scanner.nextLine();
        System.out.println("Введите Отчество(Обязательно)");
        String patronymic = scanner.nextLine();
        System.out.println("Введите пол (Male или Female) (Обязательно)");
        Gender gender;
        try {
            gender = Gender.valueOf(scanner.nextLine());
        } catch (Exception e) {
            gender = null;
            System.out.println("пол не задан");
        }
        System.out.println("Введите год рождения");
        String yearBirth = scanner.nextLine();
        System.out.println("Введите месяц рождения");
        String monthBirth = scanner.nextLine();
        System.out.println("Введите день рождения");
        String dayBirth = scanner.nextLine();
        System.out.println("Введите год смерти");
        String yearDeath = scanner.nextLine();
        System.out.println("Введите месяц смерти");
        String monthDeath = scanner.nextLine();
        System.out.println("Введите день смерти");
        String dayDeath = scanner.nextLine();
        System.out.println("Введите место рождения");
        String placeBorn = scanner.nextLine();

        LocalDate dataBirth, dataDeath;
        dataBirth = getData(yearBirth, monthBirth, dayBirth);
        dataDeath = getData(yearDeath, monthDeath, dayDeath);
        if (lastName != "" && firstName!= "" && patronymic !="" && gender!=null) {
            presenter.addHuman(lastName, firstName, patronymic, gender, dataBirth,
                    dataDeath, null, null, null, placeBorn);
        }else {
            error();
        }

    }

    public String idHuman() {
        System.out.println("Введите id человека");
        return scanner.nextLine();
    }

    public String idChild() {
        System.out.println("Введите id ребенка");
        return scanner.nextLine();
    }

    public String idParent() {
        System.out.println("Введите id родителя");
        return scanner.nextLine();
    }


    private LocalDate getData(String year, String month, String day) {
        LocalDate date;
        try {
            int iyear = Integer.parseInt(year);
            int imonth = Integer.parseInt(month);
            int iday = Integer.parseInt(day);
            date = LocalDate.of(iyear, imonth, iday);

            return date;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void PrintAnwser(String answer) {
        System.out.println(answer);
    }

    public void error() {
        System.out.println("Ошибка ввода");
    }
}
