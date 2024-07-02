package Family_tree.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Humans.Human;
import Family_tree.Model.Recorder.Recorder;
import Family_tree.Model.Tree.Family_tree;
import Family_tree.Model.Tree.TreesCollection;
import Family_tree.View.ActionLevel;

public class HumanService extends Service<Human>{

    private TreesCollection<Human> collection;
    private ActionLevel level;
    private Family_tree<Human> activeTree;
    private Human activeHuman;
    private String FormateDate = "d.MM.yyyy";

    public HumanService(){
        this.collection = new TreesCollection<Human>();
        this.level = ActionLevel.NoLevel;
    }

    private Gender strToGender(String value){
        if (value.equalsIgnoreCase("м")){
            return Gender.Male;
        } else if(value.equalsIgnoreCase("ж")){
            return Gender.Female;
        } else {
            return null;
        }
    }

     private LocalDate strToDate(String value){
        try{
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern(FormateDate);
            LocalDate d = LocalDate.parse(value, formatter);
            return d;
        } catch (Exception e){
            return null;
        }
    }

    public void setActionLevel(ActionLevel level) {
        this.level = level;
    }

    public boolean setActiveTree(int index){ 
        if (collection.setActiveTree(index)){
            this.activeTree = this.collection.getActiveTree();
            this.level = ActionLevel.TreeLevel;
            return true;
        }       
        return false;        
    }

