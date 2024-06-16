
package com.familytree.view;

import com.familytree.model.human.Human;

public class ConsoleView implements View {
    @Override
    public void displayNodes(Human[] nodes) {
        for (Human node : nodes) {
            System.out.println("ID: " + node.getId() + ", Name: " + node.getName() + ", BirthDate: " + node.getBirthDate());
        }
    }
}
