package FamilyTree.Model.ItemTree;
import java.time.LocalDate;
import java.util.List;

/**
 * интерфейс для описания члена фамильного дерева
 */
public interface Person<E> {
    String getFirstName();

    String getLastName();

    int getInn();

    Gender getGender();

    LocalDate getBirtDay();

    E getHusband();

    E getFather();

    E getMother();

    String info();

    List<E> getListChildren();

    void addChildren(E child);

    boolean setParent(E parent);

    boolean setHusband(E parent);

    void setMortDay(LocalDate mort);

    void setInn(int inn);


}