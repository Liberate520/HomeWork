package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Main {

    private static FamilyTree autoFillFamTree() { // первоначальное заполнение дерева
        FamilyTree ft = new FamilyTree();
        Human pd1 = new Human("Анатолий", "Михайлович", "Лопатовский", Gender.Male);
        Human pb1 = new Human("Нина", "Михайловна", "Лопатовская", Gender.Female);
        Human pd2 = new Human("Михаил", "Тихонович", "Шевелёв", Gender.Male);
        Human pb2 = new Human("Раиса", "Николаевна", "Шевелёва", Gender.Female);
        Human pd3 = new Human("Аркадий", "Иванович", "Остяков", Gender.Male);
        Human pb3 = new Human("Надежда", "Даниловна", "Остякова", Gender.Female);
        Human pd4 = new Human("Михаил", "Васильевич", "Квиткин", Gender.Male);
        Human pb4 = new Human("Елизавета", "Андреевна", "Квиткина", Gender.Female);
        Human d1 = new Human("Александр", "Михайлович", "Шевелёв", Gender.Male);
        Human b1 = new Human("Ольга", "Анатольевна", "Шевелёва (Лопатовская)", Gender.Female);
        Human d2 = new Human("Владимир", "Аркадьевич", "Остяков", Gender.Male);
        Human b2 = new Human("Галина", "Михайловна", "Остякова (Квиткина)", Gender.Female);
        Human fatherAms = new Human("Михаил", "Александрович", "Шевелёв", Gender.Male);
        Human motherAms = new Human("Елена", "Владимировна", "Шевелёва (Остякова)", Gender.Female);
        Human ams = new Human("Алексей", "Михайлович", "Шевелёв", Gender.Male);
        Human sams = new Human("Алена", "Михайловна", "Шевелёва", Gender.Female);

        pd1.setDob(LocalDate.parse("1924-01-30"));
        pd1.setDod(LocalDate.parse("1972-12-05"));
        pd1.setProfession("Водитель");
        pd1.setBirthPlace("Омская область, с. Усть-Ишим");
        pd1.setNationality("Поляк");
        pd1.setChildren(b1);

        pb1.setDob(LocalDate.parse("1931-07-15"));
        pb1.setProfession("Учитель");
        pb1.setBirthPlace("Омская область, г. Омск");
        pb1.setNationality("Русская");
        pb1.setChildren(b1);

        pd2.setDob(LocalDate.parse("1926-05-05"));
        pd2.setDod(LocalDate.parse("1989-10-14"));
        pd2.setProfession("Генерал-Майор армии");
        pd2.setBirthPlace("Ростовская обслать, г. Ростов-на-Дону");
        pd2.setNationality("Русский");
        pd2.setChildren(d1);

        pb2.setDob(LocalDate.parse("1933-09-14"));
        pb2.setProfession("Повар");
        pb2.setBirthPlace("Ульяновская область, с. Ляховка");
        pb2.setNationality("Русская");
        pb2.setChildren(d1);

        pd3.setDob(LocalDate.parse("1926-05-05"));
        pd3.setDod(LocalDate.parse("1989-07-14"));
        pd3.setProfession("Доктор наук МГУ");
        pd3.setBirthPlace("г. Москва");
        pd3.setNationality("Русский");
        pd3.setChildren(d2);

        pb3.setDob(LocalDate.parse("1938-06-17"));
        pb3.setDod(LocalDate.parse("1998-05-02"));
        pb3.setProfession("Воспитатель в детском саду");
        pb3.setBirthPlace("г. Москва");
        pb3.setNationality("Русская");
        pb3.setChildren(d2);

        pd4.setDob(LocalDate.parse("1921-01-03"));
        pd4.setDod(LocalDate.parse("1953-09-18"));
        pd4.setProfession("Механик-водитель танка Т-34");
        pd4.setBirthPlace("г. Ленинград");
        pd4.setNationality("Русский");
        pd4.setChildren(b2);

        pb4.setDob(LocalDate.parse("1935-10-19"));
        pb4.setDod(LocalDate.parse("1993-03-04"));
        pb4.setProfession("Экскурсовод");
        pb4.setBirthPlace("г. Ленинград");
        pb4.setNationality("Русская");
        pb4.setChildren(b2);

        b1.setDob(LocalDate.parse("1955-04-01"));
        b1.setProfession("Преподаватель");
        b1.setBirthPlace("Омская область, г. Омск");
        b1.setNationality("Русская");
        b1.setChildren(fatherAms);

        d1.setDob(LocalDate.parse("1957-08-24"));
        d1.setProfession("Пилот");
        d1.setBirthPlace("г. Москва");
        d1.setNationality("Русский");
        d1.setChildren(fatherAms);

        d2.setDob(LocalDate.parse("1949-11-30"));
        d2.setDod(LocalDate.parse("1990-07-02"));
        d2.setProfession("Спортсмен");
        d2.setBirthPlace("г. Москва");
        d2.setNationality("Русский");
        d2.setChildren(motherAms);

        b2.setDob(LocalDate.parse("1948-03-08"));
        b2.setProfession("Инженер");
        b2.setBirthPlace("г. Ленинград");
        b2.setNationality("Русская");
        b2.setChildren(motherAms);

        motherAms.setDob(LocalDate.parse("1979-01-24"));
        motherAms.setProfession("Инженер");
        motherAms.setBirthPlace("г. Ленинград");
        motherAms.setNationality("Русская");
        motherAms.setChildren(ams, sams);

        fatherAms.setDob(LocalDate.parse("1981-08-21"));
        fatherAms.setProfession("Системный администратор");
        fatherAms.setBirthPlace("г. Москва");
        fatherAms.setNationality("Русский");
        fatherAms.setChildren(ams, sams);

        ams.setDob(LocalDate.parse("2000-02-17"));
        ams.setProfession("Тестировщик");
        ams.setBirthPlace("г. Москва");
        ams.setNationality("Русский");

        sams.setDob(LocalDate.parse("2006-07-16"));
        sams.setProfession("Студент");
        sams.setBirthPlace("г. Москва");
        sams.setNationality("Русский");

        ft.addHumans(pd1, pb1, pd2, pb2, pd3, pb3, pd4, pb4, d1, b1, d2, b2, fatherAms, motherAms, ams, sams);
        return ft;
    }

    public static void main(String[] args) {
        FamilyTree famTree = autoFillFamTree();
        famTree.setParentsByChildren(); // заполняет поля mother и father у детей если они есть в списке
        String request = "Алексей Шевелёв"; // строка запроса для поиска
        System.out.println("Результат поиска: ");
        List<Human> searchResult = famTree.searchHuman(request); //результат поиска по запросу, если ничего не найдено возвращает null
        System.out.println(searchResult);
        Human alMihSh = searchResult.get(0); //Для простоты возьмем Алексея Шевелева из результатов поиска
//        System.out.println(famTree.showParents(alMihSh)); //Выводит родителей в виде строки
        List<Human> parents = famTree.getParents(alMihSh); // Можно вывести в список
//        System.out.println(parents);
        List<Human> grandMothers = famTree.getGrandMothers(alMihSh); //Можно вывести бабушек
//        System.out.println(grandMothers);
        List<Human> grandFathers = famTree.getGrandFathers(alMihSh); // Или дедушек
//        System.out.println(grandFathers);
    }
}