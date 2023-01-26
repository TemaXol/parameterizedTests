import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {

    public void openSite() {
        open("https://www.shatura.com/");
    }

    @Test
    public void login() {
        openSite();
       $(".navbar__signin").click();
       $(".modal__login").shouldHave(text("Вход"));
       $("input#email_auth").setValue("artem_holevko@mail.ru");
       $("input#password").setValue("chq5LgHqAaJYTsc");
       $(byText("Войти")).click();
       $(".signin-link__title").shouldHave(text("Alex"));

    }


    public void logOut() {
        $(".signin-link__title").click();
        $("#personal_menu").$(byText("Выйти")).click();
    }

    public TestBase goToCalendar() {
        open("https://calendar555.ru/");

        return this;
    }

    public TestBase changeYear() {
        $("#nav").$(byText("Календарь 2022")).click();
        $("#zaglv_opisan").shouldHave(text("Календарь на 2022 год с праздниками и выходными"));

        return this;
    }
    public TestBase calendar() {
        $("#calend_vibor_zagol").$(byText("2022")).click();

        return this;
    }

    public TestBase changeCalendar(String value) {
        $("select.osn").click();
        $(byText(value)).click();
        $("#calend_vibor_zagol").shouldHave(text(value));
        return this;
    }

    public TestBase openPoint() {
        open("https://vkusnoitochka.ru");
        return this;
    }

    public TestBase chooseMenu() {
        $(".page-header-navigation").$("a[href='/menu']").click();
        $(".delivery__title").shouldHave(text("Приходи к нам! Наше меню"));
        return this;
    }

    public TestBase selectDish(String value) {
        $("#menuOuter").$(byText(value)).click();
        return this;
    }

}
