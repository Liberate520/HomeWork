package family_tree.writer;

import family_tree.person.BasicUnit;
import family_tree.tree.FamilyTree;


import java.io.Serializable;

public interface Writable <T extends BasicUnit> {
    boolean writeTreeAsByteCode(Serializable outputObject, String fileNameForTree);
    boolean writeUnitAsByteCode(Serializable outputObject, String fileNameForPeople);
    FamilyTree readTreeFromByteCodeFile(String fileNameForTree);
    T readUnitFromByteCodeFile(String fileNameForPeople);



}
