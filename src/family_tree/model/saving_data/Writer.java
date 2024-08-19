package family_tree.model.saving_data;

import family_tree.model.program_classes.FamilyTree;
import family_tree.model.program_classes.FamilyTreeItem;
import family_tree.model.program_classes.Human;

public interface Writer {
    void writeData(Object o);
    Object readData();
}
