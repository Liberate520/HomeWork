package src.Model.FamilyTree;

import java.io.Serializable;

public interface TreeGrowable<E> extends Serializable {

    public void addMember(E member);

    public E getMember(String name);

    public void sortByName();

    public void sortByBirthday();

    public void sortByChildren();

    public String GetFamilyInfo();
}
