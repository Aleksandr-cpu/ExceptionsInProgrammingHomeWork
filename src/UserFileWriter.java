import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserFileWriter implements AutoCloseable {
    private final FileWriter writer;

    public UserFileWriter(File file, boolean append) throws IOException {
        this.writer = new FileWriter(file, append);
    }

    public void write(String data) throws IOException {
        writer.write(data);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

    public static void write(User user) {
        File file = new File(user.getLastName() + ".txt");
        try (UserFileWriter writer = new UserFileWriter(file, true)) {
            writer.write(user.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл: " + e.getMessage(), e);
        }
    }
}
