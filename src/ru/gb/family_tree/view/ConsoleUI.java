package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.presenter.Presenter;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        clearConsole();
        userHourHi();
        String choice1, choice2;
        do {
            menuMain();
            choice1 = scanner.nextLine();
            switch (choice1) {
                case "1":
                    clearConsole();
                    menu1();
                    choice2 = scanner.nextLine();
                    menu1case(choice2);
                    break;
                case "2":
                    clearConsole();
                    showTreeMenu();
                    choice2 = scanner.nextLine();
                    handleTreeMenuChoice(choice2);
                    break;
                case "3":
                    clearConsole();
                    userHourBye();
                    break;
                default:
                    System.out.println("Некорректный выбор, попробуйте ещё раз!");
            }
        } while (!"3".equals(choice1));
    }

    private void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    private void userHourHi() {
        int hour = LocalDateTime.now().getHour();
        if (hour >= 5 && hour < 12) {
            System.out.println("Доброе утро!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Добрый день!");
        } else if (hour >= 18 && hour <= 23) {
            System.out.println("Добрый вечер!");
        } else {
            System.out.println("Добрая ночь!");
        }
    }

    private void userHourBye() {
        int hour = LocalDateTime.now().getHour();
        if (hour >= 5 && hour < 12) {
            System.out.println("Доброго утра!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Доброго дня!");
        } else if (hour >= 18 && hour <= 23) {
            System.out.println("Доброго вечера!");
        } else {
            System.out.println("Доброй ночи!");
        }
    }

    private void menuMain() {
        System.out.println("Выберите раздел:");
        System.out.println("1. Редактирование элементов");
        System.out.println("2. Редактирование дерева");
        System.out.println("3. Завершить работу");
    }

    private void menu1() {
        System.out.println("Выберите команду:");
        System.out.println("1. Создать шаблон");
        System.out.println("2. Удалить шаблон");
        System.out.println("3. Дополнить шаблон");
        System.out.println("4. Посмотреть список шаблонов");
    }

    private void menu1case(String choice) {
        switch (choice){
            case "1":
                clearConsole();
                System.out.println("Введите имя:");
                String firstName = scanner.nextLine();
                clearConsole();
                System.out.println("Введите фамилию:");
                String lastName = scanner.nextLine();
                clearConsole();
                LocalDate dob = askDob();
                clearConsole();
                LocalDate dod = askDod();
                clearConsole();
                Gender gender = Gender.valueOf(askGender());
                clearConsole();
                Human father = null;
                Human mother = null;
                ArrayList<String> childs = null;
                if (askParents() == "Да"){
                    father = askFather();
                    mother = askMother();
                }
                if (askChilds() == "Да"){
                    childs = childsForHum();
                }

                Human anyHuman = presenter.createHuman(firstName, lastName, dob, dod, gender, father, mother);
                presenter.addHumansInEveryHuman(anyHuman);
                if (childs.get(0) != null){
                    for (String ch: childs) {
                        anyHuman.addChilds(presenter.findHuman(ch));
                    }
                }
                System.out.println("Шаблон" + " №" + firstName + "Успешно создан!");
            case "2":
            case "3":
            case "4":
        }
    }

    public String askParents(){
        System.out.println("Известен ли сейчас родители? (Да/Нет)\nБудет произведён поиск среди шаблонов. Родителей также можно будет добавить позднее:");
        String answerYorN = scanner.nextLine();
        if (!answerYorN.equals("Да") && !answerYorN.equals("Нет")) {
            System.out.println("Неверный ввод. Пожалуйста, введите 'Да', если родители известены или 'Нет', если это не так.");
            return askParents();
        }
        else {
            return answerYorN;
        }
    }
    public String askChilds(){
        System.out.println("Известы ли сейчас дети? (Да/Нет)\nБудет произведён поиск среди шаблонов. Родителей также можно будет добавить позднее:");
        String answerYorN = scanner.nextLine();
        if (!answerYorN.equals("Да") && !answerYorN.equals("Нет")) {
            System.out.println("Неверный ввод. Пожалуйста, введите 'Да', если родители известены или 'Нет', если это не так.");
            return askChilds();
        }
        else {
            return answerYorN;
        }
    }

    public ArrayList<String> childsForHum() {
        ArrayList<String> children = new ArrayList<>();
        System.out.println("Введите имена детей (введите 'стоп' для завершения):");
        String childName;
        while (!(childName = scanner.nextLine().trim()).equalsIgnoreCase("стоп")) {
            if (presenter.findHuman(childName) != null) {
                children.add(childName);
            }
        }
        if (children.isEmpty()){
            System.out.println("Детей не найдено среди шаблонов");
            return children;

        }
        return children;
    }

    public Human askFather() {
        clearConsole();
        System.out.println("Введите имя отца:");
        String fatherName = scanner.nextLine();
        Human father = presenter.findHuman(fatherName);
        String a;
        if (father != null) {
            a = "Отец найден среди шаблонов и добавлен в качестве родителя для текущего шаблона.";
            return father;
        } else {
            a = "Отец не найден";
            return null;
        }
    }


    public Human askMother() {
        clearConsole();
        System.out.println("Введите имя матери:");
        String fatherName = scanner.nextLine();
        Human father = presenter.findHuman(fatherName);
        String a;
        if (father != null){
            a = "Матерь найдена среди шаблонов и добавлен в качестве родителя для текущего шаблона.";
            return father;
        }
        else {
            a = "Матерь не найден";
            return null;
        }
    }

        public String askGender () {
            System.out.println("Введите ваш пол (Male/Female):");
            String genderIn = scanner.nextLine();
            if (!genderIn.equals("Male") && !genderIn.equals("Female")) {
                System.out.println("Неверный ввод. Пожалуйста, введите 'Male' для мужского или 'Female' для женского.");
                return askGender();
            }
            return genderIn;
        }
        public LocalDate askDob () {
            System.out.println("Введите дату рождения (формат дд-мм-гггг):");
            String dobInput = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                LocalDate dob = LocalDate.parse(dobInput, formatter);
                return dob;
            } catch (Exception e) {
                System.out.println("Неверный формат даты. Попробуйте еще раз.");
                return askDob();
            }
        }

        public LocalDate askDod () {
            System.out.println("Введите дату смерти (формат дд-мм-гггг):");
            String dobInput = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                LocalDate dod = LocalDate.parse(dobInput, formatter);
                return dod;
            } catch (Exception e) {
                System.out.println("Неверный формат даты. Попробуйте еще раз.");
                return askDob();
            }
        }

        private void showTreeMenu () {
            System.out.println("Выберите команду:");
            System.out.println("1. Добавить шаблон в дерево");
            System.out.println("2. Удалить шаблон из дерева");
            System.out.println("3. Выбрать метод сортировки");
            System.out.println("4. Посмотреть текущее дерево");
        }

        private void handleTreeMenuChoice (String choice){
            // Здесь должна быть логика обработки выбора пользователя
        }

        @Override
        public void printAnswer (String answer){
            System.out.println(answer);
        }
}
