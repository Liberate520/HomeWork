package Writer;

// import java.io.*;


// // public class FamilyTreeFileHandler implements FamilyTreeIO {
// public class FamilyTreeFileHandler implements Writer {

//     private String filePath = "Wrirer/familyTree.txt";


//         // Сохранение дерева в файл
//     @Override
//     public void save(Serializable serializable) {
//         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
//             oos.writeObject(serializable);
//         }
//         catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
//     // public void saveToFile(FamilyTree familyTree, String filename) throws IOException {
//     //     try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
//     //         oos.writeObject(familyTree);
//     //     }
//     // }




//     @Override
//     public Object read() {
//         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//             return ois.readObject();
//         }
//         catch (IOException | ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//         return null;

//         // @Override
//         // public FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException {
//         //     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
//         //         return (FamilyTree) ois.readObject();
//         //     }


//     }
    
//     @Override
//     public void setPath(String path){
//         this.filePath = path;
//     }
// }



// // try {
// //     // Сохранение дерева в файл
// //     fileHandler.saveToFile(familyTree, "wrirer/familyTree.txt");
    
// //     // Загрузка дерева из файла
// //     FamilyTree loadedTree = fileHandler.loadFromFile("wrirer/familyTree.txt");
    
// //     // Вывод загруженного дерева
// //     loadedTree.printTree();
// // } catch (IOException | ClassNotFoundException e) {
// //     e.printStackTrace();
// // }

// package Writer;

import java.io.*;

public class FamilyTreeFileHandler implements Writer {
    private String path;

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(serializable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
