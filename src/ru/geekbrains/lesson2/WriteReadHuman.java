package ru.geekbrains.lesson2;

import java.io.*;

public class WriteReadHuman <Human>{
    public void writeHuman(Human anyHuman){
        try{
            FileOutputStream fs = new FileOutputStream("src/forFiles/human.Human.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(anyHuman);
            os.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public Human readHuman(){
        Human human = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/forFiles/human.Human.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object objHuman = objectInputStream.readObject();
            human = (Human) objHuman;
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }
}
