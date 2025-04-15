import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

public class DownloadPage {
    private static final SelenideElement DOWNLOAD_PAGE_LINK = $(
            "a[href='https://practice-automation.com/file-download/']");
    private static final SelenideElement DOWNLOAD_BUTTON = $(".wpdm-download-link.download-on-click");

    public DownloadPage goToDownloadPage() {
        DOWNLOAD_PAGE_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("File Download"));
        return this;
    }

    public DownloadPage downloadFile() {
        DOWNLOAD_BUTTON.click();
        return this;
    }

    static {
        configureDownloads(); // Apply settings at class load
    }

    private static void configureDownloads() {
        Configuration.downloadsFolder = System.getProperty("user.home") + "\\Desktop"; // Set download path
        Configuration.browser = "chrome";
        Configuration.browserCapabilities = new ChromeOptions().setExperimentalOption("prefs", Map.of(
                "download.default_directory", Configuration.downloadsFolder,
                "download.prompt_for_download", false,  // Disable "Save As" dialog
                "download.directory_upgrade", true,
                "safebrowsing.enabled", true
        ));
    }
}
