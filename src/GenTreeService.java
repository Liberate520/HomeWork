import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public interface GenTreeService <E> extends Serializable {
    E getFather();
    E getMother();
    List<E> children();



}
