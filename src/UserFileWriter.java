import java.io.File;
import java.io.IOException;

public class FileWriter {
    public static void write(User user){
        File file = new File(user.getLastName() + ".txt");
        try (FileWriter writer = new FileWriter(file, true)){
            writer.write(user.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файлю Ошибка: " + e.getMessage(), e);
        }
    }
}
