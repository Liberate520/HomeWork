package service;

import model.*;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreeServiceImpl implements FamilyTreeService {
    private FamilyTree<Human> familyTree;
    private FamilyTreeFinder familyTreeFinder;
    private FamilyTreeSorter familyTreeSorter;

    public FamilyTreeServiceImpl() {
        this.familyTree = new FamilyTree<>();
        this.familyTreeFinder = new FamilyTreeFinder(familyTree);
    }

    @Override
    public void addHuman(String name, LocalDate dateOfBirth, Gender gender, String fatherName, LocalDate fatherBirthDate, String motherName, LocalDate motherBirthDate) {
        Human father = findOrCreateParent(fatherName, Gender.MALE, fatherBirthDate);
        Human mother = findOrCreateParent(motherName, Gender.FEMALE, motherBirthDate);

        Human human = new Human(name, gender, dateOfBirth);
        familyTree.addMember(human);

        if (father != null) {
            father.addChild(human);
        }

        if (mother != null) {
            mother.addChild(human);
        }
    }

    @Override
    public StringBuilder getHumanListInfo() {
        StringBuilder info = new StringBuilder();
        for (Human member : familyTree) {
            info.append(member).append("\n");
        }
        return info;
    }

    private Human findOrCreateParent(String name, Gender gender, LocalDate birthDate) {
        if (name == null || name.isEmpty()) {
            return null;
        }

        Human parent = familyTree.getMember(name);
        if (parent == null) {
            parent = new Human(name, gender, birthDate);
            familyTree.addMember(parent);
        }
        return parent;
    }

    @Override
    public void sortByBirthDate() {
        familyTreeSorter.sortByBirthDate(familyTree.getMembers());
    }

    @Override
    public void sortByName() {
        familyTreeSorter.sortByName(familyTree.getMembers());
    }

    @Override
    public FamilyMember findByName(String name) {
        return familyTreeFinder.findByName(name);
    }

    @Override
    public String findByNameStr(String name) {
        return familyTreeFinder.findByNameStr(name);
    }

    @Override
    public List<FamilyMember> findByBirthYear(int year) {
        return familyTreeFinder.findByBirthYear(year);
    }

    @Override
    public String findByBirthYearStr(int year) {
        return familyTreeFinder.findByBirthYearStr(year);
    }
}
