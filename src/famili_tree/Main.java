




import Human.Human;
import family_tree.FamilyTree;
import Filehendler.FileHandler;
import view.ConsoleUI;
import view.View;


public class Main
{
    final  static String  filePath="Human/ttest.txt";
    public static void main(String[] args) {

        View view = new ConsoleUI();
        view.start();
        // Service service=new Service();
        // service.addHuman("Vasiliy", "Morozov", "man", "1990.06.22");
        // service.addHuman("Aleksandr", "Morozov", "man","2014.12.04");
        // service.addHuman("Evgeniya", "Morozova", "woman", "1991.03.12");
        // System.out.println(service.getInfo());
        // service.addSuprugByNum(1,3);
        // service.addParentByNum(2,3);
        // service.addChildByNum(1,2);
        // System.out.println(service.getInfo());

        // service.getParentByNum(2);
        // System.out.println("******************** ПО ИМЕНИ*************************");
        // service.sortByName();
        // System.out.println(service.getInfo());
        // System.out.println("**********************ПО ВОЗРАСТУ*******************************");
        // service.sortByAge();
        // System.out.println(service.getInfo());

        // Human numan1=new Human("Vasiliy", "Morozov", "man", "1990.06.22");
        // Human numan2=new Human("Aleksandr", "Morozov", "man","2014.12.04");
        // Human numan3=new Human("Vasisuil", "lokhankin", "man", "1961.08.20","2003.09.25" );
        // Human numan4=new Human("Evgeniya", "Morozova", "woman", "1991.03.12");
        // FamilyTree treeM=new FamilyTree(numan1);
        // treeM.addHuman(numan2);
        // treeM.addHuman(numan4);
        // System.out.println(numan1.getSuprug());
        // System.out.println(treeM.getInfo());
        // StringBuilder sB= new StringBuilder();
        // sB.append("Список родственников: "  +"\n");
        // sB.append(treeM.getInfo());
        // System.out.println(sB);

        // numan1.addChildren(numan2);
        // numan4.addChildren(numan2);
        // numan1.addSuprug(numan4);
        // StringBuilder sB2 = new StringBuilder();
        // sB2.append("Список родственников: "  +"\n");
        // sB2.append(treeM.getInfo());
        // System.out.println(sB2);
        // System.out.println(treeM.get(0));

        // System.out.println(treeM);
        // System.out.println("******************** ПО ИМЕНИ*************************");
        // treeM.sortByName();
        // System.out.println(treeM);
        // System.out.println("**********************ПО ВОЗРАСТУ*******************************");
        // treeM.sortByAge();
        // System.out.println(treeM);
        // System.out.println(treeM.findByName("Ivan"));
        // treeM.findByName("Vasiliy");
        // System.out.println(numan1.children);
        // System.out.println(numan1.getVozrast());
        // System.out.println(numan3);

        // FamilyTree treeL=load();
        // save(treeM);


    }

// 	private static FamilyTree load (){
//         FileHandler filehendler= new FileHandler(filePath);

//         return (FamilyTree) filehendler.read();
//     }

//     private static void save (FamilyTree familyTree){
//         FileHandler filehendler= new FileHandler(filePath);

//         filehendler.save(familyTree);
//     }

}

