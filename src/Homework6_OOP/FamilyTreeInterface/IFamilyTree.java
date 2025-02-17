package Homework6_OOP.FamilyTreeInterface;

import Homework6_OOP.Human.Human;
import Homework6_OOP.HumanInterfaces.Person;

import java.io.IOException;
import java.util.List;

public interface IFamilyTree<T extends Human> {
    void add(T entity);
    T getById(long id);
    List<T> getByName(String name);
    boolean remove(long id);
    boolean setWedding(long id1, long id2);
    String getInfo();
    List<T> getEntityList();
    void addParentChildRelation(Person parent, Person child);
    void saveToFile(String filePath) throws IOException;
    void loadFromFile(String filePath) throws IOException, ClassNotFoundException;
}
