package de.avsar.step_definitions;

import de.avsar.pages.ProductPage;
import de.avsar.pages.SearchPage;
import de.avsar.utilities.BrowserUtils;
import de.avsar.utilities.ConfigurationReader;
import de.avsar.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchItemStepDefs {

    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();

    @Given("Öffne die URL {string} in CHROME")
    public void öffne_die_URL_in_CHROME(String url) {
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        assertEquals("Die Amazon Startseite wird nicht aufgerufen", "https://www.amazon.de/", Driver.get().getCurrentUrl());
        searchPage.cookiesAccptBtn.click();
    }

    @When("Suche nach {string}")
    public void suche_nach(String string) {
        searchPage.sucheTextBox.sendKeys(string);
        searchPage.submitBtn.click();
        assertTrue("5 Schuhe sind nicht angezeigt.", searchPage.searchResults.size() > 5);
    }

    @When("Selektiere das erste Ergebnis")
    public void selektiere_das_erste_Ergebnis() {
        String expectedResult;

        for (int i = 2; i < 20; i++) {
            WebElement dynamicEle = Driver.get().findElement(By.xpath("//div[@data-index='" + i + "']"));

            if (!dynamicEle.getText().contains("Gesponsert")) {
                BrowserUtils.waitFor(1);
                expectedResult = dynamicEle.getText();
                dynamicEle.click();
               assertTrue("Das Produkt wird nicht erfolgreich aufgerufen",expectedResult.contains(productPage.productTitle.getText().substring(0,3)));
                break;
            }
        }
    }

    @Then("Wähle eine beliebige Größe aus")
    public void wähle_eine_beliebige_Größe_aus() {
        Select selectSize = new Select(productPage.dropdownSelect);
        selectSize.selectByIndex(1);
        BrowserUtils.waitFor(2);
        if (!productPage.addToCartBtn.isDisplayed()) {
            productPage.availableColour.click();
        }
    }

    @Given("Öffne die URL")
    public void öffneDieURL() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        assertEquals("https://www.amazon.de/", Driver.get().getCurrentUrl());
        searchPage.cookiesAccptBtn.click();
    }

    @And("klicke auf In den Einkaufswagen")
    public void klickeAufInDenEinkaufswagen() {
        BrowserUtils.waitFor(2);
        productPage.addToCartBtn.click();
        assertTrue(productPage.einkaufswgnHinfgnText.isDisplayed());
    }

    @And("Öffne den Einkaufswagen")
    public void öffneDenEinkaufswagen() {
        productPage.einkaufswagen.click();
    }

    @Then("überprüfe die Texte")
    public void überprüfeDieTexte(List<String> text) {
        BrowserUtils.waitFor(2);
        for (String texts : text) {
            assertTrue("Im Einkaufswagen ist die Product nicht zu finden",Driver.get().getPageSource().contains(texts));
        }
    }


}
