package family_tree.model.writer;

import family_tree.model.person.TreeNode;
import family_tree.model.tree.FamilyTree;

import java.io.Serializable;

public interface Writable <T extends TreeNode<T>> {
    boolean writeTreeAsByteCode(Serializable outputObject, String fileNameForTree);
    boolean writeSubjectAsByteCode(Serializable outputObject, String fileNameForPeople);
    FamilyTree<T> readTreeFromByteCodeFile(String fileNameForTree);
    T readSubjectFromByteCodeFile(String fileNameForPeople);



}
