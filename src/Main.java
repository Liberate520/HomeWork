import Organisms.Mammals.Persons.Enums.Gender;


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
        System.out.println("\n\n -----------------Работает-----getAllFamily---------- \n\n\n");
        service.getAllFamily();
        System.out.println("\n\n -----------------Работает-----getFullPerson---------- \n\n\n");
        service.getFullPerson("Михайлов");
        System.out.println("\n\n -----------------Работает-----getPersonOnSurname---------- \n\n\n");
        service.getPersonOnSurname("Петровский Егор Павлович");
        //вывод при помощи Итератора
        System.out.println("\n\n -----------------Работает-----getFullFamily---------- \n\n\n");
        service.getFullFamily();
        //вывод после сортировок
        System.out.println("\n\n -----------------Работает-----sortedByName---------- \n\n\n");
        service.sortedByName();
        System.out.println("\n\n -----------------Работает-----sortByBirthday---------- \n\n\n");
        service.sortByBirthday();
    }
}