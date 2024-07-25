import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.SpouseStatus;

import java.time.LocalDate;

public class Main {
    /**
     * Главный метод программы, демонстрирующий использование классов FamilyTree и Human.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Создание объектов Human
        Human human1 = new Human("Ермолов Вадим Викторович", Gender.male, LocalDate.of(1981, 5, 29));
        Human human2 = new Human("Ермолова Нурия Айдаровна", Gender.female, LocalDate.of(1981, 3, 17));
        Human human3 = new Human("Ермолов Виктор Семенович", Gender.male, LocalDate.of(1958, 6, 3));
        Human human4 = new Human("Ермолова Залия Мухаматсакиевна", Gender.female, LocalDate.of(1960, 3, 18));
        Human human5 = new Human("Абдррахманов Айдар Хабибуллович", Gender.male, LocalDate.of(1960, 12, 1));
        Human human6 = new Human("Абдрахманова Фарида Кинягалиевна", Gender.female, LocalDate.of(1960, 12, 26), LocalDate.of(2007, 4, 15));

        // Печать имен
        human1.PrintName();

        // Печать дат рождения
        human3.PrintDob();

        // Печать дат смерти
        human5.PrintDod();
        human6.PrintDod();

        // Печать пола
        human1.PrintGender();
        human2.PrintGender();

        // Печать возраста
        human1.PrintAge();

        // Печать информации о матери
        human1.PrintMother();
        human2.PrintMother();

        // Печать информации об отце
        human1.PrintFather();
        human2.PrintFather();

        human1.setFather(human3);
        human1.PrintFather();

        human1.setMother(human4);
        human1.PrintMother();

        human2.setFather(human5);
        human2.PrintFather();

        human2.setMother(human6);
        human2.PrintMother();

        System.out.println("--------");

        // Печать и добавление детей
        human3.addChild(human1);
        human3.PrintChildren();

        human4.addChild(human1);
        human4.PrintChildren();

        System.out.println("--------");

        // Печать и добавление супругов

        human1.addSpouse(human2, SpouseStatus.Actual);
        human1.PrintSpouses();

        human2.addSpouse(human1, SpouseStatus.Actual);
        human2.PrintSpouses();

        human3.addSpouse(human4, SpouseStatus.Actual);
        human3.PrintSpouses();

        human4.addSpouse(human3, SpouseStatus.Actual);
        human4.PrintSpouses();

        human5.addSpouse(human6, SpouseStatus.Actual);
        human5.PrintSpouses();

        human6.addSpouse(human5, SpouseStatus.Actual);
        human6.PrintSpouses();

        System.out.println("--------");

        // Печать информации о людях
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(human4);
        System.out.println(human5);
        System.out.println(human6);

        System.out.println("--------");

        // Добавление людей в семейное древо
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);

        human1.PrintId();

        System.out.println("--------");

        // Поиск людей по ID
        familyTree.findById(0);
        familyTree.findById(3);

        System.out.println("--------");

        // Поиск людей по имени
        familyTree.findByName("Ермолов Вадим Викторович");

        System.out.println("--------");

        // Печать информации о семейном древе
        System.out.println(familyTree);
    }
}