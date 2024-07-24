package writer;
import human.Human;
import humanTree.HumanTree;
import java.io.*;

    public class FileHandler implements Serializable {


//        public void writer(HumanTree humanTree) {
//            try (ObjectOutputStream = new ObjectOutputStream(
//                    new FileOutputStream("people.out"))) {
//                objectOutputStream.writeObject(humanTree);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void reader() {
//            try (
//                    ObjectInputStream objectInputStream = new ObjectInputStream(
//                            new FileInputStream("people.out"))) {
//                HumanTree restoredHumanTree = (HumanTree) objectInputStream.readObject();
//
//                // Вывод восстановленных объектов на консоль
//                for (Human human : restoredHumanTree.getHumans()) {
//                    System.out.println(human);
//                }
//            } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }

//        public void writer1(HumanTree humanTree) throws IOException, ClassNotFoundException {
//            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//                    new FileOutputStream("person.out"))) {
//                objectOutputStream.writeObject(humanTree);
//            }
//        }
//
//        public void reader1() throws IOException, ClassNotFoundException {
//            try (ObjectInputStream objectInputStream = new ObjectInputStream(
//                    new FileInputStream("person.out"))) {
//                System.out.println("reading...");
//                HumanTree restoredHumanTree = (HumanTree) objectInputStream.readObject();
//
//                // Вывод восстановленных объектов на консоль
//                for (Human human : restoredHumanTree.getHumans()) {
//                    System.out.println(human);
//                }
//            }
//        }

        public void writer(HumanTree humanTree) throws IOException, ClassNotFoundException  {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("person.out"));
            objectOutputStream.writeObject(humanTree);
            objectOutputStream.close();
        }

        public HumanTree reader() throws IOException, ClassNotFoundException  {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("person.out"));
            HumanTree humanTreeRestored = (HumanTree) objectInputStream.readObject();
            objectInputStream.close();
            return humanTreeRestored;
        }

    }
