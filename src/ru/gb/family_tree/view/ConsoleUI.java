package ru.gb.family_tree.view;


import model.creatures.Gender;
import presenter.Presenter;
import view.input.ConsoleInput;
import view.input.Input;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//TODO: ������� ��������� ���������� � ��������� �����

public class ConsoleUI implements View {
    private final Scanner scanner;
    private final Input input;
    private boolean work;
    private final MainMenu menu;
    private Presenter presenter;

    public ConsoleUI() {
        this.input = new ConsoleInput();
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter();
        work = true;
        menu = new MainMenu(this);
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    @Override
    public void start() {
        System.out.println("������������!\n������� � ������� ����� ���� � ������� Enter");
        while (work) {
            printMenu();
            execute();
        }
    }

    public void addCreature() {
        Gender gend = Gender.Male;
        System.out.println("������� ���: ");
        String name = scanner.nextLine();
        System.out.println("������� �������: ");
        String lastName = scanner.nextLine();
        boolean flag = false;
        System.out.println("�������� ���: 1. �������, 2. �������");
        while (!flag) {
            int gender = input.rangeIntInput(1, 2);
            if (gender == 2) {
                gend = Gender.Female;
                flag = true;
            }
            if (gender == 1) {
                gend = Gender.Male;
                flag = true;
            } else {
                System.out.println("��������� ������� ���: 1. �������, 2. �������");
            }
        }
        flag = false;
        LocalDate date = null;
        while (!flag) {
            try {
                System.out.println("������� ���� �������� � ������� ���-�����-����: (1990-09-10):");
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(scanner.nextLine(), dateFormat);
                flag = true;
            } catch (DateTimeParseException ignored) {
            }
        }
        if (presenter.addCreature(name, lastName, gend, date)) {
            System.out.println("������� ������� ��������!");
        } else {
            System.out.println("�� ������� ������� ������ ��������");
        }
    }

    public void showTree() {
        System.out.println(presenter.showTree());
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void execute() {
        try {
            menu.execute(input.intInput());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("����������, ������� ���������� ����� ������ ����");
        }
    }

    public void showNotInTree() {
        System.out.println(presenter.showNotInTree());
    }

    public void setChild() {
        System.out.println("������� ID ��������:");
        Integer parentID = input.intInput();
        System.out.println("������� ID �������:");
        Integer childID = input.intInput();
        if (presenter.setChild(parentID, childID)) {
            System.out.println("������� ������� �����");
        } else {
            System.out.println("�� ������� ������ ������� c ������ �����������");
        }
    }

    public void showAll() {
        System.out.println(presenter.showAll());
    }

    public void ShowAllInfo() {
        System.out.println("������� ID ��������");
        Integer id = input.intInput();
        System.out.println(presenter.showAllInfo(id));
    }

    public void showHumanTree() {
        System.out.println(presenter.showHumanTree());
    }

    public void setSpouce() {
        System.out.println("������� ID ������� �������");
        Integer id = input.intInput();
        System.out.println("������� ID ������� �������");
        Integer id2 = input.intInput();
        if (presenter.setSpouce(id, id2)) {
            System.out.println("������� ������ �������!");
        } else {
            System.out.println("�� ������� ��������� �������");
        }

    }

    public void saveFamilyTree() {
        System.out.println("������� ��� �����: ");
        if (presenter.saveFamilyTree(scanner.nextLine())) {
            System.out.println("��������� ������� ���������");
        } else {
            System.out.println("�� ������� ��������� ���������");
        }

    }

    public void loadFamilyTree() {
        System.out.println("������� ��� �����: ");
        if (presenter.loadFamilyTree(scanner.nextLine())) {
            System.out.println("������ ������� ���������");
        } else {
            System.out.println("�� ������� ��������� �� �����");
        }
    }

    public void SetDivorce() {
        System.out.println("������� ID ������� �������");
        Integer id = input.intInput();
        System.out.println("������� ID ������� �������");
        Integer id2 = input.intInput();
        if (presenter.setDivorce(id, id2)) {
            System.out.println("������� ������� ���������");
        } else {
            System.out.println("�� ������� ��������� �������");
        }
    }

    public void setFather() {
        System.out.println("������� ID �������:");
        Integer childId = input.intInput();
        System.out.println("������� ID ����:");
        Integer fatherId = input.intInput();
        if (presenter.setFather(childId, fatherId)) {
            System.out.println("���� ������� �����");
        } else {
            System.out.println("�� ������� ������ ���� c ������ �����������");
        }
    }

    public void setMother() {
        System.out.println("������� ID �������:");
        Integer childId = input.intInput();
        System.out.println("������� ID ������:");
        Integer motherID = input.intInput();
        if (presenter.setMother(childId, motherID)) {
            System.out.println("���� ������� ������");
        } else {
            System.out.println("�� ������� ������ ���� c ������ �����������");
        }
    }

    public void setDeathDate() {
        boolean flag = false;
        LocalDate date = null;
        System.out.println("������� ID ��������:");
        Integer humanID = input.intInput();
        while (!flag) {
            try {
                System.out.println("������� ���� ������ � ������� ���-�����-����: (1990-09-10):");
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(scanner.nextLine(), dateFormat);
                flag = true;
            } catch (DateTimeParseException ignored) {
            }
        }
        if (presenter.setDeathDate(humanID, date)) {
            System.out.println("���� ������ ������� ������");
        } else {
            System.out.println("�� ������� ������ ���� ������");
        }
    }
}