import static com.codeborne.selenide.Selenide.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class AllTest {
    public static SelenideElement HEADER = $("h1[itemprop='headline']");
    private final SelenideElement HOMEPAGE_BUTTON = $(".attachment-full.size-full");
    private final LoginPage loginPage = new LoginPage();
    private final DelayPage delayPage = new DelayPage();
    private final FormFieldPage formFieldPage = new FormFieldPage();
    private final PopupsPage popupsPage = new PopupsPage();
    private final SlidersPage slidersPage = new SlidersPage();
    private final CalendarsPage calendarsPage = new CalendarsPage();
    private final ModalsPage modalsPage = new ModalsPage();
    private final TablesPage tablesPage = new TablesPage();
    private final WindowOperationsPage windowOperationsPage = new WindowOperationsPage();
    private final HoverPage hoverPage = new HoverPage();
    private final AdsPage adsPage = new AdsPage();
    private final GesturesPage gesturesPage = new GesturesPage();
    private final DownloadPage downloadPage = new DownloadPage();
    private final ClickEventsPage clickEventsPage = new ClickEventsPage();
    private final SpinnersPage spinnersPage = new SpinnersPage();
    private final FileUploadPage fileUploadPage = new FileUploadPage();
    private final IframesPage iframesPage = new IframesPage();
    private final BrokenImagesPage brokenImagesPage = new BrokenImagesPage();
    private final BrokenLinksPage brokenLinksPage = new BrokenLinksPage();
    private final AccordionsPage accordionsPage = new AccordionsPage();

    // Ensures the test always returns to the homepage after execution
    @AfterMethod
    private void homePage() {
        HOMEPAGE_BUTTON.click();
    }

    // Setup
    @BeforeClass
    public void setup() {
        open("https://practice-automation.com/?hl=en");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test(priority = 1)
    public void testLogin() {
        loginPage.testLogin();
    }

    @Test(priority = 2)
    public void testDelayPage() {
        delayPage
                .goToDelayPage()
                .testDelay();
    }

    @Test(priority = 3)
    public void testFormFieldPage() {
        formFieldPage
                .goToFormFieldPage()
                .fillForm("Aham", "Brahmasmi", 2, 3, "Yes")
                .submit()
                .acceptAlert();
    }

    @Test(priority = 4)
    public void testPopupsPage() {
        popupsPage
                .goToPopupsPage()
                .alertPopup()
                .confirmPopup()
                .promptPopup();
    }

    @Test(priority = 5)
    public void testSliderPage() {
        slidersPage
                .goToSlidersPage()
                .moveSlider(50)
                .moveSlider(101) // Will be clamped to 100 (max)
                .moveSlider(-22); // Will be clamped to 0 (min)
    }

    @Test(priority = 6)
    public void testCalendarPage() {
        calendarsPage
                .goToCalendarsPage()
                .setDate(2025, 3, 2);
    }

    @Test(priority = 7)
    public void testModalsPage() {
        modalsPage
                .goToModalsPage()
                .simpleModal()
                .formModal("Aham Brahmasmi");
    }

    @Test(priority = 8)
    public void testTablesPage() {
        tablesPage
                .goToTablesPage()
                .getItemPrices(2);
    }

    @Test(priority = 9)
    public void testWindowOperationsPage() {
        windowOperationsPage
                .goToWindowOperationsPage()
                .openAndCloseNewTab()
                .replaceWindowAndGoBack()
                .openAndCloseNewWindow();
    }

    @Test(priority = 10)
    public void testHoverPage() {
        hoverPage
                .goToHoverPage()
                .testHovering();
    }

    @Test(priority = 11)
    public void testAdsPage() {
        adsPage
                .goToAdsPage()
                .waitForAdAndCloseIt();
    }

    @Test(priority = 12)
    public void testGesturesPage() {
        gesturesPage
                .goToGesturesPage()
                .moveBox()
                .dragAndDropImage();
    }

    @Test(priority = 13)
    public void testDownloadPage() {
        downloadPage
                .goToDownloadPage()
                .downloadFile();
    }

    @Test(priority = 14)
    public void testClickEventsPage() {
        clickEventsPage
                .goToDelayPage()
                .testClicks();
    }

    @Test(priority = 15)
    public void testSpinnersPage() {
        spinnersPage
                .goToSpinnersPage()
                .waitForSpinnerToDisappear();
    }

    @Test(priority = 16)
    public void testFileUploadPage() {
        fileUploadPage
                .goToSpinnersPage()
                .testUploadingFile();
    }

    @Test(priority = 17)
    public void testIframesPage() {
        iframesPage
                .goToIframesPage()
                .testIframes();
    }

    @Test(priority = 18)
    public void testBrokenImagesPage() {
        brokenImagesPage
                .goToBrokenImagesPage()
                .testBrokenImages();
    }

    @Test(priority = 19)
    public void testBrokenLinksPage() {
        brokenLinksPage
                .goToBrokenLinksPage()
                .checkForBrokenLinks();
    }

    @Test(priority = 20)
    public void testAccordionsPage() {
        accordionsPage
                .goToAccordionsPage()
                .testAccordions();
    }
}