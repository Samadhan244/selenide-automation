import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class IframesPage {
    private static final SelenideElement IFRAMES_LINK = $(
            "a[href='https://practice-automation.com/iframes/']");
    private static final SelenideElement IFRAME_1 = $("#iframe-1");
    private static final SelenideElement IFRAME_2 = $("#iframe-2");

    public IframesPage goToIframesPage() {
        IFRAMES_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Iframes"));
        return this;
    }

    public IframesPage testIframes() {
        // Test first iframe
        switchTo().frame(IFRAME_1);
        $("h1").shouldHave(text("Playwright enables reliable end-to-end testing for modern web apps."));
        switchTo().defaultContent(); // Switch back to main page

        // Test second iframe
        switchTo().frame(IFRAME_2);
        $("h1").shouldHave(text("Selenium automates browsers. That's it!"));
        switchTo().defaultContent(); // Switch back to main page
        return this;
    }
}