package homeWork.Model.Tree;

public interface TreeItem<Human> extends Comparable<Human> {
    int getAge();
    String getName();
}
