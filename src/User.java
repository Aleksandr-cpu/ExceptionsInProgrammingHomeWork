import java.time.LocalDate;

public class User {
    private String lastName;
    private String firstName;
    private String patronymic;
    private LocalDate birthday;
    private long phone;
    private char gender;

    public User(String lastName, String firstName, String patronymic, LocalDate birthday, long phone, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public long getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %c", lastName, firstName, patronymic, birthday, phone, gender);
    }
}
