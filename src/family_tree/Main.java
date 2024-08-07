package family_tree;

import family_tree.saving_data.FileHandler;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FamilyTree my_family = new FamilyTree();

        FillTreeRandom(my_family);
        CreateRandomRelationships(my_family);
        SetRandomDeath(my_family);

        PrintData(my_family.getfTree());

        FileHandler fh = new FileHandler();
        fh.setFilePath("data.out");
        fh.writeData(my_family);

        FamilyTree my_family_from_file = fh.readData();
        PrintData(my_family_from_file.getfTree());

        PrintData(my_family_from_file.findInfoByName("Имя 148"));
        PrintData(my_family_from_file.findInfoByDocument("doc11"));

    }

    public static void PrintData(HashSet<Human> data) {
        if (data.isEmpty()) {
            System.out.println("Информация не найдена");
        }
        else {
            StringBuilder header = new StringBuilder();
            Formatter formatter = new Formatter(header);
            formatter.format("|%13s | " +
                            "%13s |" +
                            "%13s |" +
                            "%14s |" +
                            "%13s |" +
                            "%13s |" +
                            "%13s |" +
                            "%50s |"
                    , "Документ",
                    "Имя",
                    "Пол",
                    "Дата рождения",
                    "Дата смерти",
                    "Мать",
                    "Отец",
                    "Дети");
            String header_line = "";
            for (int i = 0; i < header.length(); i++) {
                header_line += "-";
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

    public static void FillTreeRandom(FamilyTree my_family) {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            String id = "doc" + i;
            String name = "Имя " + rand.nextInt(1000);
            Gender gender = Gender.values()[rand.nextInt(Gender.values().length)];
            LocalDate birth = LocalDate.of(rand.nextInt(1024,2024),rand.nextInt(1, 12),rand.nextInt(1, 28));
            Human human = new Human(id,name,gender,birth);
            my_family.addHuman(human);
        }

    }

    public static void CreateRandomRelationships(FamilyTree my_family) {
        HashSet<Human> data = my_family.getfTree();
        int index = 0;
        for (Human human : data) {
            if (index % 2 == 0) {
                human.setParents(FindRandomMother(human, data));
            }
            if (index % 3 == 0) {
                human.setParents(FindRandomFather(human, data));
            }
            index++;
        }
    }

    public static void SetRandomDeath(FamilyTree my_family) {
        HashSet<Human> data = my_family.getfTree();
        Random rand = new Random();
        int index = 0;
        for (Human human : data) {
            if (index % 5 == 0) {
                LocalDate death = human.getBirthDate().plusYears(rand.nextInt(100));
                human.setDeathDate(death);
            }
            index ++;
        }
    }

    public static Human FindRandomMother(Human human, HashSet<Human> data) {
        Random rand = new Random();
        ArrayList<Human> possibleM = new ArrayList<>();
        for (Human h : data) {
            if (h.getGender() == Gender.Female && !human.equals(h)) {
                possibleM.add(h);
            }
        }
            int ramdom_indexM = rand.nextInt(possibleM.size());
            return possibleM.get(ramdom_indexM);
    }

    public static Human FindRandomFather(Human human, HashSet<Human> data) {
        Random rand = new Random();
        ArrayList<Human> possibleF = new ArrayList<>();
        for (Human h : data) {
            if (h.getGender() == Gender.Male && !human.equals(h)) {
                possibleF.add(h);
            }
        }
        int ramdom_indexM = rand.nextInt(possibleF.size());
        return possibleF.get(ramdom_indexM);
    }

}
