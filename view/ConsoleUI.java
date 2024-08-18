package com.oop.homeWorkOOP.view;

import com.oop.homeWorkOOP.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scan;
    private Presenter presenter;
    private MainMenu menu;
    private boolean flag;

    public ConsoleUI() {
        scan = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
        flag = true;
    }

    @Override
    public void start() {
        while (flag) {
            printMenu();
            menuChoice();
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }


    private void menuChoice() {
        String input = scan.nextLine();
        if (checkForDigit(input)) {
            int numInput = Integer.parseInt(input);
            if (checkCommand(numInput)) {
                menu.execute(numInput);
            }
        }
    }

    private boolean checkCommand(int numInput) {
        if (numInput <= menu.getSize()) {
            return true;
        } else {
            printError();
            return false;
        }
    }

    private void printError() {
        System.out.println("Неверный ввод, повторите попытку!");
    }

    private boolean checkForDigit(String input) {
        if (input.matches("[0-9]+")) {
            return true;
        } else {
            printError();
            return false;
        }
    }

    @Override
    public void printAnswer(String result) {
        System.out.println(result);
    }

    public void GetLineAgeInfo() {
        presenter.getTreeInfo();
    }

    public void sortTreeByName() {
        presenter.sortTreeByName();
    }

    public void sortByBirthDate() {
        presenter.sortTreeByBirthDate();
    }

    public void saveTree() {
        presenter.saveTree();
    }

    public void loadTree() {
        presenter.loadTree();
    }

    public void getHumanByName() {
        System.out.print("Введите имя человека: ");
        String name = scan.nextLine();
        presenter.getHumanByName(name);
    }

    public void exit() {
        System.out.println("Желаете сохранить изменения перед выходом?\nВведите 1 если да или другой символ если нет:  ");
        if ("1".equals(scan.nextLine())) {
            saveTree();
        }
        System.out.println("Всего доброго!");
        flag=false;
    }

    public void addHuman() {
        String name, birthDate, deathDate, gender,father,mother;
        deathDate=null;
        System.out.print("Введите имя: ");
        name = scan.nextLine();
        System.out.print("Введите дату рождения в формате дд-мм-гггг: ");
        do {
            birthDate = scan.nextLine();
        } while (!checkDateString(birthDate));
        System.out.print("Этот человек жив?\nВведите 1 если да или другой символ если нет: ");
        if (!"1".equals(scan.nextLine())) {
            System.out.print("Введите дату смерти в формате дд-мм-гггг:");
            do {
                deathDate = scan.nextLine();
            } while (!checkDateString(deathDate));
        }
        System.out.print("Выберите пол:\nВведите 1 если мужской или другой символ если женский: ");
        gender = scan.nextLine();
        presenter.getTreeInfo();
        System.out.print("Введите номер записи отца, если он есть в древе или 0 если нет: ");
        do {
            father = scan.nextLine();
        } while (!checkForDigit(father));
        presenter.getTreeInfo();
        System.out.print("Введите номер записи матери, если она есть в древе или 0 если нет: ");
        do {
            mother = scan.nextLine();
        } while (!checkForDigit(mother));
        System.out.println("Спасибо, ваш запрос обрабатывается!");
        presenter.addHuman(name, birthDate, deathDate, gender,father,mother);
    }

    private boolean checkDateString(String inputDate) {
        String[] date = inputDate.split("-");
        for (int i = 0; i < date.length; i++) {
            if (!checkForDigit(date[i])) {
                System.out.println("Используйте при вводе только цифры!");
                return false;
            }
            if (i == 2) {
                if (date[i].length() != 4) {
                    System.out.println("Год должен быть 4-х значным!");
                    return false;
                }
            } else {
                if (date[i].length() != 2) {
                    System.out.println("День и месяц должны быть 2-х значными!");
                    return false;
                }
            }
        }
        int[] intDate = new int[3];
        for (int i = 0; i < date.length; i++) {
            intDate[i] = Integer.parseInt(date[i]);
        }
        if (intDate[1] > 12) {
            System.out.println("Номер месяца не может быть больше 12!");
            return false;
        }
        if (intDate[1] < 8) {
            boolean year = (intDate[2] % 4 == 0 && intDate[2] % 100 != 0) || intDate[2] % 400 == 0;
            if (intDate[1] == 2 && year) {
                if (intDate[0] > 29) {
                    System.out.println("Номер дня в феврале високосного года не может быть больше 29!");
                    return false;
                }
            } else if (intDate[1] == 2 && !year) {
                if (intDate[0] > 28) {
                    System.out.println("Номер дня в феврале не может быть больше 28!");
                    return false;
                }
            } else if (intDate[1] % 2 == 0) {
                    if (intDate[0] > 30) {
                        System.out.println("Номер дня в апреле и июне не может быть больше 30!");
                        return false;
                    }
            } else {
                    if (intDate[0] > 31) {
                        System.out.println("Номер дня в январе, марте, мае и июле не может быть больше 31!");
                        return false;
                    }
                }
            } else {
                if (intDate[1] % 2 == 0) {
                    if (intDate[0] > 31) {
                        System.out.println("Номер дня в августе, октябре и декабре не может быть больше 31!");
                        return false;
                    }
                } else {
                    if (intDate[0] > 30) {
                        System.out.println("Номер дня в сентябре и ноябре не может быть больше 30!");
                        return false;
                    }
                }
            }
            return true;
        }

}

