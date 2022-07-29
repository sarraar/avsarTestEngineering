package de.avsar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Ergebnisse für')]")
    public WebElement ErgebnisseText;

    //    @FindBy(xpath = "(//span[@data-component-type='s-product-image'])[1]")
//    public WebElement firstResult;

    @FindBy(xpath = " (//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    public WebElement firstResult;

    //    @FindBy(xpath = "//div[@class='sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20']")
//    public List<WebElement> searchResults;

    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public List<WebElement> searchResults;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    public WebElement firstResultText;


    public String getText() {
        //System.out.println("firstResult.getText() = " + firstResult.getText());
        return firstResultText.getText();
    }


}
