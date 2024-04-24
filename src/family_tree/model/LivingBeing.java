package family_tree.model;

import java.util.List;

public interface LivingBeing {
    void addChild(Human child);
    void addParent(Human parent);
    List<Human> getParents();
    List<Human> getChildren();
    String getName();
    String getGender();
    String getBirthDate();
    String getDeathDate();
}
