package family_tree.saving_data;

import family_tree.program_classes.FamilyTree;

public interface Writer {
    void writeData(FamilyTree fTree);
    FamilyTree readData();
}
