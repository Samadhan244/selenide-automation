import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinksPage {
    private static final SelenideElement BROKEN_LINKS_LINK = $(
            "a[href='https://practice-automation.com/broken-links/']");

    public BrokenLinksPage goToBrokenLinksPage() {
        BROKEN_LINKS_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Broken Links"));
        return this;
    }

    public BrokenLinksPage checkForBrokenLinks() {
        ElementsCollection allLinks = $$("a");
        List<String> brokenLinks = new ArrayList<>();

        for (SelenideElement link : allLinks) {
            String url = link.getAttribute("href");

            if (url != null && !url.isEmpty()) {
                int statusCode = getResponseCode(url);
                if (statusCode >= 400) {
                    brokenLinks.add(url + " -> Status: " + statusCode);
                }
            }
        }

        if (!brokenLinks.isEmpty()) {
            System.out.println("Broken links found:");
            brokenLinks.forEach(System.out::println);
        } else {
            System.out.println("No broken links found.");
        }

        return this;
    }

    private int getResponseCode(String url) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) URI.create(url).toURL().openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            return connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("Error checking link: " + url + " -> " + e.getMessage());
            return 500; // Assume broken if request fails
        } finally {
            if (connection != null) {
                connection.disconnect(); // Close connection properly
            }
        }
    }
}