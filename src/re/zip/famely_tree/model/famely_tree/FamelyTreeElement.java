package re.zip.famely_tree.model.famely_tree;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamelyTreeElement<E> extends Serializable {
    List<E> getListParents();
    List<E> getChildren();
    E getSpouse();
    E getMother();
    E getFather();
    LocalDate getDateOfBirsday();
    String getFamelyName();
    String getSpouseInfo();
    String getFirstName();
    long getIdNo();
    void setIdNo(long l);
    boolean addACild(E human);
    boolean addAParent(E human);
    void setFamelyName(String famelyName);
    void setSpouse(E human);
    void addAChild(E child);
    void removeAChild(E child);
    void removeAParent(E parent);

}
