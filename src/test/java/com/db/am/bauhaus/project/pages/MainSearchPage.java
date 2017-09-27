package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = "#gnav-search .btn.btn-primary")
    WebElementFacade searchButton;

    @FindBy(css = "#content .mt-xs-2.pl-xs-1 .text-gray-lighter :nth-last-child(2)")
    WebElementFacade dropDownTopCategoryHeader;

    @FindBy(css = "#search-suggestions .normal")
    WebElementFacade searchSuggestions;

    private final By JEWELLERY_SELECTOR = By.linkText("Jewellery");

    private final By JEWELLERY_ANKLETS_SELECTOR = By.linkText("Anklets");

    private final String SHOP_BY_CATEGORY_SELECTOR_STR = ".vesta-hp-category-default .vesta-hp-category-card:nth-child(1)";

    private final By SHOP_BY_CATEGORY_SELECTOR = By.cssSelector(SHOP_BY_CATEGORY_SELECTOR_STR);

    private final By SHOP_BY_CATEGORY_NAME_SELECTOR = By.cssSelector(SHOP_BY_CATEGORY_SELECTOR_STR + " .vesta-hp-category-title");

    private final By SEARCH_SUGGESTIONS_SELECTOR = By.cssSelector("#search-suggestions .as-suggestion");


    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        setSearchTextInInputBox(searchText);
        searchButton.click();
    }

    public void setSearchTextInInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
    }

    public String getTopCategoriesHeader() {
        return find(By.cssSelector(".pb-xs-1-5 .float-left")).getText();
    }

    public String getAllCategoriesHeader() {
        return find(By.cssSelector("h1.display-inline.text-smaller")).getText();
    }

    public void searchFromDropDownMenu() {
        find(JEWELLERY_SELECTOR).click();
        find(JEWELLERY_ANKLETS_SELECTOR).waitUntilClickable().click();
    }

    public String getDropDownResultTopCategoriesHeader() {
        return dropDownTopCategoryHeader.getText();
    }

    public String getSearchCategoryName() {
        return find(SHOP_BY_CATEGORY_NAME_SELECTOR).waitUntilPresent().getText();
    }

    public void searchFromCategoryIcon() {
        find(SHOP_BY_CATEGORY_SELECTOR).click();
    }

    public List<String> getSearchSuggestionsList() {
        waitForElementToPresent(SEARCH_SUGGESTIONS_SELECTOR, 10);
        return findAll(SEARCH_SUGGESTIONS_SELECTOR).stream()
                .map(wef -> wef.getText()).collect(Collectors.toList());
    }

    public void waitForElementToPresent(final By element, final int waitTime) {
        try {
            (new WebDriverWait(getDriver(), waitTime))
                    .until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (TimeoutException te) {
//            if catches time out exception do nothing

        }
    }

}
