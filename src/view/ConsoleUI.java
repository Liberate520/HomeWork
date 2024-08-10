package view;

import java.util.Scanner;

public class ConsoleUI implements View{

    private Scanner scanner;



    @Override
    public void start() {
        while (true){
            System.out.println("1. Добавить студента");
            System.out.println("2. Отсортировать по имени");
            System.out.println("3. Отсортировать по возрасту");
            System.out.println("4. Отсортировать по дате рождения");
            System.out.println("5. Получить весь список");

            System.out.println("0. Завершение работы");
            String choice = scanner.nextLine();
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
