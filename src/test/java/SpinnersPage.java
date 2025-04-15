import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class SpinnersPage {
    private static final SelenideElement SPINNERS_LINK = $("a[href='https://practice-automation.com/spinners/']");
    private static final SelenideElement SPINNER = $(".spinner-hidden");

    public SpinnersPage goToSpinnersPage() {
        SPINNERS_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Spinners"));
        return this;
    }

    public SpinnersPage waitForSpinnerToDisappear() {
        SPINNER.shouldBe(visible); // Ensure the spinner appears first
        SPINNER.shouldBe(hidden); // Wait until it disappears
        return this;
    }
}
