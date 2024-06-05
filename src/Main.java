import FileHandlerFilse.FileHandler;
import Persons.Enums.Gender;
import Persons.Person;
import PersonsTree.FamilyTree;


public class Main {
    public static void main(String[] args) throws Exception{
        //место хранения данных

        Service service = new Service();

        ////семья из 5ти человек
        service.addPerson("Михайлова Полина Мирона", Gender.female, "2000-01-03");
        service.addPerson("Михайлов Мирон Игоревич", Gender.male, "1970-05-28");
        service.addPerson("Петровская Ксения Егоровна", Gender.female, "1976-11-11");
        service.addPerson("Куприянова Варвара Кирилловна", Gender.female, "1950-12-30", "2001-05-09");
        service.addPerson("Петровский Егор Павлович", Gender.male, "1958-08-21","1999-01-05");
        ////добавляем связи
        service.addParent("Михайлова Полина Мирона","Михайлов Мирон Игоревич");
        service.addParent("Михайлова Полина Мирона","Петровская Ксения Егоровна");
        service.addParent("Петровская Ксения Егоровна","Куприянова Варвара Кирилловна");
        service.addParent("Петровская Ксения Егоровна","Петровский Егор Павлович");

        service.addChield("Петровский Егор Павлович", "Петровская Ксения Егоровна");
        service.addChield("Куприянова Варвара Кирилловна", "Петровская Ксения Егоровна");
        service.addChield("Петровская Ксения Егоровна", "Михайлова Полина Мирона");
        service.addChield("Михайлов Мирон Игоревич", "Михайлова Полина Мирона");


        ////смотрим итог
        service.getAllFamily();
        service.getFullPerson("Михайлов");
        service.getPersonOnSurname("Петровский Егор Павлович");
        //вывод при помощи Итератора
        service.getFullFamily();
        //вывод после сортировок
        service.sortedByName();
        service.sortByBirthday();
        System.out.println("ок");
    }
}