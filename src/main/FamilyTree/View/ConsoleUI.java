package FamilyTree.View;

import FamilyTree.Presentor.Presenter;
import FamilyTree.Model.ItemTree.Gender;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private PaternityMenu paternityMenu;
    private MarriageMenu marriageMenu;


    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.work = true;
        this.menu = new MainMenu(this);
        this.paternityMenu = new PaternityMenu(this);
        this.marriageMenu = new MarriageMenu(this);
    }

    /**
     * @throws IOException
     */
    @Override
    public void start() throws IOException {
        int intChoice = 0;
        System.out.println("Добро пожаловать в фамильное дерево\n");
        while (work) {
            System.out.println(menu.printMenu());
            System.out.println("выберите пункт меню:");
            String choice = scanner.nextLine();
            if (choice.matches("[0-9]+")) {
                intChoice = Integer.parseInt(choice);
                if ((intChoice <= menu.getSize()) && (intChoice > 0)) {
                    menu.execute(intChoice);
                } else {
                    System.out.println("Пункта меню с таким номером нет. Попробуйте еще раз");
                }
            } else {
                System.out.println("Необходимо ввести номер пункта меню. Попробуйте еще раз");
            }
        }
    }

    //
    @Override
    public void printResponse(String response) {
        System.out.println(response);
    }

    /**
     * Метод инициализирует дерево.
     * Для его инициализации необходимо указать персона, относительно которого будет строиться дерево
     * Все последующие персоны будут добавляться в дерево через становление родственной связи отностительно уже
     * добавленных в дерево персонов
     */
    public void beginTree() {
        System.out.println("Для начала формироввания дерева, вам необходимо указать даннае человека, " +
                "для которого будете собирать дерево");
        Map<String, Object> person = getDataPerson();
        presenter.beginTree((String) person.get("fName"), (String) person.get("lName"),
                (Gender) person.get("gender"), (LocalDate) person.get("dataB"));
    }

    /**
     * метод установления связи родитель-ребенок
     */
    public void establishPaternity() throws IOException {
        int intChoice = 0;
        boolean flag = true;
        while (flag) {
            System.out.println(paternityMenu.printMenu());
            System.out.println("Выберете вариант добавления:\n");
            String choice = scanner.nextLine();
            if (choice.matches("[0-9]+")) {
                intChoice = Integer.parseInt(choice);
                if ((intChoice <= paternityMenu.getSize()) && (intChoice > 0)) {
                    paternityMenu.execute(intChoice);
                    flag = false;
                } else {
                    System.out.println("Пункта меню с таким номером нет. Попробуйте еще раз");
                }
            } else {
                System.out.println("Необходимо ввести номер пункта меню. Попробуйте еще раз");
            }
        }
    }

    public void establishMarriage() throws IOException {
        int intChoice = 0;
        boolean flag = true;
        while (flag) {
            System.out.println(marriageMenu.printMenu());
            System.out.println("Выберете вариант добавления:\n");
            String choice = scanner.nextLine();
            if (choice.matches("[0-9]+")) {
                intChoice = Integer.parseInt(choice);
                if ((intChoice <= marriageMenu.getSize()) && (intChoice > 0)) {
                    marriageMenu.execute(intChoice);
                    flag = false;
                } else {
                    System.out.println("Пункта меню с таким номером нет. Попробуйте еще раз");
                }
            } else {
                System.out.println("Необходимо ввести номер пункта меню. Попробуйте еще раз");
            }
        }
    }

    /**
     * Метод запрашивает данные персона и возвращает их в HashMap для дальнейшего использования
     *
     * @return
     */
    private Map<String, Object> getDataPerson() {
        HashMap<String, Object> person = new HashMap<>();
        System.out.println("введите имя:");
        person.put("lName", scanner.nextLine());
        System.out.println("введите фамилию:");
        person.put("fName", scanner.nextLine());
        boolean flag = true;
        while (flag) {
            System.out.println("Укажите пол (m/f):");
            String temp = scanner.nextLine();
            if (temp.equals("m")) {
                person.put("gender", Gender.MAN);
                flag = false;
            } else if (temp.equals("f")) {
                person.put("gender", Gender.WOMAN);
                flag = false;
            }
        }
        flag = true;

        while (flag) {
            System.out.println("введите дату рождения(дд-мм-гггг):");
            String temp = scanner.nextLine();

            if (temp.matches("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)")) {
                String[] tempDate = temp.split("-");
                LocalDate dataB = LocalDate.of(Integer.parseInt(tempDate[2]), Integer.parseInt(tempDate[1]), Integer.parseInt(tempDate[0]));
                person.put("dataB", dataB);
                flag = false;
            }
        }
        return person;
    }

    /**
     * метод запрашивает инн персона
     *
     * @param mess - описание запрашиваемой информации
     * @return число
     */
    private int getInnPerson(String mess) {
        boolean flag = true;
        String choice = "";
        while (flag) {
            System.out.println("Введите " + mess);
            choice = scanner.nextLine();
            if (choice.matches("[0-9]+")) {
                flag = false;
            }
        }
        return Integer.parseInt(choice);
    }

    public void getTree() { //вывести дерево на экран
        presenter.getTree();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void readToFile() throws IOException {
        System.out.println("введите имя файла с архивом данных");
        String namefile = scanner.nextLine();
        presenter.readToFile(namefile);
    }

    public void saveToFile() throws IOException {
        System.out.println("введите имя файла для сохранения");
        String namefile = scanner.nextLine();
        presenter.saveToFile(namefile);
    }

    public void finish() throws IOException {
        System.out.println("Хотите сохранить дерево в файл? (y/n)?");
        boolean flag = true;
        while (flag) {
            String choice = scanner.nextLine();
            if (choice.matches("[y|n|Y|N]")) {
                if ((choice.equals("y")) || (choice.equals("Y"))) {
                    saveToFile();
                    System.out.println("дерево сохранено");
                } else {
                    System.out.println("данные дерева не сохранены");
                }
                flag = false;
            }
        }
        System.out.println("Работа закончена. До свидание");
        work = false;
    }

    public void paternityForINN() {
        int innParent = getInnPerson("ИНН родителя");
        int innChildren = getInnPerson("ИНН ребенка");
        presenter.establishPaternity(innParent, innChildren);
    }

    public void paternityNewParent() {
        int innChildren = getInnPerson("ИНН ребенка");
        System.out.println("Введите данные родителя:");
        Map<String, Object> parent = getDataPerson();
        presenter.establishPaternity((String) parent.get("fName"), (String) parent.get("lName"),
                (Gender) parent.get("gender"), (LocalDate) parent.get("dataB"), innChildren);
    }

    public void paternityNewChildren() {
        int innParent = getInnPerson("ИНН родителя");
        System.out.println("Введите данные ребенка:");
        Map<String, Object> children = getDataPerson();
        presenter.establishPaternity(innParent, (String) children.get("fName"), (String) children.get("lName"),
                (Gender) children.get("gender"), (LocalDate) children.get("dataB"));
    }

    public void marriageForINN() {
        int innFirstPartner = getInnPerson("ИНН первого партнера");
        int innSecondPartner = getInnPerson("ИНН второго партнера");
        presenter.establishMarriage(innFirstPartner, innSecondPartner);

    }

    public void marriageNewPartner() {
        int innFirstPartner = getInnPerson("ИНН парнера");
        System.out.println("Введите данные второго партнера:");
        Map<String, Object> partner = getDataPerson();
        presenter.establishMarriage(innFirstPartner, (String) partner.get("fName"), (String) partner.get("lName"),
                (Gender) partner.get("gender"), (LocalDate) partner.get("dataB"));
    }
}
