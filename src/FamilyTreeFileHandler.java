import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FamilyTreeFileHandler {

    // Метод для записи генеалогического древа в файл
    public void writeFamilyTreeToFile(String fileName, List<Human> familyMembers) {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);

            for (Human member : familyMembers) {
                writer.write(member.toString() + "\n"); // Записываем информацию о каждом члене семьи в файл
            }

            writer.close();
            System.out.println("Генеалогическое древо успешно записано в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи генеалогического древа в файл: " + e.getMessage());
        }
    }

    // Дополнительные методы для чтения информации из файла и обработки данных также могут быть добавлены здесь
}
