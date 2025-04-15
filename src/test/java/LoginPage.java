import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class LoginPage {

    public LoginPage testLogin() {
        SelenideElement HEADER = $("#post-36");
        HEADER.shouldHave(text("Welcome to your software automation practice website! "));
        return this;
    }
}