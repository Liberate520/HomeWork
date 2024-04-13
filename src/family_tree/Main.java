package family_tree;

import family_tree.family.GenealogyTree;
import family_tree.person.Person;

public class Main {
    public static void main(String[] args) {
        GenealogyTree tree = new GenealogyTree();

        // Добавление людей в древо
        Person vasily = new Person(0, "Василий", "Male", 50);
        Person maria = new Person(1, "Мария", "Female", 45);
        Person larisa = new Person(2, "Лариса", "Female", 90);
        Person gena = new Person(3, "Геннадий", "Male", 95);

// Добавляем всех людей в древо
        tree.addPerson(vasily);
        tree.addPerson(maria);
        tree.addPerson(larisa);

// Установка супругов
vasily.setSpouse(maria);
maria.setSpouse(vasily);

// Установка родителей
vasily.setMother(larisa);
vasily.setFather(gena);


// Установка детей
vasily.addChild(new Person(3, "Кристина", "Female", 25));
vasily.addChild(new Person(4, "Семен", "Male", 20));


        // Вывод информации о всех людях
        System.out.println("Информация о всех людях в древе:");
        for (Person person : tree.getAllPeople()) {
            tree.displayPersonInfo(person.getId());
        }

    }

}