    public boolean getActiveElement() {
        try{
            this.activeHuman = this.activeTree.getActiveItem();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean setActiveElement(int human) {        
        return this.activeTree.setActiveItem(human);        
    }

    public boolean isEmpty() {
        return this.collection.isEmpty();
    }    

    public ActionLevel getActionLevel() {
        return this.level;
    }

    public boolean addToTree(String name, String gender, String birhday){
        Human human = new Human(name, strToGender(gender), strToDate(birhday));
        return this.addToTree(human);   
    }
    
    public String newChild(String name, String gender, String birhday, int IDFather, int IDMother){
        Human human = new Human(name, strToGender(gender), strToDate(birhday));
        Human father = this.activeTree.getItem(IDFather);
        Human mother = this.activeTree.getItem(IDMother);
        if (this.setChild(human, father, mother)){
            return "OK";
        } 
        return "Ошибка регистрации";  
    }

    public Family_tree<Human> getActiveTree() {
        return this.activeTree;
    }

    public int getActiveTreeIndex(){
        return this.activeTree.getIndex();
    }

    public String showActiveSubjectInfo(){
        return this.activeHuman.getInfo();
    }

    public String removeMember() {
        try{            
            this.activeTree.remove(this.activeHuman);
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
        List<Human> mans = this.activeTree.getMemberList();
        if (mans.isEmpty()) {
            return "Список пуст";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mans.size(); i++){
            sb.append(i);
            sb.append(" ");
            sb.append(mans.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String setMarriage(int id1, int id2) {
        Human one = this.activeTree.getItem(id1);
        Human two = this.activeTree.getItem(id2);
        if (one == null || two == null){
            return "Ошибка регистрации";
        }
        if (one.setSpouse(two) || two.setSpouse(one)){
            return "OK";
        }
        return "Ошибка регистрации";
    }

    public String delMarriage(int id1, int id2) {
        Human one = this.activeTree.getItem(id1);
        Human two = this.activeTree.getItem(id2);
        try{
            one.setSpouse(null);
            two.setSpouse(null);
            return "OK";
        } catch (Exception e) {
            System.out.println(e);
            return "Ошибка регистрации";
        }
    }


    public String selectSubject(int index) {
        String s;        
        try{            
            this.activeTree.setActiveItem(index);
            this.activeHuman = this.activeTree.getActiveItem();
            s = String.format("Выбран(а) %s", activeHuman.toString());            
            this.level = ActionLevel.SubjectLevel;
        } catch (Exception e) {
            System.out.println(e);
            this.activeHuman = null;
            this.level = ActionLevel.TreeLevel;
            s = "Никто не выбран";
        }
        return s; 
    }

    public String selectActiveTree(int index) {
        try{
            if (this.collection.setActiveTree(index)){
                this.activeTree = this.collection.getActiveTree();
                this.level = ActionLevel.TreeLevel;
                return "OK";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        this.level = ActionLevel.NoLevel;
        return "Древо не выбрано";
    }

    @Override
    public boolean ActiveTreeIsEmpty() {
        return this.activeTree.getMemberList().isEmpty();
    }
   

    @Override
    public boolean addToTree(Human subject) {
        try{
            this.activeTree.add(subject);
            this.activeHuman = this.activeTree.getActiveItem();
            this.level = ActionLevel.SubjectLevel;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean addToTree(Human subject, Family_tree<Human> tree) {
        this.activeTree = tree;
        this.level = ActionLevel.TreeLevel;
        return this.addToTree(subject);
    }

    @Override
    public boolean setActiveSubject(int id) {
        if (this.activeTree.setActiveItem(id)){
            this.activeHuman = this.activeTree.getActiveItem();
            this.level = ActionLevel.SubjectLevel;
            return true;
        }
        return false;
    }

    @Override
    public boolean setActiveSubject(long innerID) {
        if (this.activeTree.setActiveItem(innerID)){
            this.activeHuman = this.activeTree.getActiveItem();
            this.level = ActionLevel.SubjectLevel;
            return true;
        }
        return false;
    }

    @Override
    public boolean setActiveSubject(Human subject) {
        List<Human> mans = this.activeTree.getMemberList();
        try{
            if (!mans.contains(subject)){
                this.activeTree.add(subject);                
            }
            this.activeHuman = subject;
            this.level = ActionLevel.SubjectLevel;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
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
    public String searchSubject(String pattern, Family_tree<Human> tree) {
        Map<Integer, Human> list = tree.searchByPattern(pattern);
        return mapText(list);
    }

    @Override
    public String searchSubject(String pattern, long treeInnerID) {
        Family_tree<Human> hTree = this.collection.selectTree(treeInnerID);
        return this.searchSubject(pattern, hTree);
    }

    @Override
    public String searchSubject(String pattern, int treeIndex) {
        Family_tree<Human> hTree = this.collection.selectTree(treeIndex);
        return this.searchSubject(pattern, hTree);
    }

    @Override
    public boolean setChild(Human subject, Human father, Human mother) {
        try{
            this.activeTree.add(subject);
            this.level = ActionLevel.SubjectLevel;
            subject.setFather(father);
            subject.setMother(mother);
            father.addChild(subject);
            mother.addChild(subject);
            this.activeHuman = subject;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public int getActiveSubjectIndex() {
        return this.activeHuman.getIndex();
    }

    @Override
    public long getActiveSubjectInnerID() {
        return this.activeHuman.getInnerID();
    }

    @Override
    public String getInfo() {
        return this.activeTree.getInfo();
    }

    @Override
    public boolean setDeathDate(String date) {
        try{
            this.activeHuman.setDeathDate(strToDate(date));
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public String getDeathDate() {
        try{
            LocalDate d = this.activeHuman.getDeatdDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FormateDate);
            String s = d.format(formatter);
            return s;
        } catch (Exception e) {
            System.out.println(e);
            return "Дата не указана";
        }
        
    }

    @Override
    public boolean removeSubject() {
        try{
            this.activeTree.remove(activeHuman);
            this.level = ActionLevel.TreeLevel;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean newTree(String family) {
        if(this.collection.newTree(family)){
            this.activeTree = this.collection.getActiveTree();
            this.level = ActionLevel.TreeLevel;
            return true;
        }
        return false;
    }

    @Override
    public boolean addTree(Family_tree<Human> tree) {
        try{
            this.collection.setActiveTree(tree);
            this.activeTree = collection.getActiveTree();
            this.level = ActionLevel.TreeLevel;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean setActiveTree(long innerID) {
        try{
            this.collection.setActiveTree(innerID);
            this.activeTree = collection.getActiveTree();
            this.level = ActionLevel.TreeLevel;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean setActiveTree(Family_tree<Human> tree) {
        try{
            this.collection.setActiveTree(tree);
            this.activeTree = collection.getActiveTree();
            this.level = ActionLevel.TreeLevel;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean deleteTree(int ID) {
        try{
            this.collection.getList().remove(ID);
            this.level = ActionLevel.NoLevel;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean deleteTree(long innerID) {
        Family_tree<Human> tree = this.collection.selectTree(innerID);
        return this.deleteTree(tree);
    }

    @Override
    public boolean deleteTree(Family_tree<Human> tree) {
        try{
            this.collection.getList().remove(tree);
            this.level = ActionLevel.NoLevel;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean loadTree(String path) {
        Recorder recorder = new Recorder();
        Family_tree<Human> tree;
        try{
            tree = (Family_tree<Human>) recorder.read(path);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        if(this.collection.setActiveTree(tree)){
            this.activeTree = tree;
            this.level = ActionLevel.TreeLevel;
            return true;
        }
        return false;
    }

    @Override
    public boolean saveTree(String path) {
        try{
            this.activeTree.save(path);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
    }

    @Override
    public long getActiveTreeInnerID() {
        try{
            return this.activeTree.getInnerID();
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
        
    }

    @Override
    public boolean haveActiveTree() {
        if (this.activeTree != null){
            this.level = ActionLevel.TreeLevel;
            return true;
        }
        this.level = ActionLevel.NoLevel;
        return false;
    }

    @Override
    public boolean join(Family_tree<Human> tree1, Family_tree<Human> tree2) { //reserved
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'join'");
    }

    @Override
    public String searchByPattern(String pattern) {
        return this.searchSubject(pattern);
    }

    @Override
    public String showList() {
        List<Family_tree<Human>> list = this.collection.getList();
        if (list.isEmpty() || list == null){
            return "Список пуст";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++){
            sb.append(i);
            sb.append(" ");
            sb.append(list.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getItemInfo() {
        try{
            return this.activeHuman.getInfo();
        } catch (Exception e) {
            System.out.println(e);
            return "No Info";
        }
    }

    public TreesCollection<Human> getCollection(){
        return this.collection;
    }

}
