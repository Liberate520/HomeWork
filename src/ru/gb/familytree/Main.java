package ru.gb.familytree;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FamilyTree ft = new FamilyTree();

        Human hum1 = new Human();
        hum1.setId(1);
        hum1.setName("Михaил Федopoвич Рoмaнoв");
        hum1.setBirthDay(LocalDate.of(1596,7,12));
        hum1.setDeathDay(LocalDate.of(1645,7,13));
        hum1.setGender(Gender.Male);

        Human hum2 = new Human();
        hum2.setId(2);
        hum2.setName("Алекcей Михaйлoвич Рoмaнoв");
        hum2.setBirthDay(LocalDate.of(1629,3,9));
        hum2.setDeathDay(LocalDate.of(1676,1,29));
        hum2.setGender(Gender.Male);
        hum2.setFather(hum1);

        Human hum3 = new Human();
        hum3.setId(3);
        hum3.setName("Федop III Алекcеевич Рoмaнoв");
        hum3.setBirthDay(LocalDate.of(1661,5,30));
        hum3.setDeathDay(LocalDate.of(1682,4,27));
        hum3.setGender(Gender.Male);
        hum3.setFather(hum2);

        Human hum4 = new Human();
        hum4.setId(4);
        hum4.setName("Ивaн V Алекcеевич Рoмaнoв");
        hum4.setBirthDay(LocalDate.of(1666,8,27));
        hum4.setDeathDay(LocalDate.of(1696,1,29));
        hum4.setGender(Gender.Male);
        hum4.setFather(hum2);

        Human hum5 = new Human();
        hum5.setId(5);
        hum5.setName("Петp I Алекcеевич Рoмaнoв");
        hum5.setBirthDay(LocalDate.of(1672,5,30));
        hum5.setDeathDay(LocalDate.of(1725,1,28));
        hum5.setGender(Gender.Male);
        hum5.setFather(hum2);

        Human hum6 = new Human();
        hum6.setId(6);
        hum6.setName("Елизaветa Петpoвнa Рoмaнoвa");
        hum6.setBirthDay(LocalDate.of(1709,12,18));
        hum6.setDeathDay(LocalDate.of(1761,12,25));
        hum6.setGender(Gender.Female);
        hum6.setFather(hum5);

        ft.addHuman(hum1);
        ft.addHuman(hum2);
        ft.addHuman(hum3);
        ft.addHuman(hum4);
        ft.addHuman(hum5);
        ft.addHuman(hum6);

        System.out.println(hum4);

        System.out.println("Список людей древа:");
        System.out.println(ft.getHumansInfo());

        System.out.println("Выберите id человека чтобы построть фамильное дерево:");
        System.out.println(ft.getHumansChildrenInfo(Integer.parseInt(scanner.next())));
    }
}
