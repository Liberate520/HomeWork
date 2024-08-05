package family_tree.model.writer;

import family_tree.model.family_tree.FamilyTree;

public interface Writer {
      void save(FamilyTree serializable) ;
      Object read();
      void setPath(String path);
}
