import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
//    final static String fileName = "src/tree.txt";

    public static void main(String[] args) {
        // Создание обработчика для работы с файлами
        Writer fileHandler = new FileHandler("src/tree.txt");

        // Создание модели семейного дерева
        FamilyTreeModel<Human> model = new FamilyTree<>(fileHandler);

        // Создание представления (вывод в консоль)
        FamilyTreeView view = new ConsoleFamilyTreeView();

        // Создание презентера для управления моделью и представлением
        FamilyTreePresenter presenter = new FamilyTreePresenter(model, view);



//        // FamilyTree tree = load();
//        FamilyTree tree = testTree();
//        save(tree);
//
//        System.out.println(tree);
//    }
//        private static FamilyTree load(){
//            FileHandler fileHandler  = new FileHandler(fileName);
//            return (FamilyTree) fileHandler.read();
//
//        }
//        private static void save(FamilyTree familyTree){
//            FileHandler fileHandler  = new FileHandler(fileName);
//            fileHandler.save(familyTree);
//        }
//
//
//        private static FamilyTree testTree(){
//            FamilyTree tree = new FamilyTree();

        // Пример добавления людей в генеалогическое древо
            Human john = new Human("John", "Doe", Gender.Male, LocalDate.of(1964, 1, 1));
            Human jane = new Human("Jane", "Doe", Gender.Female, LocalDate.of(1966, 2, 1));

            presenter.addHuman(john);
            presenter.addHuman(jane);
            model.setMarriage(john,jane);

            Human mary = new Human("Mary", "Smith", Gender.Female, LocalDate.of(1994, 3, 1), john, jane);
            Human tom = new Human("Tom", "Smith", Gender.Male, LocalDate.of(1992, 4, 1));


            presenter.addHuman(mary);
            presenter.addHuman(tom);
            //return tree;


        Scanner scanner = new Scanner(System.in);

        // Бесконечный цикл для работы программы
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Найти человека по ID");
            System.out.println("2. Найти человека по имени");
            System.out.println("3. Найти человека по фамилии");
            System.out.println("4. Получить информацию о детях человека");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Потребляем перевод строки

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите ID: ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Потребляем перевод строки
                    Human human = ((FamilyTree<Human>) model).getEById(id);
                    if (human != null) {
                        System.out.println(human);
                    } else {
                        System.out.println("Человек с таким ID не найден.");
                    }
                }
                case 2 -> {
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    List<Human> humansByName = ((FamilyTree<Human>) model).getEByName(name);
                    if (humansByName.isEmpty()) {
                        System.out.println("Человек с таким именем не найден.");
                    } else {
                        humansByName.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("Введите фамилию: ");
                    String surname = scanner.nextLine();
                    List<Human> humansBySurname = ((FamilyTree<Human>) model).getEBySurname(surname);
                    if (humansBySurname.isEmpty()) {
                        System.out.println("Человек с такой фамилией не найден.");
                    } else {
                        humansBySurname.forEach(System.out::println);
                    }
                }
                case 4 -> {
                    System.out.print("Введите ID человека для получения информации о его детях: ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Потребляем перевод строки
                    List<Human> children = ((FamilyTree<Human>) model).getAllChildren(id);
                    if (children.isEmpty()) {
                        System.out.println("У этого человека нет детей или ID неверен.");
                    } else {
                        System.out.println("Дети человека с ID " + id + ":");
                        children.forEach(System.out::println);
                    }
                }
                case 5 -> {
                    System.out.println("Выход.");
                    scanner.close(); // Закрываем сканнер
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        }
    }

        // while (true) {
        //     System.out.println("Выберите действие:");
        //     System.out.println("1. Найти человека по ID");
        //     System.out.println("2. Найти человека по имени");
        //     System.out.println("3. Найти человека по фамилии");
        //     System.out.println("4. Получить информацию о детях человека");
        //     System.out.println("5. Выйти");

        //     int choice = scanner.nextInt();
        //     scanner.nextLine(); // Consume newline

        //     switch (choice) {
        //         case 1 -> {
        //             System.out.print("Введите ID: ");
        //             String id = scanner.nextLine();
        //             E E = familyTree.getEById(id);
        //             if (E != null) {
        //                 System.out.println(E);
        //             } else {
        //                 System.out.println("Человек с таким ID не найден.");
        //             }
        //         }
        //         case 2 -> {
        //             System.out.print("Введите имя: ");
        //             String name = scanner.nextLine();
        //             List<E> EsByName = familyTree.getEByName(name);
        //             if (EsByName.isEmpty()) {
        //                 System.out.println("Человек с таким именем не найден.");
        //             } else {
        //                 EsByName.forEach(System.out::println);
        //             }
        //         }
        //         case 3 -> {
        //             System.out.print("Введите фамилию: ");
        //             String surname = scanner.nextLine();
        //             List<E> EsBySurname = familyTree.getEBySurname(surname);
        //             if (EsBySurname.isEmpty()) {
        //                 System.out.println("Человек с такой фамилией не найден.");
        //             } else {
        //                 EsBySurname.forEach(System.out::println);
        //             }
        //         }
        //         case 4 -> {
        //             System.out.print("Введите ID человека для получения информации о его детях: ");
        //             String id = scanner.nextLine();
        //             List<E> children = familyTree.getAllChildren(id);
        //             if (children.isEmpty()) {
        //                 System.out.println("У этого человека нет детей или ID неверен.");
        //             } else {
        //                 System.out.println("Дети человека с ID " + id + ":");
        //                 children.forEach(System.out::println);
        //             }
        //         }
        //         case 5 -> {
        //             System.out.println("Выход.");
        //             scanner.close();
        //             return;
        //         }
        //         default -> System.out.println("Неверный выбор. Попробуйте снова.");
        //     }
        // }
    
