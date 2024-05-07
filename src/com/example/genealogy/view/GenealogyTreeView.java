package com.example.genealogy.view;

import java.util.List;

import com.example.genealogy.model.Person;

public class GenealogyTreeView {

    public void displayData(List<Person> people) {
        System.out.println("Данные загружены:");
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }

    public void displaySortedByName(List<Person> people) {
        System.out.println("Отсортированный по имени список:");
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }

    public void displaySortedByDateOfBirth(List<Person> people) {
        System.out.println("Отсортированный по дате рождения список:");
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }

}
