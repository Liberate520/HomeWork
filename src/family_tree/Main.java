package family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        FamilyTree my_family = new FamilyTree();

        Human my = new Human("ID1", "Иван", Gender.Male, LocalDate.of(2018,4,4));
        Human my_m = new Human("ID2", "Елена", Gender.Female, LocalDate.of(1987,4,29));
        Human my_f = new Human("ID3", "Илья", Gender.Male, LocalDate.of(1989,3,7));
        Human my_mm = new Human("ID4", "Зоя", Gender.Female, LocalDate.of(1961,5,9));
        Human my_mf = new Human("ID5", "Александр", Gender.Male, LocalDate.of(1961,7,11));
        Human my_fm = new Human("ID6", "Наталья", Gender.Female, LocalDate.of(1963,5,26));
        Human my_ff = new Human("ID7", "Михаил", Gender.Male, LocalDate.of(1962,1,21));
        my_family.addRecord(my, my_m, my_f);
        my_family.addRecord(my_m, my_mm, my_mf);
        my_family.addRecord(my_f, my_fm, my_ff);

        PrintData(my_family.getfTree());


    }

    public static void PrintData(HashSet<Human> data) {
        StringBuilder header = new StringBuilder();
        Formatter formatter = new Formatter(header);
        formatter.format("|%13s | " +
                        "%13s |" +
                        "%13s |" +
                        "%14s |" +
                        "%13s |" +
                        "%13s |" +
                        "%13s |" +
                        "%20s |"
                , "ID",
                "Имя",
                "Пол",
                "Дата рождения",
                "Дата смерти",
                "Мать",
                "Отец",
                "Дети");
        String header_line="";
        for (int i = 0; i < header.length(); i++) {
            header_line+="-";
        }
        System.out.println(header_line);
        System.out.println(header);
        System.out.println(header_line);
        for (Human human : data)
            if (human != null) {
                System.out.println(human);
            }
        System.out.println(header_line);

    }

}
