package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyMembers = new ArrayList<>();
    String title;

    public FamilyTree(String title) {
        this.title = title;
    }

    public void addMember(Human member) {
        familyMembers.add(member);
        System.out.printf("Член семьи %s успешно добавлен в семейное дерево %s;\n", member.name, this.title);
    }

    public StringBuilder getFamilyInfo() {
        StringBuilder family = new StringBuilder();
        family.append("Семья ").append(this.title).append(" состоит из ").append(familyMembers.size()).append(" членов семьи и включает:\n");
        for (Human mamber: familyMembers) family.append(mamber.name).append("\n");
        return family;

    }
}
