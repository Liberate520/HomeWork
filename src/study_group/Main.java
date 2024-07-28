package study_group;

import study_group.service.Service;

public class Main {
    public static void  main(String[] args){
        Service service = new Service();
        service.addStudent("Виталий", 18);
        service.addStudent("Андрей", 19);
        service.addStudent("Алева", 17);
        service.addStudent("Петр", 18);
        System.out.println(service.getStudentsListInfo());
        service.sortByName();
        System.out.println(service.getStudentsListInfo());
        service.sortByAge();
        System.out.println(service.getStudentsListInfo());
    }
}
