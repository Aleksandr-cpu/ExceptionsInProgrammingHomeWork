import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInputParser {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Zа-яА-Я]+$");

    public static User parse(){
        System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        if (data.length != 6 ){
            throw new IllegalArgumentException("Неверное количество введенных данных. Требуется 6 значений.");
        }
        String lastName = data[0];
        String firstName = data[1];
        String patronymic = data[2];
        LocalDate birthday;
        long phone;
        char gender;

        if (!NAME_PATTERN.matcher(lastName).matches()) {
            throw new IllegalArgumentException("Фамилия содержит недопустимые символы. Допустимы только буквы.");
        }
        if (!NAME_PATTERN.matcher(firstName).matches()) {
            throw new IllegalArgumentException("Имя содержит недопустимые символы. Допустимы только буквы.");
        }
        if (!NAME_PATTERN.matcher(patronymic).matches()) {
            throw new IllegalArgumentException("Отчество содержит недопустимые символы. Допустимы только буквы.");
        }

        try{
            birthday = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            phone = Long.parseLong(data[4]);
            gender = data[5].charAt(0);
            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Неверный пол. Допустимые значения: f (женский) или m (мужской).");
            }
        } catch (Exception e){
            throw  new IllegalArgumentException("Неверный формат данных. Ошибка: " + e.getMessage());
        }
        return new User(lastName, firstName, patronymic, birthday, phone, gender);
    }
}
