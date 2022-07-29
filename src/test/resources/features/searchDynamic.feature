@test
Feature: Dynamische Amazon Produktsuche  zu bedienen und zu testen

  Background:
    Given Öffne die URL

  Scenario Outline:
    When Suche nach "<produkt>"
    And Selektiere das erste Ergebnis
    Then Wähle eine beliebige Größe aus
    And klicke auf "In den Einkaufswagen"

    Examples:
      | produkt                               |
      | Adidas Herren Questar Flow Laufschuhe |
      | Puma Tazon 6                          |
      | Nike Air Max                          |


