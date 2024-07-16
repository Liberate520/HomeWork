package familyTreeSrc;

import person.Gender;

import java.time.LocalDate;
import java.util.List;

// добавил новый класс интерфейс и добавил нужные методы с типом <T>/(T) \\
public interface ItemFamilyTree<T> {
    Integer getChildrenQuantity();

    String getName();

    LocalDate getBirthDate();

    long getId();

    Gender getGender();

    int getAge();

    int getPeriod(LocalDate birthDate, LocalDate deathDate);

    T getSpouse();

    List<T> getParents();

    List<T> getChildren();

    void setId(long id);

    void setSpouse(T spouse);

    boolean addChild(T child);

    boolean addParent(T parent);
}
