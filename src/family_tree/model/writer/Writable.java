package family_tree.model.writer;

import family_tree.model.person.TreeNode;
import family_tree.model.tree.FamilyTree;

import java.io.Serializable;

public interface Writable <T extends TreeNode<T>> {
    boolean writeTreeAsByteCode(Serializable outputObject);
    boolean writeSubjectAsByteCode(Serializable outputObject);
    FamilyTree<T> readTreeFromByteCodeFile();
    T readSubjectFromByteCodeFile();



}
