Feature:VirginGames bingo data

  As a user I want to get all jackpot bingo data from VirginGames API

  Scenario:User want to get all VirginGames Bingo Data
    When I send a get request
    Then I get valid response code "200"
    And I verify currency GBP
    And I verify name is BubbleUpBingoVGN in bingo data
    Then I verify id 2641 is equal to BubbleUpBingoVGN in data
