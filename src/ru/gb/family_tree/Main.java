package ru.gb.family_tree;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.model.human.enums.Gender;
import ru.gb.family_tree.model.writer.FileHandler;
import ru.gb.family_tree.view.Ui;
import ru.gb.family_tree.view.console_ui.ConsoleUi;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    private static void fillTemplateData(Ui ui) { // заполнение дерева для файла template.fmt

        //0 pd1
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Анатолий", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Михайлович", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Лопатовский", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Male, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Водитель", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Поляк", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1924-01-30"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) LocalDate.parse("1972-12-05"), CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "Омская область, с. Усть-Ишим", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) null, CollectorItems.Father);
        ui.setInfoInCollector((Object) null, CollectorItems.Mother);
        ui.addHuman(true);

        //1 pb1
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Нина", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Михайловна", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Лопатовская", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Female, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Учитель", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русская", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1931-07-15"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) null, CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "Омская область, г. Омск", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) null, CollectorItems.Father);
        ui.setInfoInCollector((Object) null, CollectorItems.Mother);
        ui.addHuman(true);

        //2 pd2
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Михаил", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Тихонович", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Шевелёв", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Male, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Генерал-Майор армии", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русский", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1927-11-05"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) LocalDate.parse("1989-10-14"), CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "Ростовская обслать, г. Ростов-на-Дону", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) null, CollectorItems.Father);
        ui.setInfoInCollector((Object) null, CollectorItems.Mother);
        ui.addHuman(true);

        //3 pb2
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Раиса", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Николаевна", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Шевелёва", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Female, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Повар", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русская", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1933-09-14"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) null, CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "Ульяновская область, с. Ляховка", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) null, CollectorItems.Father);
        ui.setInfoInCollector((Object) null, CollectorItems.Mother);
        ui.addHuman(true);

        //4 pd3
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Аркадий", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Иванович", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Остяков", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Male, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Доктор наук МГУ", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русский", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1926-05-05"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) LocalDate.parse("1989-07-14"), CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Москва", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) null, CollectorItems.Father);
        ui.setInfoInCollector((Object) null, CollectorItems.Mother);
        ui.addHuman(true);

        //5 pb3
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Надежда", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Даниловна", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Остякова", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Female, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Воспитатель в детском саду", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русская", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1938-06-17"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) LocalDate.parse("1998-05-02"), CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Москва", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) null, CollectorItems.Father);
        ui.setInfoInCollector((Object) null, CollectorItems.Mother);
        ui.addHuman(true);

        //6 pd4
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Михаил", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Васильевич", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Квиткин", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Male, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Механик-водитель танка Т-34", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русский", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1921-01-03"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) LocalDate.parse("1953-09-18"), CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Ленинград", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) null, CollectorItems.Father);
        ui.setInfoInCollector((Object) null, CollectorItems.Mother);
        ui.addHuman(true);

        //7 pb4
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Елизавета", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Андреевна", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Квиткина", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Female, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Экскурсовод", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русская", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1935-10-19"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) LocalDate.parse("1993-03-04"), CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Ленинград", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) null, CollectorItems.Father);
        ui.setInfoInCollector((Object) null, CollectorItems.Mother);
        ui.addHuman(true);

        //8 d1
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Александр", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Михайлович", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Шевелёв", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Male, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Пилот", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русский", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1957-08-24"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) null, CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Москва", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) ui.getHumanById(2), CollectorItems.Father);
        ui.setInfoInCollector((Object) ui.getHumanById(3), CollectorItems.Mother);
        ui.addHuman(true);

        //9 b1
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Ольга", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Анатольевна", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Шевелёва (Лопатовская)", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Female, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Преподаватель", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русская", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1955-04-01"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) null, CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "Омская область, г. Омск", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) ui.getHumanById(0), CollectorItems.Father);
        ui.setInfoInCollector((Object) ui.getHumanById(1), CollectorItems.Mother);
        ui.addHuman(true);

        //10 d2
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Владимир", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Аркадьевич", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Остяков", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Male, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Спортсмен", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русский", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1949-11-30"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) LocalDate.parse("1990-07-02"), CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Москва", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) ui.getHumanById(4), CollectorItems.Father);
        ui.setInfoInCollector((Object) ui.getHumanById(5), CollectorItems.Mother);
        ui.addHuman(true);

        //11 b2
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Галина", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Михайловна", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Остякова (Квиткина)", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Female, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Инженер", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русская", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1948-03-08"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) null, CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Ленинград", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) ui.getHumanById(6), CollectorItems.Father);
        ui.setInfoInCollector((Object) ui.getHumanById(7), CollectorItems.Mother);
        ui.addHuman(true);

        //12 fatherAms
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Михаил", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Александрович", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Шевелёв", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Male, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Системный администратор", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русский", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1981-08-21"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) null, CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Москва", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) ui.getHumanById(8), CollectorItems.Father);
        ui.setInfoInCollector((Object) ui.getHumanById(9), CollectorItems.Mother);
        ui.addHuman(true);

        //13 motherAms
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Елена", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Владимировна", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Шевелёва (Остякова)", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Female, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Инженер", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русская", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("1979-01-24"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) null, CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Ленинград", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) ui.getHumanById(10), CollectorItems.Father);
        ui.setInfoInCollector((Object) ui.getHumanById(11), CollectorItems.Mother);
        ui.addHuman(true);

        //14 ams
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Алексей", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Михайлович", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Шевелёв", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Male, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Тестировщик", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русский", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("2000-02-17"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) null, CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Москва", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) ui.getHumanById(12), CollectorItems.Father);
        ui.setInfoInCollector((Object) ui.getHumanById(13), CollectorItems.Mother);
        ui.addHuman(true);

        //15 sams
        ui.initNewCollector();
        ui.setInfoInCollector((Object) "Алена", CollectorItems.Name);
        ui.setInfoInCollector((Object) "Михайловна", CollectorItems.Patronymic);
        ui.setInfoInCollector((Object) "Шевелёва", CollectorItems.Surname);
        ui.setInfoInCollector((Object) Gender.Female, CollectorItems.Gender);
        ui.setInfoInCollector((Object) "Студент", CollectorItems.Profession);
        ui.setInfoInCollector((Object) "Русская", CollectorItems.Nationality);
        ui.setInfoInCollector((Object) LocalDate.parse("2006-07-16"), CollectorItems.DateOfBirth);
        ui.setInfoInCollector((Object) null, CollectorItems.DateOfDeath);
        ui.setInfoInCollector((Object) "г. Москва", CollectorItems.BirthPlace);
        ui.setInfoInCollector((Object) ui.getHumanById(12), CollectorItems.Father);
        ui.setInfoInCollector((Object) ui.getHumanById(13), CollectorItems.Mother);
        ui.addHuman(true);

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Ui ui = new ConsoleUi(new FileHandler());
//        fillTemplateData(ui);
        ui.startUi();



        //Дерево для примера в файле templateData.fmt
    }
}