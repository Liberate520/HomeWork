import Persons.Gender;
import Persons.Person;
import PersonsTree.FamilyTree;


public class Main {
    public static void main(String[] args) throws Exception{
        FamilyTree familyTree = new FamilyTree("Михайловы");
        //семья из 5ти человек
        Person person1 = new Person("Михайлова Полина Мирона", Gender.female, "2000-01-03");
        Person person2 = new Person("Михайлов Мирон Игоревич", Gender.male, "1970-05-28");
        Person person3 = new Person("Петровская Ксения Егоровна", Gender.female, "1976-11-11");
        Person person4 = new Person("Куприянова Варвара Кирилловна", Gender.female, "1950-12-30", "2001-05-09");
        Person person5 = new Person("Петровский Егор Павлович", Gender.male, "1958-08-21","1999-01-05");

        //добавляем связи
        person1.addParent(person2);
        person1.addParent(person3);
        person3.addParent(person4);
        person3.addParent(person5);

        person5.addChildren(person3);
        person4.addChildren(person3);
        person3.addChildren(person1);
        person2.addChildren(person1);

        //добавляем в генелогическое дерево
        familyTree.addPers(person1);
        familyTree.addPers(person2);
        familyTree.addPers(person3);
        familyTree.addPers(person4);
        familyTree.addPers(person5);

        //сохраним резульат
        //FileHandler.save();
        //смотрим итог
        System.out.println(familyTree.getAllFamily());
        System.out.println("\n\nПоиск точечных совпадений: " + familyTree.getFullPerson("Петровский Егор Павлович"));
        System.out.println("\n\nПоиск по фамилии: " + familyTree.getPersonOnSurname("Михайлов"));

    }
}