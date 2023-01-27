import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends Resoursec {

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
}
