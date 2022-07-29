package de.avsar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = " (//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    public WebElement firstResult;

    @FindBy(xpath = " (//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")
    public WebElement secondResult;

    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public List<WebElement> searchResults;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    public WebElement firstResultText;

    public String getText() {
        return firstResultText.getText();
    }

}
