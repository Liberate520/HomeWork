package family_tree.view;

import family_tree.presentor.Presentor;
import family_tree.view.menu.Menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Presentor presentor;
    private Scanner scanner;
    private boolean flag;
    private Menu menu;

    public ConsoleUI() {
        presentor = new Presentor(this);
        scanner = new Scanner(System.in);
        flag = true;
        menu = new Menu(this);
    }

    @Override
    public void start() {
        while (flag) {
            menu.Start();
        }
    }

    @Override
    public void printAnswer(String str) {
        System.out.println(str);
    }

    public void getFamily() {
        presentor.getFamily();
    }

    public void removeHuman() {
        printAnswer("Введите id человека, которого хотите удалить:");
        String str = scanner.nextLine();
        try {
            presentor.removeHuman(Integer.parseInt(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findHumanByID() {
        printAnswer("Введите id человека:");
        String str = scanner.nextLine();
        try {
            presentor.idFindHuman(Integer.parseInt(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findHumanByName() {
        printAnswer("Введите имя человека:");
        String first_name = scanner.nextLine();
        printAnswer("Введите фамилию человека:");
        String last_name = scanner.nextLine();
        printAnswer("Введите отчество человека:");
        String patronymic = scanner.nextLine();
        presentor.nameFindHuman(first_name, last_name, patronymic);
    }

    public void getAncestors() {
        printAnswer("Введите id человека:");
        String str = scanner.nextLine();
        try {
            presentor.getAncestors(Integer.parseInt(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDescendants() {
        printAnswer("Введите id человека:");
        String str = scanner.nextLine();
        try {
            presentor.getDescendants(Integer.parseInt(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortByBirthday() {
        presentor.sortByDateOfBirthday();
    }

    public void sortByName() {
        presentor.sortByname();
    }

    public void Save() {
        printAnswer("Введите путь к месту сохранения:");
        String str = scanner.nextLine();
        presentor.save(str);
    }

    public void load() {
        printAnswer("Введите путь к дереву:");
        String str = scanner.nextLine();
        presentor.load(str);
    }

    public void exit() {
        flag = false;
    }

    public void addHuman() {
        printAnswer("Введите имя человека:");
        String first_name = scanner.nextLine();
        printAnswer("Введите фамилию человека:");
        String last_name = scanner.nextLine();
        printAnswer("Введите отчество человека:");
        String patronymic = scanner.nextLine();
        boolean flag2 = true;
        LocalDate birthday = null;
        while (flag2) {
            printAnswer("Введите дату рождения в формате год:месяц:день");
            String date = scanner.nextLine();
            String[] arr = date.split(":");
            if (arr.length != 3) {
                printAnswer("Некорректный ввод!");
            }
            try {
                birthday = LocalDate.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                flag2 = false;
            } catch (Exception e) {
                printAnswer("Некорректный ввод!");
            }
        }
        flag2 = true;
        LocalDate datedeath = null;
        while (flag2) {
            printAnswer("Введите дату смерти в формате год:месяц:день или если человек пока не умер введите пустую строку");
            String date = scanner.nextLine();
            if (date.equals("")) {
                datedeath = null;
                flag2 = false;
            } else {
                String[] arr = date.split(":");
                if (arr.length != 3) {
                    printAnswer("Некорректный ввод!");
                }
                try {
                    datedeath = LocalDate.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    flag2 = false;
                } catch (Exception e) {
                    printAnswer("Некорректный ввод!");
                }
            }
        }
        flag2 = true;
        int father;
        int mother;
        while (true) {
            printAnswer("Введите id отца, если нету введите пустую строку:");
            String str = scanner.nextLine();
            if (str.equals("")) {
                father = -1;
                break;
            } else {
                try {
                    father = Integer.parseInt(str);
                    break;
                } catch (Exception e) {
                    printAnswer("Некорректный ввод!");
                }
            }
        }

        while (true) {
            printAnswer("Введите id матери, если нету введите пустую строку:");
            String str = scanner.nextLine();
            if (str.equals("")) {
                mother = -1;
                break;
            } else {
                try {
                    mother = Integer.parseInt(str);
                    break;
                } catch (Exception e) {
                    printAnswer("Некорректный ввод!");
                }
            }
        }
        ArrayList<Integer> children = new ArrayList<>();
        while (true) {
            printAnswer("Введите id ребенка, а если больше детей нет введите q:");
            String str = scanner.nextLine();
            if (str.equals("q")) {
                break;
            } else {
                try {
                    children.add(Integer.parseInt(str));
                } catch (Exception e) {
                    printAnswer("Некорректный ввод!");
                }
            }
        }
        String gender = null;
        while (flag2) {
            printAnswer("Введите гендер MALE если мужчина, FEMALE если женщина:");
            String str = scanner.nextLine().toUpperCase();
            if (str.equals("MALE") || str.equals("FEMALE")) {
                gender = str;
                flag2 = false;
            } else {
                printAnswer("Некорректный ввод!");
            }
        }
        try {
            presentor.addHuman(first_name, last_name, patronymic, datedeath, birthday, father, mother, children, gender);
        }catch (Exception e){ System.out.println(e);}

    }
}