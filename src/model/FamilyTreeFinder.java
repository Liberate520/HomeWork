package model;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeFinder<T extends FamilyMember<T>> {
    private FamilyTree<T> familyTree;

    public FamilyTreeFinder(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public void setFamilyTree(FamilyTree<? extends FamilyMember> familyTree) {
        this.familyTree = (FamilyTree<T>) familyTree;
    }

    public T findByName(String name) {
        for (T member : familyTree) {
            if (!member.getName().equalsIgnoreCase(name)) {
                continue;
            }
            return member;
        }
        return null;
    }

    public String findByNameStr(String name) {
        T member = findByName(name);
        if (member != null) {
            return member.toString();
        } else {
            return "Член семьи с именем " + name + " не найден.";
        }
    }

    public List<T> findByBirthYear(int year) {
        List<T> result = new ArrayList<>();
        for (T member : familyTree) {
            if (member.getBirthDate().getYear() == year) {
                result.add(member);
            }
        }
        return result;
    }

    public String findByBirthYearStr(int year) {
        List<T> members = findByBirthYear(year);
        if (members.isEmpty()) {
            return "Члены семьи, родившиеся в " + year + " году не найдены.";
        } else {
            StringBuilder result = new StringBuilder("Члены семьи, родившиеся в " + year + " году:\n");
            for (T member : members) {
                result.append(member).append("\n");
            }
            return result.toString();
        }
    }
}
