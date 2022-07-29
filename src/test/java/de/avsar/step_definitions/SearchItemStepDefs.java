package de.avsar.step_definitions;

import de.avsar.pages.SchuhePage;
import de.avsar.pages.HomePage;
import de.avsar.pages.SearchPage;
import de.avsar.utilities.BrowserUtils;
import de.avsar.utilities.ConfigurationReader;
import de.avsar.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class SearchItemStepDefs {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    SchuhePage schuhePage = new SchuhePage();

    @Given("Öffne die URL {string} in CHROME")
    public void öffne_die_URL_in_CHROME(String url) {
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        Assert.assertEquals("Die Amazon Startseite wird erfolgreich aufgerufen", "https://www.amazon.de/", Driver.get().getCurrentUrl());
        homePage.cookiesAccptBtn.click();
    }

    @When("Suche nach {string}")
    public void suche_nach(String string) {
        homePage.searchTextBox.sendKeys(string);
        homePage.submitBtn.click();
        Assert.assertTrue("Es werden mindestens 5 Schuhe angezeigt.", searchPage.searchResults.size() > 5);
    }

    @When("Selektiere das erste Ergebnis")
    public void selektiere_das_erste_Ergebnis() {
        String expectedResult = searchPage.getText();
        searchPage.firstResult.click();

        String actualResult = schuhePage.productTitle.getText();
//        Assert.assertTrue();
//      String actualResult =
//
//        System.out.println("actualResult = " + actualResult);
//
        Assert.assertTrue("Das Produkt wird erfolgreich aufgerufen", actualResult.contains(expectedResult));
    }

    @Then("Wähle eine beliebige Größe aus")
    public void wähle_eine_beliebige_Größe_aus() {
        Select selectSize = new Select(schuhePage.dropdownSelect);
        selectSize.selectByIndex(1);
    }

    @Then("klicke auf {string}")
    public void klicke_auf(String string) {
        BrowserUtils.waitFor(5);
        schuhePage.addToCartBtn.click();
        BrowserUtils.waitFor(5);
        Assert.assertTrue(schuhePage.einkaufswgnHinfgnText.isDisplayed());
    }


    @Given("Öffne die URL")
    public void öffneDieURL() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        Assert.assertEquals("https://www.amazon.de/", Driver.get().getCurrentUrl());
        homePage.cookiesAccptBtn.click();
    }


}
