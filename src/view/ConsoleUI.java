package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{


        private static final String INPUT_ERROR = "Вы ввели неверное значение";
        private Scanner scanner;
        private Presenter presenter;
        private boolean work;
        private MainMenu menu;

        public ConsoleUI() {
            scanner = new Scanner(System.in);
            presenter = new Presenter(this);
            work = true;
            menu = new MainMenu(this);
        }

        @Override
        public void printAnswer(String text) {
            System.out.println(text);
        }

        @Override
        public void start() {
            hello();
            while (work){
                printMenu();
                execute();
            }
        }

        public void finish() {
            System.out.println("Завершение работы");
            work = false;
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




        private void hello(){
            System.out.println("Здравствуйте!");
        }

        private void execute(){
            String line = scanner.nextLine();
            if (checkTextForInt(line)){
                int numCommand = Integer.parseInt(line);
                if (checkCommand(numCommand)){
                    menu.execute(numCommand);
                }
            }
        }

        private boolean checkTextForInt(String text){
            if (text.matches("[0-9]+")){
                return true;
            } else {
                inputError();
                return false;
            }
        }

        private boolean checkCommand(int numCommand){
            if (numCommand <= menu.getSize()){
                return true;
            } else {
                inputError();
                return false;
            }
        }

        private void printMenu(){
            System.out.println(menu.menu());
        }

        private void inputError(){
            System.out.println(INPUT_ERROR);
        }

        public void save() {
         }

    public void setMenu(MainMenu menu) {
        this.menu = menu;
    }

}

