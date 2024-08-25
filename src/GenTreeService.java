import java.io.Serializable;
import java.util.List;

interface GenTreeService <T> extends Serializable {
    T getFather();
    T getMother();
    List<T> children();
}