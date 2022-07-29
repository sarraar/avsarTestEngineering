@test
Feature: Amazon Produktsuche zu bedienen und zu testen

  Scenario:
    Given Öffne die URL "https://www.amazon.de" in CHROME
    When Suche nach "Adidas Schuhe"
    And Selektiere das erste Ergebnis
    Then Wähle eine beliebige Größe aus
    And klicke auf "In den Einkaufswagen"

