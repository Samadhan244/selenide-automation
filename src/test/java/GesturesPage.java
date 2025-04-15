import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

import com.codeborne.selenide.SelenideElement;

public class GesturesPage {
    private static final SelenideElement GESTURES_LINK = $(
            "a[href='https://practice-automation.com/gestures/']");
    private static final SelenideElement BOX_HEADER = $("#moveMeHeader");
    private static final SelenideElement IMAGE = $("img[data-recalc-dims='1']");
    private static final SelenideElement IMAGE_PLACE_TO_MOVE = $("#div2");

    public GesturesPage goToGesturesPage() {
        GESTURES_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Gestures"));
        return this;
    }

    public GesturesPage moveBox() {
        actions().clickAndHold(BOX_HEADER).moveByOffset(500, 100).release().perform();
        return this;
    }

    public GesturesPage dragAndDropImage() {
        assertNotEquals(IMAGE.parent().getAttribute("id"), "div2"); // Verify image is NOT inside div2 before dragging
        actions().dragAndDrop(IMAGE, IMAGE_PLACE_TO_MOVE).perform(); // Perform drag and drop
        assertEquals(IMAGE.parent().getAttribute("id"), "div2"); // Verify image IS inside div2 after dragging
        return this;
    }
}