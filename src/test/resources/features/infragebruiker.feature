#language: nl

Functionaliteit: Infragebruiker Tranformer Demo

  Scenario: Converteer NSR naar NS-Reizigers
    Stel ik heb een infragebruiker "NSR"
    Dan is het deze bekend als "NS-Reizigers"

  Scenario: Converteer NSI naar NSInternational
    Stel ik heb een infragebruiker "NSI"
    Dan is het deze bekend als "NS_International"

  Scenario: Converteer blanco
    Stel ik heb een infragebruiker ""
    Dan is het deze bekend als "NS-Reizigers"