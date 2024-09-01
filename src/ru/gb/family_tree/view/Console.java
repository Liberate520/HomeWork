package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.view.menu.Menu;
import ru.gb.family_tree.view.menu.main_menu.MainMenu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Console implements View{
    private Presenter presenter;
    private Scanner scanner;
    private List<Menu> menuList;
    private Menu activeMenu;
    private boolean work;

    public Console() {
        scanner = new Scanner(System.in);
        menuList = new LinkedList<>();
        activeMenu = new MainMenu(this);
        menuList.add(activeMenu);
        work = true;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work){
            System.out.println(activeMenu.print());
            String choice = scanner.nextLine();
            activeMenu.execute(choice);
        }
    }

    public void addHuman(){
        String name = getName();
        LocalDate birthDate = getBirthDate();
        Gender gender = getGender();

        presenter.addHuman(name, gender, birthDate);
    }

    private Gender getGender() {
        while (true) {
            System.out.println("Укажите пол (male/female)");
            String strGender = scanner.nextLine();
            if (Arrays.stream(Gender.values()).anyMatch(gender -> gender.name().equalsIgnoreCase(strGender))) {
                return Gender.valueOf(strGender.toUpperCase());
            }
        }
    }

    private LocalDate getBirthDate() {
        while (true) {
            System.out.println("Укажите дату в формате dd.mm.yyyy");
            String strDate = scanner.nextLine();
//            if (checkDate(strDate)) {
            return LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//            }
        }
    }

    private String getName() {
        System.out.println("Введите имя человека");
        return scanner.nextLine();
    }

    private void error(){
        System.out.println("Неверный ввод. Попробуйте снова");
    }

    public void getHumanList(){
        presenter.getHumanList();
    }

    public void findHumanById() {
    }

    public void sortBy() {
    }

    public void returnToPreviosMenu() {
    }

    public void sortByBirthDate() {

    }

    public void sortByName() {

    }
}
