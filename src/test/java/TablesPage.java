import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Map;

public class TablesPage {
    private static final SelenideElement TABLES_LINK = $(
            "a[href='https://practice-automation.com/tables/']");
    private static final ElementsCollection ITEMS = $$(".wp-block-table table tbody tr td:first-child");
    private static final ElementsCollection PRICES = $$(".wp-block-table table tbody tr td:last-child");
    private static final Map<String, String> ITEMS_AND_PRICES = Map.of(
            "Oranges", "$3.99",
            "Laptop", "$1200.00",
            "Marbles", "$1.25");

    public TablesPage goToTablesPage() {
        TABLES_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("Tables"));
        return this;
    }

    public TablesPage getItemPrices(int index) {
        if (index < 1 || index > ITEMS.size())
            throw new IllegalArgumentException("Index out of range. Must be between 1 and " + ITEMS.size());

        // Get item and price by index
        String item = ITEMS.get(index).getText();

        // Validate that the price is correct
        if (ITEMS_AND_PRICES.containsKey(item))
            PRICES.get(index).shouldHave(text(ITEMS_AND_PRICES.get(item)));
        else
            throw new AssertionError("Unexpected item: " + item);

        return this;
    }
}