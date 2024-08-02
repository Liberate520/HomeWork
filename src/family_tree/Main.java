package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.enum_for_human.Gender;
import family_tree.service.Service;
import family_tree.writer.FileHandler;


import java.time.LocalDate;

public class Main {
   public static void main(String[] args){
       /*
       //Создаем дерево и записываем в файл
       Service service = firstTree();
       saveTree(service);
       */

       //Прочесть файл
       Service service = readTree();

       //Сортировка по ФИО
       service.sortByName();

       //Сортировка по дате рождения
       service.sortByBirthday();

       //Выборка человека по ID
       System.out.println(service.getById(0));

       //Отображение всего дерева
       System.out.println(service.getFamilyTreeInfo());

   }

    public static Service readTree(){
        FileHandler fileHandler = new FileHandler();
        return (Service)  fileHandler.read();
    }

    public static void saveTree(Service tree)   {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

   private static Service firstTree(){
       Service service = new Service();
       service.addHuman("Андрей", "Смит","Павлович",Gender.Male, LocalDate.of(1974,4,17));
       service.addHuman("Алена","Смит","Борисовна", Gender.Female, LocalDate.of(1974,4,1));
       service.addHuman("Михаил","Смит","Андреевич", Gender.Male, LocalDate.of(2008,8,14),null,service.getById(0),service.getById(1));
       service.addHuman("Виталий","Смит","Андреевич", Gender.Male, LocalDate.of(2004,1,12),null,service.getById(0),service.getById(1));
       return service;
   }
}
