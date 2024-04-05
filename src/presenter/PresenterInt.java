package presenter;

import View.View;
import model.Service;
import model.entity.Gender;
import model.entity.Person;
import model.tree.FamilyTree;

import java.time.LocalDate;

public interface PresenterInt {


    public FamilyTree<Person> prep();

    public void addPerson(String name, Gender gender, LocalDate birthdate);

    public void addRelationship(String parentName, String childName);

    public void showTree();

}



