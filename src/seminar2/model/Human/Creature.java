package seminar2.model.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface Creature<N> extends Serializable {
    Gender getGender();

    String getName();

    String getSurname();

    N getMother();

    N getFather();

    List<N> getParents();

    List<N> getChildren();

    long getId();

    void setId(long id);

    boolean addChild(N child);

    boolean addParent(N parent);

    LocalDate getDateOfBirth();

    LocalDate getDateOfDeath();

    N getPartner();

    void setPartner(N partner);

    String getBriefInfo();

    String getChildrenInfo();

    int getAge();

}
