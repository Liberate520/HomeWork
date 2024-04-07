package family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

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

        // Добавляем членов семьи в дерево
        tree.addMember(vito);
        tree.addMember(carmine);
        tree.addMember(antonio);
        tree.addMember(andolini);
        tree.addMember(andoliniMother);
        tree.addMember(michael);
        tree.addMember(sonny);
        tree.addMember(fredo);
        tree.addMember(connie);
        tree.addMember(carlo);
        tree.addMember(tom);
        tree.addMember(hagen);
        tree.addMember(kay);

        // Пример других действий с деревом семьи
        System.out.println("Члены семьи Карлеоне:");
        for (Human member : tree.getMembers()) {
            System.out.println("Имя: " + member.getName() + ", Дата рождения: " + member.getDateOfBirth() + ", Дата смерти: " + member.getDateOfDeath() + ", Пол: " + member.getGender());
            if (member.getMother() != null) {
                System.out.println("Мать: " + member.getMother().getName());
            }
            if (member.getFather() != null) {
                System.out.println("Отец: " + member.getFather().getName());
            }
            System.out.println();
        }
    }
}
