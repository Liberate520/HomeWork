package ru.gb.family_tree.view.descriptionFormation;

import ru.gb.family_tree.model.member.Gender;
import ru.gb.family_tree.model.member.Member;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AddMember implements AddMemberHandler{
    public void addMember(Scanner scanner, Presenter presenter){
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите имя матери или null: ");
        Member mother = presenter.findMember(scanner.nextLine());
        System.out.print("Введите имя отца или null: ");
        Member father = presenter.findMember(scanner.nextLine());
        System.out.print("Введите дату рождения год/месяц/дата или null: ");
        LocalDate birthDate = checkdate(scanner.nextLine());
        System.out.print("Введите дату смерти год/месяц/дата или null: ");
        LocalDate deathDate = checkdate(scanner.nextLine());
        System.out.print("Введите пол M / F ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        presenter.addMember(name, mother, father, birthDate, deathDate, gender);
    }
    public LocalDate checkdate(String sdate){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(sdate, formatter);
            return date;
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: неверный формат даты.");
        }
        return null;
    }
}
