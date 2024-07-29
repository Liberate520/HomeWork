package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.service.FamilyTreeService;
import ru.gb.family_tree.service.HumanBuilder;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Human> al = new ArrayList<>();
        al.add(new Human());
        al.add(new Human());
        al.add(new Human());
        al.add(new Human());
        al.add(new Human());
        al.add(new Human());
        al.add(new Human());
        /*
        al.add(new Human.HumanBuilder("Евдокия Лукъяновна Стрешнева",
                Gender.FEMALE, LocalDate.of(1626,2,15), null, null)
                .setHumanDeathDate(LocalDate.of(1645,7,23))
                .build());

         */
        /*
        Human human = new Human.HumanBuilder("Евдокия Лукъяновна Стрешнева",
                Gender.FEMALE, LocalDate.of(1626,2,15), null, null)
                .setHumanDeathDate(LocalDate.of(1645,7,23))
                .build();
        //list.get(6).setName("Евдокия Лукъяновна Стрешнева");
        //list.get(6).setBirthDay(LocalDate.of(1626,2,15));
        //list.get(6).setDeathDate(LocalDate.of(1645,7,23));
        //list.get(6).setGender(Gender.FEMALE);

         */
        al.add(new Human());
        /*
        al.add(new Human.HumanBuilder("Василий Михайлович Рoмaнoв",
                Gender.MALE, LocalDate.of(1639,3,24), al.getFirst(), al.get(6))
                .setHumanDeathDate(LocalDate.of(1639,4,4))
                .build());

         */
        //list.getLast().setName("Василий Михайлович Рoмaнoв");
        //list.getLast().setBirthDay(LocalDate.of(1639,3,24));
        //list.getLast().setDeathDate(LocalDate.of(1639,4,4));
        //list.getLast().setGender(Gender.MALE);
        //list.getLast().setFather(list.getFirst());
        //list.getLast().setMother(list.get(6));
        FamilyTree<Human> ft = new FamilyTree<>();
        FileHandler fh = new FileHandler();
        FamilyTreeService<Human> service = new FamilyTreeService<>();

        menu();
        int menuPoint;
        menuPoint = scanner.nextInt();
        while (menuPoint != 9) {
            switch (menuPoint) {
                case 1:
                    System.out.println("Список людей древа:");
                    System.out.println(service.getInfo(ft));
                    break;
                case 2:
                    System.out.println("Список людей древа (отсортированный по имени):");
                    ft.sortByName();
                    System.out.println(ft.getInfo());
                    break;
                case 3:
                    System.out.println("Список людей древа (отсортированный по возрасту):");
                    ft.sortByAge();
                    System.out.println(ft.getInfo());
                    break;
                case 4:
                    System.out.println("Список людей древа (отсортированный по дате рождения):");
                    ft.sortByBirthDay();
                    System.out.println(ft.getInfo());
                    break;
                case 5:
                    System.out.println("Выберите id человека чтобы построть фамильное дерево:");
                    System.out.println(ft.getHumansChildrenInfo(scanner.nextInt()));
                    break;
                case 6:
                    createFamilyTree(al, ft);
                    System.out.println("Семейное древо создано.\n");
                    break;
                case 7:
                    al = fh.restoreFromFileH("Human.txt");
                    ft = fh.restoreFromFileFT("FamilyTree.txt");
                    System.out.println("Семейное древо востановленно из файла.");
                    break;
                case 8:
                    fh.saveToFile(al,"Human.txt");
                    fh.saveToFile(ft,"FamilyTree.txt");
                    System.out.println("Семейное древо сохранено в файл.");
                    break;
            }
            menu();
            menuPoint = scanner.nextInt();
        }
    }

    public static void menu() {
        StringBuilder result = new StringBuilder();
        result.append("Меню:").append("\n")
                .append("1 - Вывести список людей входящих в семейное древо.").append("\n")
                .append("2 - Вывести список людей входящих в семейное древо (отсортированный по имени).").append("\n")
                .append("3 - Вывести список людей входящих в семейное древо (отсортированный по возрасту).").append("\n")
                .append("4 - Вывести список людей входящих в семейное древо (отсортированный по дате рождения).").append("\n")
                .append("5 - Построть фамильное древо человека.").append("\n")
                .append("6 - Создать семейное древо.").append("\n")
                .append("7 - Восстановить семейное древо из файла.").append("\n")
                .append("8 - Сохранение семейного древа в файл.").append("\n")
                .append("9 - Выход.").append("\n").append("\n")
                .append("Выберите пункт меню: ");
        System.out.println(result);
    }

    public static void createFamilyTree(List<Human> list, FamilyTree<Human> familyTree) {
        //Human hum1 = new Human();
        list.getFirst().setId(1);
        list.getFirst().setName("Михaил Федopoвич Рoмaнoв");
        list.getFirst().setBirthDay(LocalDate.of(1596,7,12));
        list.getFirst().setDeathDate(LocalDate.of(1645,7,13));
        list.getFirst().setGender(Gender.MALE);

        //Human hum2 = new Human();
        list.get(1).setId(2);
        list.get(1).setName("Алекcей Михaйлoвич Рoмaнoв");
        list.get(1).setBirthDay(LocalDate.of(1629,3,9));
        list.get(1).setDeathDate(LocalDate.of(1676,1,29));
        list.get(1).setGender(Gender.MALE);
        list.get(1).setFather(list.getFirst());

        //Human hum3 = new Human();
        list.get(2).setId(3);
        list.get(2).setName("Федop III Алекcеевич Рoмaнoв");
        list.get(2).setBirthDay(LocalDate.of(1661,5,30));
        list.get(2).setDeathDate(LocalDate.of(1682,4,27));
        list.get(2).setGender(Gender.MALE);
        list.get(2).setFather(list.get(1));

        //Human hum4 = new Human();
        list.get(3).setId(4);
        list.get(3).setName("Ивaн V Алекcеевич Рoмaнoв");
        list.get(3).setBirthDay(LocalDate.of(1666,8,27));
        list.get(3).setDeathDate(LocalDate.of(1696,1,29));
        list.get(3).setGender(Gender.MALE);
        list.get(3).setFather(list.get(1));

        //Human hum5 = new Human();
        list.get(4).setId(5);
        list.get(4).setName("Петp I Алекcеевич Рoмaнoв");
        list.get(4).setBirthDay(LocalDate.of(1672,5,30));
        list.get(4).setDeathDate(LocalDate.of(1725,1,28));
        list.get(4).setGender(Gender.MALE);
        list.get(4).setFather(list.get(1));

        //Human hum6 = new Human();
        list.get(5).setId(6);
        list.get(5).setName("Елизaветa Петpoвнa Рoмaнoвa");
        list.get(5).setBirthDay(LocalDate.of(1709,12,18));
        list.get(5).setDeathDate(LocalDate.of(1761,12,25));
        list.get(5).setGender(Gender.FEMALE);
        list.get(5).setFather(list.get(4));

        list.get(6).setId(7);
        list.get(6).setName("Евдокия Лукъяновна Стрешнева");
        list.get(6).setBirthDay(LocalDate.of(1626,2,15));
        list.get(6).setDeathDate(LocalDate.of(1645,7,23));
        list.get(6).setGender(Gender.FEMALE);

        list.getLast().setId(8);
        list.getLast().setName("Василий Михайлович Рoмaнoв");
        list.getLast().setBirthDay(LocalDate.of(1639,3,24));
        list.getLast().setDeathDate(LocalDate.of(1639,4,4));
        list.getLast().setGender(Gender.MALE);
        list.getLast().setFather(list.getFirst());
        list.getLast().setMother(list.get(6));

        familyTree.addHuman(list.getFirst());
        familyTree.addHuman(list.get(1));
        familyTree.addHuman(list.get(2));
        familyTree.addHuman(list.get(3));
        familyTree.addHuman(list.get(4));
        familyTree.addHuman(list.get(5));
        familyTree.addHuman(list.get(6));
        familyTree.addHuman(list.getLast());
    }
}
