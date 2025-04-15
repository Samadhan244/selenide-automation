import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class AccordionsPage {
    private static final SelenideElement ACCORDIONS_PAGE_LINK = $("a[href='https://practice-automation.com/accordions/']");
    private static final SelenideElement CLICK_TO_SEE_MORE = $(".wp-block-coblocks-accordion-item__title");
    private static final SelenideElement ACCORDION_TEXT = $(".wp-block-coblocks-accordion-item__content");

    public AccordionsPage goToAccordionsPage() {
        ACCORDIONS_PAGE_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Accordions"));
        return this;
    }

    public AccordionsPage testAccordions() {
        // Ensure it's initially closed
        ACCORDION_TEXT.shouldNotBe(visible);

        // Open and check content
        CLICK_TO_SEE_MORE.click();
        ACCORDION_TEXT.shouldHave(exactText("This is an accordion item."));

        // Close and verify it's hidden
        CLICK_TO_SEE_MORE.click();
        ACCORDION_TEXT.shouldNotBe(visible);
        return this;
    }
}
