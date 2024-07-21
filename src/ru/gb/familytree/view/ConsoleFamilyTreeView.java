package ru.gb.familytree.view;

import ru.gb.familytree.model.HumanInfo;

import java.util.List;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    @Override
    public void showFamilyTree(List<HumanInfo> members) {
        System.out.println("\nFamily Tree:");
        for (HumanInfo member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void showError(String message) {
        System.err.println("Error: " + message);
    }

    @Override
    public void showSuccess(String message) {
        System.out.println("Success: " + message);
    }
}