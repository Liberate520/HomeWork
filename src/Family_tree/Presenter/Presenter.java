package Family_tree.Presenter;



public abstract class Presenter {
   
    public abstract String selectTree(int index); 
    public abstract String setDeathDate(String text); 
    public abstract String saveTree(String text); 
    public abstract String addToTree(String name, String gender, String birhday);
    public abstract String newChild(String name, String gender, String birhday, int IDFather, int IDMother);
    public abstract String searchByPattern(String text); 
    public abstract String createActiveTree(String text);
    public abstract String loadTree(String text);
    public abstract String showActiveSubjectInfo();
    public abstract String removeMember();
    public abstract String removeTree();
    public abstract String showSubjectList();
    public abstract String getTreeList(); 




}
