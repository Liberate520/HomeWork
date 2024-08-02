package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.List;

public interface ItemFamilyTree<T> extends Serializable {
  boolean addChild(T child);
  boolean addParent(T parent);
  int getId();
  String getFirstName();
  String getLastName();
  int getAge ();
  List<T> getParents();
  List<T> getChildren();
  T getSpouse();
  void setSpouse(T spouse);
  T getFather();
  T getMother();

}
