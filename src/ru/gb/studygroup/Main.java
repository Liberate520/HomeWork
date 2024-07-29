package ru.gb.studygroup;

import ru.gb.studygroup.model.service.Service;
import ru.gb.studygroup.view.ConsoleUI;
import ru.gb.studygroup.view.View;

public class Main {
    public static void main(String[] args) {

//        Service service = new Service();
//        service.addStudent("Вася", 21);
//        service.addStudent("Олег", 20);
//        service.addStudent("Вика", 22);
//        service.addStudent("Шура", 19);
//        System.out.println(service.getListOfStudents());
//        service.sortByName();
//        System.out.println(service.getListOfStudents());
//        service.sortByAge();
//        System.out.println(service.getListOfStudents());

        View view = new ConsoleUI();
        view.start();
    }
}
