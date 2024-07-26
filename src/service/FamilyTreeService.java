package service;

import model.FamilyMember;
import model.Gender;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeService {
    void addHuman(String name, LocalDate dateOfBirth, Gender gender, String fatherName, LocalDate fatherBirthDate, String motherName, LocalDate motherBirthDate);
    StringBuilder getHumanListInfo();
    void sortByBirthDate();
    void sortByName();
    FamilyMember findByName(String name);
    String findByNameStr(String name);
    List<FamilyMember> findByBirthYear(int year);
    String findByBirthYearStr(int year);
}
