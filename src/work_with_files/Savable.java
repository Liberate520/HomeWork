package work_with_files;

import family_tree.Tree;

public interface Savable {

    boolean save(Tree tree);
    Tree read();
}

