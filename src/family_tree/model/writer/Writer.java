package family_tree.model.writer;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;

public interface Writer {
      void save(FamilyTree<Human> serializable) ;
      Object read();
      void setPath(String path);
}
