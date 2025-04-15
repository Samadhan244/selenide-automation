import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class HoverPage {
    private static final SelenideElement HOVER_LINK = $("a[href='https://practice-automation.com/hover/']");
    private static final SelenideElement HOVER_ELEMENT = $("#mouse_over");

    public HoverPage goToHoverPage() {
        HOVER_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Hover"));
        return this;
    }

    public HoverPage testHovering() {
        HOVER_ELEMENT.shouldHave(exactText("Mouse over me"));
        HOVER_ELEMENT.hover();
        HOVER_ELEMENT.shouldHave(exactText("You did it!"));
        return this;
    }
}
