package Family_tree.Model;

import Family_tree.Model.Humans.Human;
import Family_tree.Model.Tree.Family_tree;
import Family_tree.View.ActionLevel;

public class HumanService extends Service<Human>{

    public void setActionLevel(ActionLevel level) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActionLevel'");
    }

    public void setActiveTree(int index){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActionLevel'");
    }

    public boolean getActiveElement() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActiveElement'");
    }

    public void setActiveElement(int human) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActiveElement'");
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    public int selectTree(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectTree'");
    }

    public ActionLevel getActionLevel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActionLevel'");
    }

    public boolean addToTree(String name, String gender, String birhday){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActionLevel'");
    }

    public boolean addToActiveTree(String name, String gender, String birhday) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToActiveTree'");
    }

    public String newChild(String name, String gender, String birhday, int IDFather, int IDMother){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToActiveTree'");
    }

    public int getActiveTree() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActiveTree'");
    }

    public String showActiveSubjectInfo(){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActiveTree'");
    }

    public String removeMember() {
        try{
            Human human = this.getActiveSubject();
            Family_tree<Human> tree = this.getActiveTree();
            tree.remove(human);
            this.setActionLevel(ActionLevel.TreeLevel);
            return "Удалено";
        } catch (Exception e) {
            return "Ошибка удаления";
        }       
    }

    public String removeTree() {
        try {
            this.deleteTree(this.getActiveTree());              
            this.setActionLevel(ActionLevel.NoLevel);
            return "OK";
        } catch (Exception e) {
            return "Ошибка удаления";
        }        
    }

    public String showSubjectList() {
         // TODO Auto-generated method stub
         throw new UnsupportedOperationException("Unimplemented method 'delMarriage'");
    }

    public String setMarriage(int id1, int id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMarriage'");
    }

    public String delMarriage(int id1, int id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delMarriage'");
    }


    public String selectSubject(int index) {

         // TODO Auto-generated method stub
         throw new UnsupportedOperationException("Unimplemented method 'delMarriage'");
         /*
        String s;
        Human human;
        try{
            human = this.service.getActiveTree().getItem(index);
            s = String.format("Выбран(а) %s", human.toString());
            this.setActiveSubject(human);
            this.setActionLevel(ActionLevel.SubjectLevel);
        } catch (Exception e) {
            System.out.println(e);
            this.setActiveSubject(null);
            this.setActionLevel(ActionLevel.TreeLevel);
            s = "Никто не выбран";
        }
        return s; */
    }

}
