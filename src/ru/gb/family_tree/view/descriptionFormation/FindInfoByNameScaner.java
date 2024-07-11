package ru.gb.family_tree.view.descriptionFormation;

import ru.gb.family_tree.model.member.Member;
import ru.gb.family_tree.presenter.Presenter;

import java.util.List;
import java.util.Scanner;

public class FindInfoByNameScaner implements FindInfoByName {
    public List<Member> FindInfoByName(Scanner scanner, Presenter presenter) {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();
        return presenter.findAllInfoByName(name);
    }
}
