package re.zip.famely_tree.srv;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamelyTreeElement<E> extends Serializable {
    List<E> getListParents();
    List<E> getChildren();

    E getSpouse();
    // E getMother();
    // E getFather();
    // E getParentNoHuman();

    LocalDate getDateOfBirsday();

    String getFamelyName();
    String getSpouseInfo();
    String getFatherName();
    String getFirstName();

    long getIdNo();

    void setIdNo(long l);



    //что здесь не так?? всё??
    boolean addACild(E human);
    boolean addAParent(E human);
    void setFamelyName(String famelyName);
    void setSpouse(E human);
}
