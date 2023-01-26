import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Pages {

    private SelenideElement
            goToSalary = $(".corporate-link__a"),
            chooseFurniture = $(".categories-grid__list");


    public Pages goToSalary() {
        goToSalary.click();

        return this;

    }

    public Pages setFurniture(String value) {
        chooseFurniture.$(byText(value)).click();

        return this;
    }
}
