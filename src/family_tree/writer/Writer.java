package family_tree.writer;

import family_tree.family_tree.FamilyTree;

public interface Writer {
      void save(FamilyTree serializable) ;
      Object read();
      void setPath(String path);
}
