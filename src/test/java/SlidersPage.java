import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class SlidersPage {
    private static final SelenideElement SLIDERS_LINK = $(
            "a[href='https://practice-automation.com/slider/']");
    private static final SelenideElement SLIDER = $("#slideMe");

    public SlidersPage goToSlidersPage() {
        SLIDERS_LINK.click();
        AllTest.HEADER.shouldHave(text("Slider"));
        return this;
    }

    public SlidersPage moveSlider(int targetValue) {
        // Set slider value using JavaScript and trigger an input event
        executeJavaScript("arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('input'))", SLIDER,
                targetValue);

        // Verify that the slider's value is correctly set within the allowed range (0 to 100)
        if (targetValue >= 0 && targetValue <= 100)
            SLIDER.shouldHave(attribute("value", String.valueOf(targetValue)));
        else if (targetValue > 100)
            SLIDER.shouldHave(attribute("value", "100"));
        else
            SLIDER.shouldHave(attribute("value", "0"));

        return this;
    }
}
