package view;

import model.person.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Scanner scanner=new Scanner(System.in);

    private Presenter presenter;

    private boolean work;

    public ConsoleUI() {
        this.scanner = scanner;
        presenter = new Presenter(this);
        work=true;
    }

    @Override
    public void printAnswer(String textAnswer) {
        System.out.println(textAnswer);
    }

    @Override
    public void start() {
        System.out.println("Рады видеть Вас!");
        System.out.println();
        menu();
    }

    public void menu(){
        while(work){
            System.out.println("Выполните действие:");
            System.out.println("1. Добавить объект в семейное древо");
            System.out.println("2. Добавить родственные связи");
            System.out.println("3. Показать семейное древо");
            System.out.println("4. Выполнить сортировку по имени");
            System.out.println("5. Выполнить сортировку по дате рождения");
            System.out.println("6. Сохранить древо в файл");
            System.out.println("7. Загрузить древо из файла");
            System.out.println("8. Выход");

            int userChoice=scanner.nextInt();
            scanner.nextLine();

            switch (userChoice){
                case 1:
                    System.out.println("Добавьте члена семьи:");
                    String name = scanner.nextLine();

                    System.out.println("Укажите пол (male/female):");
                    //Проверяем на валидность введенные данные
                    String printGender=scanner.nextLine();
                    while (!printGender.equals("male")&&!printGender.equals("female")){
                        System.out.println("Вы ввели некорректное значение. Попробуйте снова.");
                        printGender=scanner.nextLine();
                    }
                    Gender gender = Gender.valueOf(printGender);


                    System.out.println("Введите год рождения члена семьи в формате гггг-мм-дд:");
                    //Проверяем на валидность введенную дату рождения.
                    LocalDate today = LocalDate.now();
                    LocalDate bDay = LocalDate.parse(scanner.nextLine());
                    while(bDay.isAfter(today)){
                        System.out.println("Вы ввели некорректное значение. Попробуйте снова.");
                        bDay = LocalDate.parse(scanner.nextLine());
                    }
                    LocalDate birthDate = bDay;


                    System.out.println("В случае необходимости укажите дату смерти члена семьи в формате гггг-мм-дд. В противном случае пропустите, нажав Enter");
                    String dateOfDeath=scanner.nextLine();
                    LocalDate deathDate;
                    if (dateOfDeath != "") {
                        deathDate = LocalDate.parse(dateOfDeath);
                    } else {
                        deathDate=null;
                    }

                    presenter.addPerson(name,gender,birthDate,deathDate);
                    System.out.println("Член семьи добавлен в древо.");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Введите имя родителя (должно полностью соответствовать имени ранее добавленного члена семьи)");
                    String parentName = scanner.nextLine();
                    System.out.println("Введите имя ребенка (должно полностью соответствовать имени ранее добавленного члена семьи)");
                    String childName = scanner.nextLine();
                    presenter.addKinship(parentName,childName);
                    System.out.println("Родственные связи установлены");
                    System.out.println();
                    break;

                case 3:
                    presenter.getTreeInfo();
                    break;

                case 4:
                    presenter.sortByName();
                    break;

                case 5:
                    presenter.sortByDateOfBirth();
                    break;

                case 6:
                    presenter.saveTree();
                    break;

                case 7:
                    presenter.upLoadTree();
                    break;

                case 8:
                    work=false;
                    break;
                default:
                    System.out.println("Указанный пункт отсутствует в меню. Попробуйте снова.");
                    break;

            }


        }

    }

}
