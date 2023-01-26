import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.devtools.v85.page.Page;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

public class ParameterTests {

    TestBase testBase = new TestBase();
    Pages page = new Pages();

    @ParameterizedTest
    @ValueSource(strings = {"Спальни", "Гостиные", "Прихожие", "Молодежные"})
    public void mebelTest(String input) {
        testBase.login();
        page.goToSalary()
                .setFurniture(input);
        testBase.logOut();
        //на сейте баг. приходится выходить 2 раза
        testBase.logOut();

    }

    @ParameterizedTest
    @CsvSource( {"2024", "2027", "2030"})
    public void calendare(String value) {
        testBase.goToCalendar()
                .changeYear()
                .calendar()
                .changeCalendar(value);

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void point(String value) {
        testBase.openPoint()
                .chooseMenu()
                .selectDish(value);
    }

}
