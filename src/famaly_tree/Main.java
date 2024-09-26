package famaly_tree;

import famaly_tree.Tree.Tree;
import famaly_tree.human.Gender;
import famaly_tree.human.Human;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {
        Tree familyTree1 = new Tree();

        Human human01 = new Human("Андрей", LocalDate.of(2000,10,9), Gender.MALE);
        Human human02 = new Human("Мария", LocalDate.of(2002, 6, 23), Gender.FEMALE);
        Human human03 = new Human("Сергей", LocalDate.of(1976, 7, 6), Gender.MALE);
        Human human04 = new Human("Людмила", LocalDate.of(1989,2,15),Gender.FEMALE);
        Human human05 = new Human("Егор", LocalDate.of(1958, 8, 21), Gender.MALE);
        Human human06 = new Human("Антон", LocalDate.of(1981,2,11),Gender.FEMALE);
        Human human07 = new Human("Владислав", LocalDate.of(1960,8,1),Gender.MALE);
        Human human08 = new Human("Катерина", LocalDate.of(1960,5,18),Gender.FEMALE);

        human08.addChild(human04);
        human07.addChild(human04);
        human06.addChild(human03);
        human05.addChild(human03);
        human04.addChild(human02);
        human04.addChild(human01);
        human03.addChild(human02);
        human03.addChild(human01);

        human06.setDod(LocalDate.of(2014,12,12));
        human05.setDod(LocalDate.of(2013,11,20));

        // Проверка "полного" конструктора
        Human human00 = new Human("Мис Х", LocalDate.of(1982, 10, 10),LocalDate.of(1998,10,10),Gender.FEMALE,human04.getChildren(),human06,human05);


        familyTree1.addHuman(human08);
        familyTree1.addHuman(human07);
        familyTree1.addHuman(human06);
        familyTree1.addHuman(human05);
        familyTree1.addHuman(human04);
        familyTree1.addHuman(human03);
        familyTree1.addHuman(human02);
        familyTree1.addHuman(human01);

        // Показываем одного человека
        System.out.println(human01);

        // Показываем семейное древо
        //System.out.print(familyTree1);

        // Показывает имена детей в виде строки
        //System.out.println(human04.getChildrenNames());

        // Поиск по имени
        //System.out.println(familyTree1.getByName("Саид"));

        // Показывает детей
        // System.out.println(human04.getChildren());


    }

}
