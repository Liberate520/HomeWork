package family_tree.base;

import family_tree.family_tree.FamilyTree;


public interface Writable {
    <E extends TreeHub<E>> boolean save(FamilyTree<E> tree);
    <E extends TreeHub<E>> FamilyTree<E> read();
    void setFilePath(String filePath);
}
