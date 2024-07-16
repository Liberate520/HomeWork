package Model.family_tree;

import Model.family_tree.Writer.FileHandler;
import Model.family_tree.human.Gender;
import Model.family_tree.human.Human;
import Model.family_tree.human.HumanId;

import java.time.LocalDate;
public class Servise {
    private  FamilyTree familyTree;
    private FileHandler fileHandler;
    private HumanId humanId;
    public Servise(){
        this.familyTree=new FamilyTree();
        this.humanId=new HumanId();
        this.fileHandler = new FileHandler();
    }
    public  void addHuman(String name, String sexStr, LocalDate brthDate){
        Human human = humanId.build();
        Gender sex = StrToGender(sexStr);
        human.setSex(sex);
        human.setName(name);
        human.setBrthDate(brthDate);

        familyTree.add(human);

    }

    private Gender StrToGender(String sexStr) {
        Gender sex = Gender.Misgender;
        if (sexStr.equalsIgnoreCase("м")) {
            sex = Gender.Male;
        } else if (sexStr.equalsIgnoreCase("ж")) {
            sex = Gender.Female;
        }
        else{
        System.out.println("Возможно неверно введен пол");
        }
        return sex;
    }

    public  String getHumansList(){

        return familyTree.getInfo();

    }
    public void saveTree() {
        fileHandler.Save(familyTree);
    }
    public void saveTree(FamilyTree familyTree) {
        fileHandler.Save(familyTree);
    }

    public FamilyTree loadTree() {
        return (FamilyTree) fileHandler.Load();
    }
    public String GetInfoFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("На данный момент в дереве:\n");

        for (Object human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }
    public void SortByName(){
        familyTree.SortByName();
    }
    public void SortBybrthDate(){
        familyTree.SortByBrthDate();
    }
    public void SortById(){
        familyTree.sortById();
    }

    public void SetSex(String idStr, String sexStr) {
        Gender sex = StrToGender(sexStr);
        int id = Integer.parseInt(idStr);
        familyTree.getById(id).setSex(sex);
    }

    public void SetFamily(String idStr1,String idStr2)
    {   int id1 = Integer.parseInt(idStr1);
        int id2 = Integer.parseInt(idStr2);
        familyTree.setFamily(id2, id1);
    }

    public void SetSpouse(String idStr1,String idStr2)
    {   int id1 = Integer.parseInt(idStr1);
        int id2 = Integer.parseInt(idStr2);
        familyTree.setWedding(familyTree.getById(id1), familyTree.getById(id2));
    }
}
