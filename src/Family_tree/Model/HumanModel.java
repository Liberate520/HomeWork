package Family_tree.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Family_tree.Model.Humans.Human;
import Family_tree.View.ActionLevel;

public class HumanModel extends Model<Human> {

    private TreeManager<Human> treeModel;
    private ElementManager<Human> humanManagerClass;
    private ActionLevel level;

    public HumanModel(){
        this.treeModel = new TreeManager<>();
        this.humanManagerClass = new HumanManagerClass();
        this.level = ActionLevel.NoLevel;
    }

    @Override
    public void setTreeModel(TreeManager<Human> treeModel) {
        this.treeModel = treeModel;
    }

    @Override
    public void setSubjectModel(ElementManager<Human> subjectModel) {
        this.humanManagerClass = subjectModel;
    }

    @Override
    public boolean selectTree(int index) {
        this.level = ActionLevel.TreeLevel;
        return this.treeModel.setActiveTree(index);
    }

    private LocalDate dayFromText(String value){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate day = LocalDate.parse(value, formatter);
        return day;
    }

    @Override
    public boolean setDeathDate(String text) {
        if (this.level == ActionLevel.SubjectLevel){
            HumanManagerClass manager = (HumanManagerClass) this.humanManagerClass;
            return manager.setDeathDate(dayFromText(text));
        } else {
            return false;
        }
    }

    @Override
    public boolean saveTree(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveTree'");
    }

    @Override
    public boolean addToTree(String name, String gender, String birhday) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToTree'");
    }

    @Override
    public boolean newChild(String name, String gender, String birhday, int IDFather, int IDMother) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newChild'");
    }

    @Override
    public String searchByPattern(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByPattern'");
    }

    @Override
    public String createActiveTree(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createActiveTree'");
    }

    @Override
    public boolean loadTree(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadTree'");
    }

    @Override
    public String showActiveSubjectInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showActiveSubjectInfo'");
    }

    @Override
    public boolean removeMember() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMember'");
    }

    @Override
    public boolean removeTree() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeTree'");
    }

    @Override
    public String showSubjectList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showSubjectList'");
    }

    @Override
    public String getTreeList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTreeList'");
    }

}
