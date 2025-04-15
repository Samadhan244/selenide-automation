import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class CalendarsPage {
    private static final SelenideElement CALENDARS_LINK = $(
            "a[href='https://practice-automation.com/calendars/']");
    private static final SelenideElement DATE_PICKER = $("#g1065-2-1-selectorenteradate");

    public CalendarsPage goToCalendarsPage() {
        CALENDARS_LINK.click();
        AllTest.HEADER.shouldHave(text("Calendars"));
        return this;
    }

    public CalendarsPage setDate(int year, int month, int day) {
        // Format the date correctly (YYYY-MM-DD)
        String date = year + "-" + month + "-" + day;

        // Set the date value using JavaScript and trigger an input event
        executeJavaScript("arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('input'))",
                DATE_PICKER, date);

        // Assert that the date is correctly set
        DATE_PICKER.shouldHave(attribute("value", date));
        return this;
    }
}