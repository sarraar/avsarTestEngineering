@test
Feature: Dynamische Amazon Produktsuche  zu bedienen und zu testen

  Background:
    Given Öffne die URL

  Scenario: Testfall 1
    When Suche nach "Adidas Schuhe"
    And Selektiere das erste Ergebnis
    Then Wähle eine beliebige Größe aus
    And klicke auf In den Einkaufswagen


  Scenario: Testfall 2
    When Suche nach "Adidas Herren Questar Flow Laufschuhe"
    And Selektiere das erste Ergebnis
    Then Wähle eine beliebige Größe aus
    And klicke auf In den Einkaufswagen
    When Suche nach "Puma Tazon 6 "
    And Selektiere das erste Ergebnis
    Then Wähle eine beliebige Größe aus
    And klicke auf In den Einkaufswagen
    When Suche nach "Nike Air Max"
    And Selektiere das erste Ergebnis
    Then Wähle eine beliebige Größe aus
    And klicke auf In den Einkaufswagen


