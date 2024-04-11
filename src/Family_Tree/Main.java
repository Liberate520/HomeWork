package Family_Tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Название семьи (Фамилия)
        FamilyTree Family = new FamilyTree("Svers");

        //Родители семьи
        Human human1 = new Human("Jon", LocalDate.of(1905, 11, 15), "Man");
        Human human2 = new Human("Jane", LocalDate.of(1904, 12, 11), LocalDate.of(2022, 12,13), "Woman");

        // Дети
        //Заносим детей в книгу
        Human human3 = new Human("Uil", LocalDate.of(1953, 8, 17), "Man");
        Human human4 = new Human("Janin", LocalDate.of(1955, 5, 21), "Woman");
        //Отмечаем родителей каждого ребёнка

        human3.setFather(human1);
        human3.setMather(human2);

        human4.setFather(human1);
        human4.setMather(human2);

        //Заносим к каждому родителю их детей
        human1.addChild(human3);
        human1.addChild(human4);

        human2.addChild(human3);
        human2.addChild(human4);


        Family.addPerson(human1);
        Family.addPerson(human2);
        Family.addPerson(human3);
        Family.addPerson(human4);
        // System.out.println(Family.getPersonInfo());
        System.out.println(Family.getCntPerson());
    }
}

