package de.avsar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(id = "native_dropdown_selected_size_name")
    public WebElement dropdownSelect;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartBtn;

    @FindBy(id = "productTitle")
    public WebElement productTitle;

    @FindBy(id = "color_name_1")
    public WebElement chooseColor;

    @FindBy(className = "swatchAvailable")
    public WebElement availableColour;

    @FindBy(xpath = "//span[contains(text(),'Zum Einkaufswagen hinzugefügt')]")
    public WebElement einkaufswgnHinfgnText;

}
