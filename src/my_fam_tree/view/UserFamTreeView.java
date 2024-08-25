package my_fam_tree.view;

import my_fam_tree.model.Human;

import java.util.List;
import java.util.Scanner;

public class UserFamTreeView implements FamTreeView {
    private Scanner scan;

    public UserFamTreeView() {
        this.scan = new Scanner(System.in, "UTF-8");
    }

    public void menu() {
        System.out.println("\nВыберите номер:");
        System.out.println("1. Добавить человека");
        System.out.println("2. Найти человека");
        System.out.println("3. Показать всю семью");
        System.out.println("4. Сортировать по имени");
        System.out.println("5. Сортировать по дате рождения");
        System.out.println("6. Сохранить дерево");
        System.out.println("7. Загрузить дерево");
        System.out.println("0. Выйти");
    }


    @Override
    public int menuChoice(){
        return Integer.parseInt(scan.nextLine());
    }
    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scan.nextLine();
    }

    @Override
    public void screenMess(String message) {
        System.out.println(message);
    }

    @Override
    public void screenHuman(Human human) {
        System.out.println(human);
    }

    @Override
    public void screenHumanList(List<Human> people) {
        for (Human human : people) {
            System.out.println(human);
        }
    }
}


