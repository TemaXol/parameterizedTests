import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Resoursec {

    public void openSite() {
        open("https://www.shatura.com/");
    }




    public void logOut() {
        $(".signin-link__title").click();
        $("#personal_menu").$(byText("Выйти")).click();
    }

    public Resoursec goToCalendar() {
        open("https://calendar555.ru/");

        return this;
    }

    public Resoursec changeYear() {
        $("#nav").$(byText("Календарь 2022")).click();
        $("#zaglv_opisan").shouldHave(text("Календарь на 2022 год с праздниками и выходными"));

        return this;
    }
    public Resoursec calendar() {
        $("#calend_vibor_zagol").$(byText("2022")).click();

        return this;
    }

    public Resoursec changeCalendar(String value) {
        $("select.osn").click();
        $(byText(value)).click();
        $("#calend_vibor_zagol").shouldHave(text(value));
        return this;
    }

    public Resoursec openPoint() {
        open("https://vkusnoitochka.ru");
        return this;
    }

    public Resoursec chooseMenu() {
        $(".page-header-navigation").$("a[href='/menu']").click();
        $(".delivery__title").shouldHave(text("Приходи к нам! Наше меню"));
        return this;
    }

    public Resoursec selectDish(String value) {
        $("#menuOuter").$(byText(value)).click();
        return this;
    }

}
