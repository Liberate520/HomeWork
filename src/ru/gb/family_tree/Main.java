package ru.gb.family_tree;

import ru.gb.family_tree.human.enums.Gender;
import ru.gb.family_tree.service.Service;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    private static Service autoFillFamTree() { // первоначальное заполнение дерева
        Service service = new Service();
        //0 pd1
        service.addHuman("Анатолий", "Михайлович", "Лопатовский", Gender.Male,
                null, null, null, "Водитель", "Поляк",
                LocalDate.parse("1924-01-30"), LocalDate.parse("1972-12-05"),
                "Омская область, с. Усть-Ишим", null);
        //1 pb1
        service.addHuman("Нина", "Михайловна", "Лопатовская", Gender.Female,
                null, null, null, "Учитель", "Русская", LocalDate.parse("1931-07-15"),
                null, "Омская область, г. Омск", null);
        //2 pd2
        service.addHuman("Михаил", "Тихонович", "Шевелёв", Gender.Male,
                null, null, null, "Генерал-Майор армии", "Русский",
                LocalDate.parse("1927-11-05"), LocalDate.parse("1989-10-14"),
                "Ростовская обслать, г. Ростов-на-Дону", null);
        //3 pb2
        service.addHuman("Раиса", "Николаевна", "Шевелёва", Gender.Female,
                null, null, null, "Повар", "Русская",
                LocalDate.parse("1933-09-14"), null, "Ульяновская область, с. Ляховка", null);
        //4 pd3
        service.addHuman("Аркадий", "Иванович", "Остяков", Gender.Male,
                null, null, null, "Доктор наук МГУ", "Русский",
                LocalDate.parse("1926-05-05"), LocalDate.parse("1989-07-14"),
                "г. Москва", null);
        //5 pb3
        service.addHuman("Надежда", "Даниловна", "Остякова", Gender.Female,
                null, null, null, "Воспитатель в детском саду", "Русская",
                LocalDate.parse("1938-06-17"), LocalDate.parse("1998-05-02"),
                "г. Москва", null);
        //6 pd4
        service.addHuman("Михаил", "Васильевич", "Квиткин", Gender.Male,
                null, null, null, "Механик-водитель танка Т-34", "Русский",
                LocalDate.parse("1921-01-03"), LocalDate.parse("1953-09-18"),
                "г. Ленинград", null);
        //7 pb4
        service.addHuman("Елизавета", "Андреевна", "Квиткина", Gender.Female,
                null, null, null, "Экскурсовод", "Русская",
                LocalDate.parse("1935-10-19"), LocalDate.parse("1993-03-04"),
                "г. Ленинград", null);
        //8 d1
        service.addHuman("Александр", "Михайлович", "Шевелёв", Gender.Male,
                service.getHumanById(2), service.getHumanById(3), null,
                "Пилот", "Русский", LocalDate.parse("1957-08-24"), null,
                "г. Москва", null);
        //9 b1
        service.addHuman("Ольга", "Анатольевна", "Шевелёва (Лопатовская)",
                Gender.Female, service.getHumanById(0), service.getHumanById(1), null,
                "Преподаватель", "Русская", LocalDate.parse("1955-04-01"),
                null, "Омская область, г. Омск", null);
        //10 d2
        service.addHuman("Владимир", "Аркадьевич", "Остяков", Gender.Male,
                service.getHumanById(4), service.getHumanById(5), null, "Спортсмен",
                "Русский", LocalDate.parse("1949-11-30"), LocalDate.parse("1990-07-02"),
                "г. Москва", null);
        //11 b2
        service.addHuman("Галина", "Михайловна", "Остякова (Квиткина)", Gender.Female,
                service.getHumanById(6), service.getHumanById(7), null, "Инженер",
                "Русская", LocalDate.parse("1948-03-08"), null,
                "г. Ленинград", null);
        //12 fatherAms
        service.addHuman("Михаил", "Александрович", "Шевелёв", Gender.Male,
                service.getHumanById(8), service.getHumanById(9), null, "Системный администратор",
                "Русский", LocalDate.parse("1981-08-21"), null,
                "г. Москва", null);
        //13 motherAms
        service.addHuman("Елена", "Владимировна", "Шевелёва (Остякова)", Gender.Female,
                service.getHumanById(10), service.getHumanById(11), null, "Инженер",
                "Русская", LocalDate.parse("1979-01-24"), null,
                "г. Ленинград", null);
        //14 ams
        service.addHuman("Алексей", "Михайлович", "Шевелёв", Gender.Male,
                service.getHumanById(12), service.getHumanById(13), null, "Тестировщик",
                "Русский", LocalDate.parse("2000-02-17"), null,
                "г. Москва", null);
        //15 sams
        service.addHuman("Алена", "Михайловна", "Шевелёва", Gender.Female,
                service.getHumanById(12), service.getHumanById(13), null, "Студент",
                "Русская", LocalDate.parse("2006-07-16"), null,
                "г. Москва", null);

        service.setFamilyTies();

        return service;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Service service = autoFillFamTree();

//        Writer fh = new FileHandler();
//        fh.saveObject((Object) service, "service"); // Сохраняем Service с деревом в файл service.out

//        Service service = (Service) fh.readObject("service"); // Читаем Service с деревом из файла service.out

        service.sortByName(); // сортировка по имени
//        service.sortByAge(); // сортировка по возрасту
//        service.sortByBirthday(); // сортировка по дате рождения
        service.sortById(); //сортировка по id
        System.out.println(service.getfamilyTreeInfo());

//        String request = "Алексей Шевелёв"; // строка запроса для поиска
//        System.out.println("Результат поиска: ");
//        List<Human> searchResult = service.searchHuman(request); //результат поиска по запросу, если ничего не найдено возвращает null
//        System.out.println(searchResult);


    }
}