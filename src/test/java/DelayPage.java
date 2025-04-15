import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class DelayPage {
    private static final SelenideElement DELAY_LINK = $(
            "a[href='https://practice-automation.com/javascript-delays/']");
    private static final SelenideElement START_BUTTON = $("#start"); // Button that starts the countdown
    private static final SelenideElement DELAY_INPUT = $("#delay"); // Input field that displays the countdown value

    public DelayPage goToDelayPage() {
        DELAY_LINK.click();
        AllTest.HEADER.shouldHave(text("JavaScript Delays"));
        return this;
    }

    public DelayPage testDelay() {
        START_BUTTON.click();
        // Wait up to 20 seconds for the input value to change to "Liftoff!"
        DELAY_INPUT.shouldHave(exactText("Liftoff!"), java.time.Duration.ofSeconds(20));
        return this;
    }
}