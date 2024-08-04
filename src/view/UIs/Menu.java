package view.UIs;

import view.UIs.commands.*;
import view.UIs.helpers.CheckNumber;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    List<Command> commands;
    ConsoleUI view;
    boolean flag;
    Scanner scanner;

    public Menu(ConsoleUI view) {
        this.commands = new ArrayList<>();
        this.view = view;
        scanner = new Scanner(System.in);
        flag = true;
        commands.add(new AddHumanCom("Добавить человека", view));
        commands.add(new GetHumanCom("Получить человека по ID", view));
        commands.add(new SetParentCom("Установить родителя", view));
        commands.add(new GetChildrenCom("Показать детей", view));
        commands.add(new PrintTreeCom("Показать дерево", view));
        commands.add(new GetSiblingsCom("Показать братьев и сестер", view));
        commands.add(new GetAncestorsCom("Показать предков", view));
        commands.add(new GetDescendantsCom("Показать потомков", view));
        commands.add(new ExitCom("Выход", view));
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void menu() {
        int choice;
        while (flag) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < commands.size(); i++) {
                sb.append(i + 1);
                sb.append(". ");
                sb.append(commands.get(i).getName());
                sb.append(System.lineSeparator());
            }
            System.out.println(sb.toString());
            String input = scanner.nextLine();
            if (CheckNumber.isNumber(input)){
                choice = Integer.parseInt(input);
                if (choice > 0 && choice <= commands.size())
                    commands.get(choice - 1).exec();
            }
        }
    }


}
