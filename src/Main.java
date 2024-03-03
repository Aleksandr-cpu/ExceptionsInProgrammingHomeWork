import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        User user = UserInputParser.parse();
        UserFileWriter.write(user);
    }
}
