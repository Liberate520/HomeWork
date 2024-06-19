package Family_tree.Model;

import Family_tree.Model.Humans.Endothermal;

public abstract class Model<T extends Endothermal> {

    public abstract void setTreeModel(TreeManager<T> treeModel);
    public abstract void setSubjectModel(ElementManager<T> subjectModel);


    public abstract boolean selectTree(int index); 
    public abstract boolean setDeathDate(String text); 
    public abstract boolean saveTree(String text); 
    public abstract boolean addToTree(String name, String gender, String birhday);
    public abstract boolean newChild(String name, String gender, String birhday, int IDFather, int IDMother);
    public abstract String searchByPattern(String text); 
    public abstract String createActiveTree(String text);
    public abstract boolean loadTree(String text);
    public abstract String showActiveSubjectInfo();
    public abstract boolean removeMember();
    public abstract boolean removeTree();
    public abstract String showSubjectList();
    public abstract String getTreeList(); 

}
