@test
Feature: Dynamische Amazon Produktsuche  zu bedienen und zu testen

  Background:
    Given Öffne die URL

  Scenario: Testfall 1
    When Suche nach "Adidas Schuhe"
    And Selektiere das erste Ergebnis
    And Wähle eine beliebige Größe aus
    And klicke auf In den Einkaufswagen


  Scenario: Testfall 2
    When Suche nach "Adidas Herren Questar Flow Laufschuhe"
    And Selektiere das erste Ergebnis
    And Wähle eine beliebige Größe aus
    And klicke auf In den Einkaufswagen
    And Suche nach "Puma Tazon 6 "
    And Selektiere das erste Ergebnis
    And Wähle eine beliebige Größe aus
    And klicke auf In den Einkaufswagen
    And Suche nach "Nike Air Max"
    And Selektiere das erste Ergebnis
    And Wähle eine beliebige Größe aus
    And klicke auf In den Einkaufswagen
    And Öffne den Einkaufswagen
    Then überprüfe die Texte
      | adidas  |
      | Herren  |
      | Questar |
      | Flow    |
      | Puma    |
      | Tazon 6 |
      | Nike    |
      | Air Max |



