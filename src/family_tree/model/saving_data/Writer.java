package family_tree.model.saving_data;

import family_tree.model.program_classes.FamilyTree;

public interface Writer {
    void writeData(FamilyTree fTree);
    FamilyTree readData();
}
