package ru.gb.family_tree.view.descriptionFormation;

import ru.gb.family_tree.model.member.Member;
import ru.gb.family_tree.presenter.Presenter;

import java.util.List;
import java.util.Scanner;

public interface FindInfoByName {
    List<Member> FindInfoByName(Scanner scanner, Presenter presenter);
}
