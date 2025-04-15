import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

import java.util.Random;
import java.util.UUID;

public class ModalsPage {
    private static final SelenideElement MODAL_LINK = $(
            "a[href='https://practice-automation.com/modals/']");
    private static final SelenideElement SIMPLE_MODAL_BUTTON = $("#simpleModal");
    private static final SelenideElement SIMPLE_MODAL_TEXT = $("#pum_popup_title_1318");
    private static final SelenideElement SIMPLE_MODAL_CLOSE_BUTTON = $("#popmake-1318 .pum-close.popmake-close");
    private static final SelenideElement FIRM_MODAL_BUTTON = $("#formModal");
    private static final SelenideElement FIRM_MODAL_TEXT = $("#pum_popup_title_674");
    private static final SelenideElement FIRM_MODAL_NAME = $("#g1051-name");
    private static final SelenideElement FIRM_MODAL_EMAIL = $("#g1051-email");
    private static final SelenideElement FIRM_MODAL_MESSAGE = $("#contact-form-comment-g1051-message");
    private static final SelenideElement FIRM_MODAL_CLOSE_BUTTON = $("#popmake-674 .pum-close.popmake-close");

    public ModalsPage goToModalsPage() {
        MODAL_LINK.click();
        AllTest.HEADER.shouldHave(text("Modals"));
        return this;
    }

    public ModalsPage simpleModal() {
        SIMPLE_MODAL_BUTTON.click();
        SIMPLE_MODAL_TEXT.shouldHave(text("Simple Modal"));
        SIMPLE_MODAL_CLOSE_BUTTON.click();
        return this;
    }

    public ModalsPage formModal(String name) {
        FIRM_MODAL_BUTTON.click();
        FIRM_MODAL_TEXT.shouldHave(text("Modal Containing A Form"));
        FIRM_MODAL_NAME.setValue(name);
        String email = "test_" + UUID.randomUUID().toString().substring(0, 8) + "@mail.com";
        String message = UUID.randomUUID().toString().replace("-", "").substring(0, 6 + new Random().nextInt(20));
        FIRM_MODAL_EMAIL.setValue(email);
        FIRM_MODAL_MESSAGE.setValue(message);
        FIRM_MODAL_CLOSE_BUTTON.click();
        return this;
    }
}
