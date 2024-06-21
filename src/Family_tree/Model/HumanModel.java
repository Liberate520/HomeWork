package Family_tree.Model;

import java.time.LocalDate;

import java.util.Map;

import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Humans.Human;
import Family_tree.Model.Tree.Family_tree;

public class HumanModel extends ElementManager<Human> {

    private Human activeElement;
    private Family_tree<Human> activeTree;
    //private String FormateDate = "d.MM.yyyy";
    //private boolean isActiveTreeEmpty;


    public HumanModel(){
        this.activeElement = null;
        this.activeTree = null;
       // this.isActiveTreeEmpty = true;
    }

    @Override
    Human newSubject(String name, Gender gender, LocalDate bd) {
        return new Human(name, gender, bd);
    }

    public Human getActiveHuman(){
        int id = this.getActiveSubjectIndex();
        return this.getActiveTree().getItem(id);
    }

    public boolean addToActiveTree(String name, String gender, String bd){
        boolean boo = super.newSubject(name, gender, bd);
        if (boo){
            Family_tree<Human> tree = super.getActiveTree();
            tree.add(this.getActiveHuman());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeSubject() {
        try{
            Human human = this.getActiveHuman();
            Family_tree<Human> tree = super.getActiveTree();
            tree.remove(human);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean setActiveSubject(int id) {
        try{
            this.activeElement = this.activeTree.getItem(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }    

    @Override
    public boolean setActiveSubject(long innerID) {
        try{
            this.activeElement = this.activeTree.getItemByInnerID(innerID); 
            if (this.activeElement != null) {
                return true;
            }                
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;       
    }

    @Override
    public boolean setActiveSubject(Human subject) {
       for (Human human : this.activeTree.getMemberList()) {
            if(human.equals(subject)){
                this.activeElement = human;
                return true;
            }
       }
       return false;
    }

    private String mapText(Map<Integer, Human> value){   
        if (value.isEmpty()){
            return "Ничего не найдено";
        }     
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer,Human> entray : value.entrySet()) {
            sb.append(entray.getKey());
            sb.append(" ");
            sb.append(entray.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String searchSubject(String pattern) {
        Map<Integer, Human> list = this.activeTree.searchByPattern(pattern);
        return mapText(list);
    }

    @Override
    public String searchSubject(String pattern, Family_tree<Human> tree) { // Зарезервировано для взаимодействий между древами
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSubject'");
    }

    @Override
    public String searchSubject(String pattern, long treeInnerID) { // Зарезервировано для взаимодействий между древами
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSubject'");
    }

    @Override
    public String searchSubject(String pattern, int treeIndex) { // Зарезервировано для взаимодействий между древами
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSubject'");
    }

    @Override
    public boolean setChild(Human subject, Human father, Human mother) {
        try{
            subject.setFather(father);
            subject.setMother(mother);
            father.addChild(subject);
            mother.addChild(subject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    

   

    

    
}
