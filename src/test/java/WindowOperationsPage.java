import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import static org.testng.Assert.assertEquals;
import java.util.Set;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class WindowOperationsPage {
    private static final SelenideElement WINDOW_OPERATIONS_LINK = $(
            "a[href='https://practice-automation.com/window-operations/']");
    private static final SelenideElement NEW_TAB_BUTTON = $(".custom_btn[onclick='newTab()']");
    private static final SelenideElement REPLACE_WINDOW_BUTTON = $(".custom_btn[onclick='newWindowSelf()']");
    private static final SelenideElement NEW_WINDOW_BUTTON = $(".custom_btn[onclick='newWindow()']");
    private static final String EXPECTED_URL = "https://automatenow.io/";

    public WindowOperationsPage goToWindowOperationsPage() {
        WINDOW_OPERATIONS_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Window Operations"));
        return this;
    }

    public WindowOperationsPage openAndCloseNewTab() {
        NEW_TAB_BUTTON.click();
        switchTo().window(1);
        assertEquals(WebDriverRunner.url(), EXPECTED_URL);
        closeWindow();
        switchTo().window(0);
        return this;
    }

    public WindowOperationsPage replaceWindowAndGoBack() {
        REPLACE_WINDOW_BUTTON.click();
        assertEquals(WebDriverRunner.url(), EXPECTED_URL);
        back();
        return this;
    }

    public WindowOperationsPage openAndCloseNewWindow() {
        String originalWindow = WebDriverRunner.getWebDriver().getWindowHandle(); // Save original window
        NEW_WINDOW_BUTTON.click(); // Click button to open new browser

        Set<String> windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();

        // Wait until a new window appears
        while (windowHandles.size() == 1)
            windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();

        // Find new window handle
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                switchTo().window(handle);
                break;
            }
        }

        // Verify the new window URL, close it, and switch back to the original window
        assertEquals(WebDriverRunner.url(), EXPECTED_URL);
        closeWindow();
        switchTo().window(originalWindow);
        return this;
    }
}