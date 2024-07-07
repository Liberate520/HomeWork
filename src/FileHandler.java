import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler implements Writer {

    @Override
    public void save(List<HumanInfo> people, String path) throws IOException {
        try (PrintWriter writer = new PrintWriter(new File(path))) {
            for (HumanInfo person : people) {
                writer.println(person.getName());
                writer.println(person.getDob());
                writer.println(person.getDod() != null ? person.getDod() : ""); // Записываем пустую строку, если dod == null
                writer.println(person.getGender());
                writer.println(person.getFather() != null ? person.getFather().getName() : "");
                writer.println(person.getMother() != null ? person.getMother().getName() : "");
                writer.println(person.getChildren().size());
                for (HumanInfo child : person.getChildren()) {
                    writer.println(child.getName());
                }
                writer.println("---"); // Разделитель между людьми в файле
            }
        }
    }

    @Override
    public List<HumanInfo> load(String path) throws IOException {
        List<HumanInfo> people = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                if (name.equals("---")) {
                    continue;
                }
                LocalDate dob = LocalDate.parse(scanner.nextLine());
                String dodLine = scanner.nextLine();
                LocalDate dod = !dodLine.isEmpty() ? LocalDate.parse(dodLine) : null;
                Gender gender = Gender.valueOf(scanner.nextLine());
                String fatherName = scanner.nextLine();
                String motherName = scanner.nextLine();
                int childrenCount = Integer.parseInt(scanner.nextLine());

                HumanInfo person = new HumanInfo(name, dob, dod, gender);
                people.add(person);

                // Поиск и установка родителей
                HumanInfo father = find(people, fatherName);
                if (father != null) {
                    person.setFather(father);
                }

                HumanInfo mother = find(people, motherName);
                if (mother != null) {
                    person.setMother(mother);
                }

                // Добавление детей
                for (int i = 0; i < childrenCount; i++) {
                    String childName = scanner.nextLine();
                    HumanInfo child = find(people, childName);
                    if (child != null) {
                        person.addChild(child);
                    }
                }
            }
        }
        return people;
    }

    // Метод для поиска человека по имени в списке
    private HumanInfo find(List<HumanInfo> people, String name) {
        for (HumanInfo person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null; // Если человек не найден
    }
}