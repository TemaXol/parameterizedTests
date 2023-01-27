import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterTests {

    LoginTest loginTest = new LoginTest();
    Resoursec resoursec = new Resoursec();
    Pages page = new Pages();

    @ParameterizedTest
    @ValueSource(strings = {"Спальни", "Гостиные", "Прихожие", "Молодежные"})
    public void mebelTest(String input) {
        loginTest.login();
        page.goToSalary()
                .setFurniture(input);
        resoursec.logOut();
        //на сейте баг. приходится выходить 2 раза
        resoursec.logOut();

    }

    @ParameterizedTest
    @CsvSource( {"2024", "2027", "2030"})
    public void calendare(String value) {
        resoursec.goToCalendar()
                .changeYear()
                .calendar()
                .changeCalendar(value);

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void point(String value) {
        resoursec.openPoint()
                .chooseMenu()
                .selectDish(value);
    }

}
