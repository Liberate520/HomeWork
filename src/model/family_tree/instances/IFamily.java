package model.family_tree.instances;
import java.util.List;

public interface IFamily {
    IFamily getMother();
    IFamily getFather();
    List<IFamily> getChildren();
    String getName();
}
