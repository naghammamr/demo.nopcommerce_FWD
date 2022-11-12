@smoke
  Feature: F05_HoverCategories | Verify that user can select sub-category when hover on its main category
    Scenario: User can hover on one of main categories then click on sub category
      Given user hovers on a main-category
      When the sub category list open
      Then user can click on any sub-category
      And then the user will be redirected to the sub-category page