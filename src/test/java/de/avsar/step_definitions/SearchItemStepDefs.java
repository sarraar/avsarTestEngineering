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
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class SearchItemStepDefs {

    SearchPage searchPage = new SearchPage();
    ProductPage schuhePage = new ProductPage();

    @Given("Öffne die URL {string} in CHROME")
    public void öffne_die_URL_in_CHROME(String url) {
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        Assert.assertEquals("Die Amazon Startseite wird erfolgreich aufgerufen", "https://www.amazon.de/", Driver.get().getCurrentUrl());
        searchPage.cookiesAccptBtn.click();
    }

    @When("Suche nach {string}")
    public void suche_nach(String string) {
        searchPage.searchTextBox.sendKeys(string);
        searchPage.submitBtn.click();
        Assert.assertTrue("Es werden mindestens 5 Schuhe angezeigt.", searchPage.searchResults.size() > 5);
    }

    @When("Selektiere das erste Ergebnis")
    public void selektiere_das_erste_Ergebnis() {

//        if (searchPage.firstResult.)
       // [text()='Gesponsert']

        String expectedResult = searchPage.getText();
        searchPage.firstResult.click();
        String actualResult = schuhePage.productTitle.getText();
        Assert.assertTrue("Das Produkt wird erfolgreich aufgerufen", actualResult.contains(expectedResult));
    }

    @Then("Wähle eine beliebige Größe aus")
    public void wähle_eine_beliebige_Größe_aus() {
        Select selectSize = new Select(schuhePage.dropdownSelect);
        selectSize.selectByIndex(1);
    }


    @Given("Öffne die URL")
    public void öffneDieURL() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        Assert.assertEquals("https://www.amazon.de/", Driver.get().getCurrentUrl());
        searchPage.cookiesAccptBtn.click();
    }

    @And("klicke auf In den Einkaufswagen")
    public void klickeAufInDenEinkaufswagen() {
        BrowserUtils.waitFor(2);
        schuhePage.addToCartBtn.click();
        Assert.assertTrue(schuhePage.einkaufswgnHinfgnText.isDisplayed());
    }
}
