package family_tree.model;

import java.util.*;

public class FamilyTree implements Iterable<Human> {
    private List<Human> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.people.add(human);
    }

    public List<Human> getPeople() {
        return this.people;
    }

    public Human findHuman(String personName) {
        for (Human person : people) {
            if (person.getName().equals(personName)) {
                return person;
            }
        }
        return null;
    }

    public void printTree() {
        List<Human> printedPeople = new ArrayList<>();
        for (Human person : people) {
            if (!printedPeople.contains(person)) {
                printPerson(person, 0, printedPeople);
            }
        }
    }

    private void printPerson(Human person, int level, List<Human> printedPeople) {
        if (!printedPeople.contains(person)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append("  ");
            }
            sb.append(person.getName());
            System.out.println(sb.toString());
            printedPeople.add(person);
            for (Human child : person.getChildren()) {
                printPerson(child, level + 1, printedPeople);
            }
        }
    }

    // Метод для преобразования древа в текстовый формат
    public List<String> convertTreeToText() {
        List<String> lines = new ArrayList<>();
        for (Human person : people) {
            StringBuilder sb = new StringBuilder();
            sb.append(person.getName()).append(",").append(person.getGender()).append(",").append(person.getBirthDate()).append(",").append(person.getDeathDate());
            lines.add(sb.toString());
            for (Human parent : person.getParents()) {
                lines.add(parent.getName() + "," + person.getName());
            }
        }
        return lines;
    }

    @Override
    public Iterator<Human> iterator() {
        return people.iterator();
    }

    // Метод для сортировки списка людей по имени
    public void sortByNames() {
        Collections.sort(people, Comparator.comparing(Human::getName));
    }

    // Метод для сортировки списка людей по дате рождения
    public void sortByBirthDate(List<Human> people) {
        Collections.sort(people, new Comparator<Human>() {
            @Override
            public int compare(Human person1, Human person2) {
                // Разбиваем строки с датами рождения на компоненты
                String[] birthDate1 = person1.getBirthDate().split("-");
                String[] birthDate2 = person2.getBirthDate().split("-");

                // Сравниваем годы рождения
                int year1 = Integer.parseInt(birthDate1[2]);
                int year2 = Integer.parseInt(birthDate2[2]);
                if (year1 != year2) {
                    return Integer.compare(year1, year2);
                }

                // Если годы рождения одинаковые, сравниваем месяцы рождения
                int month1 = Integer.parseInt(birthDate1[1]);
                int month2 = Integer.parseInt(birthDate2[1]);
                if (month1 != month2) {
                    return Integer.compare(month1, month2);
                }

                // Если месяцы рождения одинаковые, сравниваем дни рождения
                int day1 = Integer.parseInt(birthDate1[0]);
                int day2 = Integer.parseInt(birthDate2[0]);
                return Integer.compare(day1, day2);
            }
        });
    }
}

