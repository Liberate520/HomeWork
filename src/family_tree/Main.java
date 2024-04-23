package family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import family_tree.human.Gender;
import family_tree.human.Human;

public class Main {

    public static void main(String[] args) {
        List<Human> members = new ArrayList<>();

        Human vito = new Human("Vito", LocalDate.of(1891, 12, 7), Gender.Male);
        vito.setDateOfDeath(LocalDate.of(1955, 7, 29));

        Human carmine = new Human("Carmine", LocalDate.of(1877, 11, 21), Gender.Male);
        carmine.setDateOfDeath(LocalDate.of(1934, 5, 23));

        Human antonio = new Human("Antonio", LocalDate.of(1892, 8, 8), Gender.Male);

        Human antonia = new Human("Antonia", LocalDate.of(1892, 8, 5), Gender.Female);
        antonia.setDateOfDeath(LocalDate.of(1915, 11, 7));

        Human andolini = new Human("Andolini", LocalDate.of(1860, 5, 4), Gender.Male);
        andolini.setDateOfDeath(LocalDate.of(1891, 8, 30));

        Human andoliniMother = new Human("Andolini's mother", LocalDate.of(1838, 4, 12), Gender.Female);
        andoliniMother.setDateOfDeath(LocalDate.of(1893, 3, 18));

        Human connie = new Human("Connie", LocalDate.of(1927, 12, 17), Gender.Female);

        Human carlo = new Human("Carlo", LocalDate.of(1920, 3, 18), Gender.Male);
        carlo.setDateOfDeath(LocalDate.of(1955, 7, 29));

        Human michael = new Human("Michael", LocalDate.of(1920, 9, 23), Gender.Male);

        Human sonny = new Human("Sonny", LocalDate.of(1917, 5, 17), Gender.Male);
        sonny.setDateOfDeath(LocalDate.of(1948, 7, 29));

        Human fredo = new Human("Fredo", LocalDate.of(1919, 4, 17), Gender.Male);
        fredo.setDateOfDeath(LocalDate.of(1958, 5, 14));

        Human tom = new Human("Tom", LocalDate.of(1900, 8, 31), Gender.Male);
        tom.setDateOfDeath(LocalDate.of(1955, 7, 30));

        Human hagen = new Human("Hagen", LocalDate.of(1901, 10, 30), Gender.Male);

        Human kay = new Human("Kay", LocalDate.of(1925, 5, 10), Gender.Female);

        Human luci = new Human("Luci", LocalDate.of(1923, 4, 22), Gender.Female);

        Human vincent = new Human("Vincent", LocalDate.of(1948, 9, 15), Gender.Male);

        // Устанавливаем отношения
        vito.setFather(carmine);
        vito.setMother(antonia);
        antonia.setFather(andolini);
        antonia.setMother(andoliniMother);
        michael.setFather(vito);
        michael.setMother(kay);
        sonny.setFather(vito);
        sonny.setMother(kay);
        fredo.setFather(vito);
        fredo.setMother(kay);
        connie.setFather(vito);
        connie.setMother(kay);
        carlo.setFather(vito);
        carlo.setMother(kay);
        tom.setFather(vito);
        tom.setMother(kay);
        hagen.setFather(vito);
        hagen.setMother(kay);
        vincent.setFather(sonny);
        vincent.setMother(luci);

        // Добавляем членов семьи в список
        members.add(vito);
        members.add(carmine);
        members.add(antonio);
        members.add(andolini);
        members.add(andoliniMother);
        members.add(michael);
        members.add(sonny);
        members.add(fredo);
        members.add(connie);
        members.add(carlo);
        members.add(tom);
        members.add(hagen);
        members.add(kay);
        members.add(luci);

        Scanner scanner = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.println();
            System.out.println("Выберите действие:");
            System.out.println("1. Вывести список членов семьи");
            System.out.println("2. Добавить нового члена семьи");
            System.out.println("3. Отсортировать по имени");
            System.out.println("4. Отсортировать по дате рождения");
            System.out.println("5. Завершить программу");
            System.out.println();

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Список членов семьи Карлеоне:");
                        for (Human member : members) {
                            System.out.println("Имя: " + member.getName() + ", Дата рождения: " + member.getDateOfBirth() + ", Дата смерти: " + member.getDateOfDeath() + ", Пол: " + member.getGender());
                            if (member.getMother() != null) {
                                System.out.println("Мать: " + member.getMother().getName());
                            }
                            if (member.getFather() != null) {
                                System.out.println("Отец: " + member.getFather().getName());
                            }
                            System.out.println();
                        }
                        break;
                    case 2:
                        // Логика добавления нового члена семьи
                        System.out.println("Введите имя нового члена семьи:");
                        String name = scanner.next();
                        System.out.println("Введите дату рождения в формате ГГГГ-ММ-ДД:");
                        LocalDate birthDate = LocalDate.parse(scanner.next());
                        System.out.println("Введите пол (Male/Female):");
                        String genderInput = scanner.next().toLowerCase();
                        Gender gender;
                        if (genderInput.equals("male")) {
                            gender = Gender.Male;
                        } else if (genderInput.equals("female")) {
                            gender = Gender.Female;
                        } else {
                            System.out.println("Ошибка: Некорректный ввод пола.");
                            break;
                        }
                        
                        Human newMember = new Human(name, birthDate, gender);
                        
                        // Запрос информации о родителях
                        System.out.println("Введите имя отца:");
                        String fatherName = scanner.next();
                        System.out.println("Введите имя матери:");
                        String motherName = scanner.next();
                        
                        // Поиск отца и матери в списке членов семьи
                        Human father = null;
                        Human mother = null;
                        for (Human member : members) {
                            if (member.getName().equals(fatherName)) {
                                father = member;
                            }
                            if (member.getName().equals(motherName)) {
                                mother = member;
                            }
                            if (father != null && mother != null) {
                                break;
                            }
                        }
                        
                        // Установка родителей новому члену семьи
                        if (father != null && mother != null) {
                            newMember.setFather(father);
                            newMember.setMother(mother);
                            members.add(newMember);
                            System.out.println("Новый член семьи успешно добавлен!");
                        } else {
                            System.out.println("Ошибка: Один из родителей не найден в списке членов семьи.");
                        }
                        break;
                    case 3:
                        Collections.sort(members, Comparator.comparing(Human::getName));
                        System.out.println("Отсортированный список по имени:");
                        for (Human member : members) {
                            System.out.println(member.getName());
                        }
                        break;
                    case 4:
                        Collections.sort(members, Comparator.comparing(Human::getDateOfBirth));
                        System.out.println("Отсортированный список по дате рождения:");
                        for (Human member : members) {
                            System.out.println(member.getName() + " - " + member.getDateOfBirth());
                        }
                        break;
                    case 5:
                        System.out.println("Программа завершена.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Некорректный ввод. Попробуйте еще раз.");
                        break;
                }
            } else {
                System.out.println("Ошибка: Введите число от 1 до 5");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }
    }
}
