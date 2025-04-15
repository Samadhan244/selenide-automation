import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Selenide;
import java.util.List;
import java.util.stream.Collectors;

public class BrokenImagesPage {
    private static final SelenideElement BROKEN_IMAGES_LINK = $(
            "a[href='https://practice-automation.com/broken-images/']");

    public BrokenImagesPage goToBrokenImagesPage() {
        BROKEN_IMAGES_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Broken Images"));
        return this;
    }

    public BrokenImagesPage testBrokenImages() {
        ElementsCollection images = $$("img");

        List<String> brokenImages = images.stream()
                .filter(img -> {
                    Long width = Selenide.executeJavaScript("return arguments[0].naturalWidth", img);
                    return width != null && width == 0;
                })
                .map(img -> img.getAttribute("src"))
                .collect(Collectors.toList());

        if (!brokenImages.isEmpty()) {
            System.out.println("Broken images found:");
            brokenImages.forEach(System.out::println);
        } else {
            System.out.println("No broken images found.");
        }

        System.out.println("");
        return this;
    }
}