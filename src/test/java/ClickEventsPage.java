import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class ClickEventsPage {
    private static final SelenideElement CLICK_EVENTS_LINK = $(
            "a[href='https://practice-automation.com/click-events/']");
    private static final SelenideElement SOUNDS_HEADER = $("#demo");
    private static final SelenideElement CAT_BUTTON = $("button[onclick='catSound()']");
    private static final SelenideElement DOG_BUTTON = $("button[onclick='dogSound()']");
    private static final SelenideElement PIG_BUTTON = $("button[onclick='pigSound()']");
    private static final SelenideElement COW_BUTTON = $("button[onclick='cowSound()']");

    public ClickEventsPage goToDelayPage() {
        CLICK_EVENTS_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Click Events"));
        return this;
    }

    public ClickEventsPage testClicks() {
        SOUNDS_HEADER.shouldBe(empty);
        CAT_BUTTON.click();
        SOUNDS_HEADER.shouldHave(text("Meow!"));
        DOG_BUTTON.click();
        SOUNDS_HEADER.shouldHave(text("Woof!"));
        PIG_BUTTON.click();
        SOUNDS_HEADER.shouldHave(text("Oink!"));
        COW_BUTTON.click();
        SOUNDS_HEADER.shouldHave(text("Moo!"));
        return this;
    }
}