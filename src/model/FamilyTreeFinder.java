package model;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeFinder {

    private FamilyTree<? extends FamilyMember> familyTree;

    public FamilyTreeFinder(FamilyTree<? extends FamilyMember> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyMember findByName(String name) {
        for (FamilyMember member : familyTree) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public String findByNameStr(String name) {
        FamilyMember member = findByName(name);
        if (member != null) {
            return member.toString();
        } else {
            return "Член семьи с именем " + name + " не найден.";
        }
    }

    public List<FamilyMember> findByBirthYear(int year) {
        List<FamilyMember> result = new ArrayList<>();
        for (FamilyMember member : familyTree) {
            if (member.getBirthDate().getYear() == year) {
                result.add(member);
            }
        }
        return result;
    }

    public String findByBirthYearStr(int year) {
        List<FamilyMember> members = findByBirthYear(year);
        if (members.isEmpty()) {
            return "Члены семьи, родившиеся в " + year + " году не найдены.";
        } else {
            StringBuilder result = new StringBuilder("Члены семьи, родившиеся в " + year + " году:\n");
            for (FamilyMember member : members) {
                result.append(member).append("\n");
            }
            return result.toString();
        }
    }

}
