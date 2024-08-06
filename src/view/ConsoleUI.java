package view;

import model.human.Gender;
import presenter.Presenter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ConsoleUI implements View {

    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private MainMenu menu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void star() {
        greetings(); // приветствие
        while (work) {
            /*
            Пункты меню:
            1. Добавить человека --> (+)
            2. Отсортировать древо по имени --> (+)
            3. Отсортировать древо по возрасту --> (+)
            4. Вывести список древа --> (+)
            5. Завершить работу --> (+)
            6*. Добавить ребенка --> доделать
            7*. Добавить супруга --> доделать
            8*. Внести дату смерти --> доделать
            9*. Сохранить древо в файл --> доделать
            10*. Вывести сохраненный файл --> доделать
            10*. Поиск сведений о родителях (отдельно по матери и отцу) --> доделать
            10*. Поиск сведений о детях --> доделать

             */

            System.out.println(menu.menuItems()); // отображение пунктов меню
            System.out.print("Выберите необходимый пункт меню: ");
            String choiceStr = scanner.nextLine();  // запрос пункта меню
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);

        }
    }


    public void finish() {
        work = false;
        scanner.close();
        parting();
    }

    public void addHuman() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Укажите пол (мужчина или женщина): ");
        Gender gender = inputGender();


        System.out.print("Введите дату рождения (формат ввода через пробел - ГГГГ ММ ДД): ");
        String date = scanner.nextLine();
        LocalDate birthDate = LocalDate.of(Integer.parseInt(date.split(" ")[0]),
                Integer.parseInt(date.split(" ")[1]), Integer.parseInt(date.split(" ")[2]));


        presenter.addHuman(name, gender, birthDate);
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }


    public void greetings() {
// Метод для приветствия пользователя
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH");
        int time = parseInt(formatForDateNow.format(dateNow));
        if (time >= 22 && time <= 23 || time >= 0 && time < 4) {
            System.out.println("Доброй ночи, уважаемый гость!");
        } else if (time >= 4 && time < 12) {
            System.out.println("Доброе утро, уважаемый гость!");
        } else if (time >= 12 && time < 18) {
            System.out.println("Добрый день, уважаемый гость!");
        } else {
            System.out.println("Добрый вечер, уважаемый гость!");
        }
        System.out.println("Мы рады приветствовать Вас в нашем приложении.");
    }

    public void parting() {
// Метод прощания с пользователем
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH");
        int time = parseInt(formatForDateNow.format(dateNow));
        if (time >= 22 && time <= 23 || time >= 0 && time < 4) {
            System.out.println("Доброй ночи и до новой встречи!");
        } else {
            System.out.println("Хорошего дня и до новой встречи!");
        }
    }


    public Gender inputGender() {
        while (true) {
            String genderStr = scanner.nextLine().trim();

            if (genderStr.equalsIgnoreCase("мужчина")) {
                Gender gender = Gender.Male;
                return gender;
            } else if (genderStr.equalsIgnoreCase("женщина")) {
                Gender gender = Gender.Female;
                return gender;
            } else {
                System.out.println("Введен неправильный пол, попробуйте заново (мужчина или женщина):");
            }
        }
    }
}
