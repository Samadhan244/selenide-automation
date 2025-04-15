import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

import com.codeborne.selenide.SelenideElement;

public class PopupsPage {
    private static final SelenideElement POPUPS_LINK = $(
            "a[href='https://practice-automation.com/popups/']");

    private static final SelenideElement ALERT_POPUP = $("#alert");
    private static final SelenideElement CONFIRM_POPUP = $("#confirm");
    private static final SelenideElement PROMPT_POPUP = $("#prompt");

    private static final SelenideElement CONFIRM_TEXT = $("p[id='confirmResult']");
    private static final SelenideElement PROMPT_TEXT = $("p[id='promptResult']");

    public PopupsPage goToPopupsPage() {
        POPUPS_LINK.click();
        AllTest.HEADER.shouldHave(text("Popups"));
        return this;
    }

    public PopupsPage alertPopup() {
        ALERT_POPUP.click();
        assertEquals(switchTo().alert().getText(), "Hi there, pal!", "Alert text does not match!");
        switchTo().alert().accept();
        return this;
    }

    public PopupsPage confirmPopup() {
        // Accept alert
        CONFIRM_POPUP.click();
        switchTo().alert().accept();
        CONFIRM_TEXT.shouldHave(text("OK it is!"));

        // Dismiss alert
        CONFIRM_POPUP.click();
        switchTo().alert().dismiss();
        CONFIRM_TEXT.shouldHave(text("Cancel it is!"));
        return this;
    }

    public PopupsPage promptPopup() {
        // Accept without input
        PROMPT_POPUP.click();
        switchTo().alert().accept();
        PROMPT_TEXT.shouldHave(text("Fine, be that way..."));

        // Accept with input
        PROMPT_POPUP.click();
        switchTo().alert().sendKeys("Name");
        switchTo().alert().accept();
        PROMPT_TEXT.shouldHave(text("Nice to meet you, Name!"));
        return this;
    }
}
