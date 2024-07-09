package FamilyTree.view;

import FamilyTree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;
    private int work = 1;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    public String help(){
        StringBuilder sb = new StringBuilder();
        sb.append("Комманды для работы с семейным древом (Хотел спать, времени реализовать больше - не было): ");
        sb.append("\n- /help - вывести список всех комманд.");
        sb.append("\n- /createFamilyTree [Имя] - создать семейное древо.");
        sb.append("\n- /stop - остановить выполнение программы (ВСЕ УДАЛИТСЯ, БД не подключено)");
        return sb.toString();
    }

    public void createFamilyTree(String name){
        presenter.createFamilyTree(name);
        printAnswer("Древо создано!");
    }

    @Override
    public void start() {
        printAnswer("Приветствуем в программе создания древа! Это начальный вариант реализации консольного приложения. \n" +
                "Если хоите узнать список команд - напишите /help");
        while (work == 1){
            String query = scanner.nextLine();
            String[] parts = query.split(" ");
            if(parts.length > 2){
                System.out.println("Запрос неверный, введите комманду ещё раз.");
            }
            switch (parts[0]) {
                case "/help":
                    printAnswer(help());
                    break;
                case "/createFamilyTree":
                    createFamilyTree(parts[1]);
                    break;
                case "/stop":
                    work = 0;
                    break;
                default: printAnswer("Комманда введена неверно!");
            }
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
