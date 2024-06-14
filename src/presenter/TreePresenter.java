package presenter;

public interface TreePresenter {
    void loadFamilyTree();
    void addMember(String name, int age);
    void findMember(String name);
    void getChildrenOf(String name);
}
