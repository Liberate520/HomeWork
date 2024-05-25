package work_with_files;

import family_tree.Tree;

public interface Savable {

    void setFilePath(String filePath);
    boolean save(Tree tree);
    Tree read();
}

