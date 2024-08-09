package familytree.model;

import java.time.LocalDate;
import java.util.List;

public interface TreeMember {
    String getName();
    LocalDate getBirthDate();
    Gender getGender();
    TreeMember getFather();
    TreeMember getMother();
    List<? extends TreeMember> getChildren();
    void setFather(TreeMember father);
    void setMother(TreeMember mother);
    void addChild(TreeMember child);
}