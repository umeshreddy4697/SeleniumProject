Feature: Validate different scenario's

  @Test_1 @Initialize_Driver @Quit_Driver
  Scenario: Print first 10 elements from drop down
    Given launch chrome browser with url "https://www.globalsqa.com/demo-site/select-dropdown-menu/"
    Then print first 10 elements from dropdown

  @Test_2 @Initialize_Driver @Quit_Driver
  Scenario: Drag and Drop functionality
    Given launch chrome browser with url "https://www.globalsqa.com/demo-site/select-dropdown-menu/"
    Then click on drag and drop
    Then perform drag and drop

  @Test_3 @Initialize_Driver @Quit_Driver
  Scenario: Select Date functionality
    Given launch chrome browser with url "https://www.globalsqa.com/demo-site/select-dropdown-menu/"
    Then click on date picker
    Then select date "13"