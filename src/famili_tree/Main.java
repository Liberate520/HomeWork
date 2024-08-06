




import Human.Human;
import family_tree.FamilyTree;
import Filehendler.FileHandler;




public class Main {
    
    final  static String  filePath="Human/ttest.txt"; 
    public static void main(String[] args) {
        
    
    // public static void main (String[] args) {
        Human numan1=new Human("Vasiliy", "Morozov", "man", "1990.06.22");
        Human numan2=new Human("Aleksandr", "Morozov", "man","2014.12.04");
        Human numan3=new Human("Vasisuil", "lokhankin", "man", "1961.08.20","2003.09.25" );
        Human numan4=new Human("Evgeniya", "Morozova", "woman", "1991.03.12");
        FamilyTree treeM=new FamilyTree(numan1);
        treeM.addHuman(numan2);
        treeM.addHuman(numan4);
        
        numan1.addChildren(numan2);
        numan4.addChildren(numan2);
        numan1.addSuprug(numan4);
        // System.out.println(numan1);
        // System.out.println(numan1.suprug);
        // System.out.println(numan4.suprug);
        System.out.println(treeM);
        // for (Human el:treeM){
        //     System.out.println(el);
        // }
        // System.out.println("******************** ПО ИМЕНИ*************************");
        // treeM.sortByName();
        // System.out.println(treeM);
        // System.out.println("**********************ПО ВОЗРАСТУ*******************************");
        // treeM.sortByAge();
        // System.out.println(treeM);
        // // System.out.println(treeM.findByName("Ivan"));
        // treeM.findByName("Vasiliy");
        // System.out.println(numan1.children);
        // System.out.println(numan1.getVozrast());
        // System.out.println(numan3);
	 
        FamilyTree treeL=load();
        // save(treeM);
        System.out.println(treeL);
        
    }

	private static FamilyTree load (){
        FileHandler filehendler= new FileHandler(filePath);
        
        return (FamilyTree) filehendler.read();
    }
    
    private static void save (FamilyTree familyTree){
        FileHandler filehendler= new FileHandler(filePath);
        
        filehendler.save(familyTree);
        System.out.println("Fayl sohranen");
    }
        
}

