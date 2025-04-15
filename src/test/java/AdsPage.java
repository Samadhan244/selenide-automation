import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class AdsPage {
    private static final SelenideElement ADS_LINK = $("a[href='https://practice-automation.com/ads/']");
    private static final SelenideElement AD_ELEMENT = $("#popmake-1272");
    private static final SelenideElement AD_CLOSE_BUTTON = $("#popmake-1272 .pum-close");

    public AdsPage goToAdsPage() {
        ADS_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Ads"));
        return this;
    }

    public AdsPage waitForAdAndCloseIt() {
        // Wait for the ad to appear and then close it
        AD_ELEMENT.shouldBe(visible, java.time.Duration.ofSeconds(10));
        AD_CLOSE_BUTTON.click();
        return this;
    }
}
