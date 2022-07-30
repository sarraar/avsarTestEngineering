package de.avsar.pages;

import de.avsar.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "sp-cc-accept")
    public WebElement cookiesAccptBtn;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement sucheTextBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitBtn;

    @FindBy(id = "nav-cart-count")
    public WebElement einkaufswagen;


}
