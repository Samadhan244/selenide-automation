import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import java.util.UUID;
import java.util.Random;

public class FormFieldPage {
    private static final SelenideElement FORM_FIELD_LINK = $(
            "a[href='https://practice-automation.com/form-fields/']");
    private static final SelenideElement NAME = $("#name-input");
    private static final SelenideElement PASSWORD = $("input[type='password']");
    private static final ElementsCollection FAVOURITE_DRINKS = $$("input[name='fav_drink']");
    private static final ElementsCollection FAVOURITE_COLORS = $$("input[name='fav_color']");
    private static final SelenideElement AUTOMATION_SELECTION = $("#automation");
    private static final SelenideElement EMAIL = $("#email");
    private static final SelenideElement MESSAGE = $("#message");
    private static final SelenideElement SUBMIT_BUTTON = $("#submit-btn");

    public FormFieldPage goToFormFieldPage() {
        FORM_FIELD_LINK.click();
        AllTest.HEADER.shouldHave(text("Form Fields"));
        return this;
    }

    public FormFieldPage fillForm(String name, String password, int favDrink, int favColor, String doYouLikeAutomation) {
        NAME.setValue(name);
        PASSWORD.setValue(password);

        // Select a favorite drink by index (must be within range)
        if (favDrink >= 0 && favDrink < 5)
            FAVOURITE_DRINKS.get(favDrink).click();
        else
            throw new IllegalArgumentException("Invalid drink index: " + favDrink);

        // Select a favorite color by index (must be within range)
        if (favColor >= 0 && favColor < 5)
            FAVOURITE_COLORS.get(favColor).click();
        else
            throw new IllegalArgumentException("Invalid color index: " + favColor);

        // Select answer (validate input and capitalize the first letter)
        if (doYouLikeAutomation.equalsIgnoreCase("yes") || doYouLikeAutomation.equalsIgnoreCase("no")
                || doYouLikeAutomation.equalsIgnoreCase("undecided"))
            AUTOMATION_SELECTION
                    .selectOption(Character.toUpperCase(doYouLikeAutomation.charAt(0))
                            + doYouLikeAutomation.substring(1).toLowerCase());
        else
            throw new IllegalArgumentException("Invalid answer: " + doYouLikeAutomation);

        String email = "test_" + UUID.randomUUID().toString().substring(0, 8) + "@mail.com";
        EMAIL.setValue(email);
        String message = UUID.randomUUID().toString().replace("-", "").substring(0, 6 + new Random().nextInt(20));
        MESSAGE.setValue(message);
        System.out.println("Random generated email: " + email);
        System.out.println("Random generated text: " + message);
        System.out.println("");
        return this;
    }

    public FormFieldPage submit() {
        SUBMIT_BUTTON.hover().click(); // .hover() is required to make the button clickable
        return this;
    }

    public FormFieldPage acceptAlert() {
        assertEquals(switchTo().alert().getText(), "Message received!", "Alert text does not match!");
        switchTo().alert().accept();
        return this;
    }
}