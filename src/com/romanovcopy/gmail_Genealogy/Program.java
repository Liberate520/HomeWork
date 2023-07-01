package com.romanovcopy.gmail_Genealogy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {
        GenealogyGraph graph = new GenealogyGraph();
        selectMode(graph);
//
//        // Добавление людей в граф
//        graph.addPerson("John");
//        graph.addPerson("Mary");
//        graph.addPerson("Peter");
//
//        // Установление родительской связи
//        graph.addParentChildRelationship("John", "Peter");
//        graph.addParentChildRelationship("Mary", "Peter");
//
//        // Получение родителей и детей
//        List<Person> johnsParents = graph.getParents("John");
//        List<Person> marysChildren = graph.getChildren("Mary");
//
//        System.out.println("John's parents: " + johnsParents);
//        System.out.println("Mary's children: " + marysChildren);

    }

    private static void selectMode(GenealogyGraph graph) {
        boolean flag = true;
        int mode = 0;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Выберите режим работы : ");
            System.out.println("1 - Новый граф.");
            System.out.println("2 - Редактировать граф.");
            System.out.println("3 - Просмотр графа.");
            System.out.println("4 - Удалить граф.");
            System.out.println("0 - Выход");
            System.out.println("Введите номер режима : ");
            if (scanner.hasNextInt()) {
                mode = Math.abs(scanner.nextInt());
                flag = mode != 0;
                if (flag) {
                    switch (mode) {
                        case 1: {
                            System.out.println("Новый граф");
                            var person=createPerson(scanner);
                            if(person!=null){
                                graph.addPerson(person);
                            }
                            break;
                        }
                        case 2: {
                            personEditing(scanner, graph);
                            break;
                        }
                        case 3: {
                            System.out.println("Просмотр графа");

                            break;
                        }
                        case 4: {
                            System.out.println("Удаление графа");

                            break;
                        }
                        default: {
                            System.out.println("Неизвестный выбор.\nПовторите ввод.");
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    /**
     * Создание нового персонажа
     * @param scanner поток чтения с консоли
     * @return новый персонаж
     */
    private static Person createPerson(Scanner scanner) {
        boolean flag=true;
        Person person = null;
        String surName = null;
        while (flag){
            surName = requestString(scanner,"Фамилия : ", false);
            flag=surName==null||surName.length()==0;
        }
        String name = null;
        flag=true;
        while (flag){
            name = requestString(scanner,"Имя : ", false);
            flag=name==null||name.length()==0;
        }
        String patronymic = requestString(scanner,"Отчество (если есть) : ", false);
        Gender gender=null;
        flag=true;
        while (flag){
            String temp=requestString(scanner,"Выберите пол : (MALE,FEMALE) ",false);
            // Преобразуем введенную строку в Enum-значение
            try {
                gender = Gender.valueOf(temp.toUpperCase());
                System.out.println("Выбранный пол: " + gender);
                flag=false;
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректное значение.");
            }
        }
        MaritalStatus maritalStatus=null;
        String text="Выберите семейное положение : ( SINGLE, MARRIED, DIVORCED, WIDOWED ) ";
        flag=true;
        while (flag){
            String temp=requestString(scanner,text,false);
            // Преобразуем введенную строку в Enum-значение
            try {
                maritalStatus = MaritalStatus.valueOf(temp.toUpperCase());
                System.out.println("Выбрано семейное положение: " + maritalStatus);
                flag=false;
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректное значение.");
            }
        }
        LocalDate birthDay=null;
        flag=true;
        while (flag){
            birthDay=requestDate(scanner,"Дата рождения в формате дд.мм.гггг :", false);
            flag=birthDay==null;
        }
        person=new Person(name, surName, patronymic,birthDay,gender,maritalStatus);
        return person;
    }

    private static Person personEditing(Scanner scanner, GenealogyGraph graph){
        Person person=null;
        System.out.println("Редактировать граф");
        System.out.print("Что известно ? \n 1 Фамилия \n 2 Фамилия Имя \n 3 Фамилия Имя Отчество \n");
        int select = requestInt(scanner,"Вид поиска : ", false);
        if(select==1){
            var surname=requestString(scanner,"Фамилия : ", false);
            var list = graph.search(surname);
            printPersons(list);
        } else if (select==2) {
            var surname=requestString(scanner,"Фамилия : ", false);
            var name=requestString(scanner,"Имя : ", false);
            var list = graph.search(surname,name);
            printPersons(list);
        } else if (select==3) {
            var surname=requestString(scanner,"Фамилия : ", false);
            var name=requestString(scanner,"Имя : ", false);
            var patronymic=requestString(scanner,"Отчество : ", false);
            var list = graph.search(surname,name,patronymic);
            printPersons(list);
        }else {

        }
        return person;
    }

    /**
     * получение ввода в виде строки
     * @param scanner поток доступа к консоли
     * @param text текст запроса
     * @param neeLine переход на новую строку после текста запроса
     * @return строка введенная пользователем
     */
    private static String requestString(Scanner scanner, String text, boolean newLine) {
        newLine(text, newLine);
        String result=null;
        if (scanner.hasNext()) {
            result= scanner.next();}
        return result;
    }

    /**
     * получение ввода в виде целого числа
     * @param scanner поток доступа к консоли
     * @param text текст запроса
     * @param neeLine переход на новую строку после текста запроса
     * @return число введенное пользователем
     */
    private static int requestInt(Scanner scanner, String text, boolean newLine) {
        newLine(text, newLine);
        int result = 0;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt();}
        return result;
    }

    /**
     * получение ввода в виде даты (LocalDate)
     * @param scanner поток доступа к консоли
     * @param text текст запроса
     * @param neeLine переход на новую строку после текста запроса
     * @return дата введенная пользователем
     */
    private static LocalDate requestDate(Scanner scanner, String text, boolean newLine){
        newLine(text, newLine);
        // Устанавливаем формат даты, который ожидаем от пользователя
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String birthDay=scanner.next();
        try {
            // Преобразовываем введенную строку в объект LocalDate с использованием заданного формата
            LocalDate date = LocalDate.parse(birthDay, dateFormatter);
            return date;
        } catch (Exception e) {
            System.out.println("Некорректный формат даты.");
            return null;
        }
    }

    private static void printPersons(ArrayList<Person>list){
        for(var pers:list){
            System.out.printf("%d %s", list.indexOf(pers)+1,pers.toString());
        }
    }

    /**
     * вывод текста
     * @param text текст
     * @param newLine перевод на новую строку в конце строки
     */
    private static void newLine(String text, boolean newLine){
        if(newLine){
            System.out.println(text);
        }else {
            System.out.print(text);
        }
    }

}
