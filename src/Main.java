// Main.java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Вывести на экран всех членов семьи");
            System.out.println("2. Добавить нового члена семьи и установить его родственные связи");
            System.out.println("3. Найти члена семьи и посмотреть его родственные связи");
            System.out.println("4. Закончить работу");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистка буфера

            switch (choice) {
                case 1:
                    // Вывод всех членов семьи
                    List<Person> people = familyTree.getAllPeople();
                    if (people.isEmpty()) {
                        System.out.println("В дереве пока нет членов семьи.");
                    } else {
                        System.out.println("Члены семьи:");
                        for (Person person : people) {
                            System.out.println(person);
                        }
                    }
                    break;

                case 2:
                    // Добавление нового члена семьи
                    System.out.print("Введите имя: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Введите фамилию: ");
                    String lastName = scanner.nextLine();

                    // Ввод даты рождения с проверкой
                    LocalDate birthDate = null;
                    while (birthDate == null) {
                        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
                        String birthDateStr = scanner.nextLine();
                        try {
                            birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
                        } catch (DateTimeParseException e) {
                            System.out.println("Неправильный формат даты. Пожалуйста, используйте формат ГГГГ-ММ-ДД.");
                        }
                    }

                    System.out.print("Введите пол (Мужчина/Женщина): ");
                    String gender = scanner.nextLine();

                    Person newPerson = new Person(firstName, lastName, birthDate, gender);
                    familyTree.addPerson(newPerson);

                    System.out.print("Укажите ID матери (или -1, если не известно): ");
                    int motherId = scanner.nextInt();
                    System.out.print("Укажите ID отца (или -1, если не известно): ");
                    int fatherId = scanner.nextInt();
                    scanner.nextLine();  // Очистка буфера

                    if (motherId != -1 || fatherId != -1) {
                        familyTree.setParents(newPerson.getId(), motherId, fatherId);
                    }

                    System.out.println("Член семьи добавлен.");
                    break;

                case 3:
                    // Поиск члена семьи и просмотр его родственных связей
                    System.out.print("Введите ID, имя или фамилию для поиска: ");
                    String searchInput = scanner.nextLine();

                    if (searchInput.matches("\\d+")) { // Проверка, является ли ввод числом
                        int searchId = Integer.parseInt(searchInput);
                        Person personById = familyTree.getPerson(searchId);
                        if (personById != null) {
                            System.out.println(personById);
                            familyTree.getParents(searchId);
                            familyTree.getChildren(searchId);
                        } else {
                            System.out.println("Член семьи с таким ID не найден.");
                        }
                    } else {
                        // Если не число, ищем по имени и/или фамилии
                        String[] nameParts = searchInput.split(" ");
                        List<Person> matchedPeople;

                        if (nameParts.length == 2) {
                            // Если пользователь ввел и имя, и фамилию
                            matchedPeople = familyTree.findByName(nameParts[0], nameParts[1]);
                        } else {
                            // Если введено одно слово, ищем по имени и фамилии
                            matchedPeople = familyTree.findByName(searchInput, searchInput);
                        }

                        if (!matchedPeople.isEmpty()) {
                            System.out.println("Найдены следующие члены семьи:");
                            for (Person person : matchedPeople) {
                                System.out.println(person);
                            }
                        } else {
                            System.out.println("Член семьи с таким именем или фамилией не найден.");
                        }
                    }
                    break;

                case 4:
                    // Закончить работу
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
                    break;
            }
        }
    }
}
