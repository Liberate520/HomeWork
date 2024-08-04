package ru.gb.familytree.FileReadWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWorker implements FileReadWriter{
    @Override
    public void writeLine(String fileName, String line, Boolean type) {
        try(FileWriter writer = new FileWriter(fileName, type)) {
            writer.write(line);
            writer.append("/n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void writeLine(String fileName, String line) {
        try(FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(line);
            writer.append("/n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String readFile(String fileName) {
        try(FileReader reader = new FileReader(fileName)) {
            StringBuilder buff = new StringBuilder();
            int c;
            while ((c=reader.read()) != -1) {
                buff.append((char) c);
            }
            return buff.toString();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
