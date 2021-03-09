$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CompareCards.feature");
formatter.feature({
  "line": 2,
  "name": "Compare the cards and print similarities and differences between cards",
  "description": "",
  "id": "compare-the-cards-and-print-similarities-and-differences-between-cards",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@CompareCards"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Compare Cards",
  "description": "",
  "id": "compare-the-cards-and-print-similarities-and-differences-between-cards;compare-cards",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@CompareCards"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I navigate to dbs credit cards page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I select two cards \"\u003ccard1\u003e\" and \"\u003ccard2\u003e\" on credit cards page",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Print the similarities and differences between the cards",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "compare-the-cards-and-print-similarities-and-differences-between-cards;compare-cards;",
  "rows": [
    {
      "cells": [
        "card1",
        "card2"
      ],
      "line": 11,
      "id": "compare-the-cards-and-print-similarities-and-differences-between-cards;compare-cards;;1"
    },
    {
      "cells": [
        "DBS Altitude Visa Signature Card",
        "DBS Black Visa Card"
      ],
      "line": 12,
      "id": "compare-the-cards-and-print-similarities-and-differences-between-cards;compare-cards;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4413291300,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Compare Cards",
  "description": "",
  "id": "compare-the-cards-and-print-similarities-and-differences-between-cards;compare-cards;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@CompareCards"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I navigate to dbs credit cards page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I select two cards \"DBS Altitude Visa Signature Card\" and \"DBS Black Visa Card\" on credit cards page",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Print the similarities and differences between the cards",
  "keyword": "Then "
});
formatter.match({
  "location": "DbsStepDefs.i_navigate_to_dbs_credit_cards_page()"
});
formatter.result({
  "duration": 12376202300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DBS Altitude Visa Signature Card",
      "offset": 20
    },
    {
      "val": "DBS Black Visa Card",
      "offset": 59
    }
  ],
  "location": "DbsStepDefs.i_select_two_cards_DBS_Altitude_Visa_Signature_Card_and_DBS_Black_Visa_Card_on_credit_cards_page(String,String)"
});
formatter.result({
  "duration": 9945901100,
  "status": "passed"
});
formatter.match({
  "location": "DbsStepDefs.print_the_similarities_and_differences_between_the_cards()"
});
formatter.result({
  "duration": 43401782500,
  "error_message": "org.assertj.core.api.SoftAssertionError: \r\nThe following 3 assertions failed:\r\n1) expected:\u003c\"[Shopping is the new black]\"\u003e but was:\u003c\"[It\u0027s the fastest way to fly anywhere.]\"\u003e\r\n2) expected:\u003c\"[Enjoy great dining privileges with the DBS Lifestyle app.]\"\u003e but was:\u003c\"[N/A]\"\u003e\r\n3) expected:\u003c\"Enjoy [great travel privileges with the DBS Lifestyle app.]\"\u003e but was:\u003c\"Enjoy [exclusive hotel and travel privileges with DBS Altitude Card]\"\u003e\r\n\r\n\tat org.assertj.core.error.AssertionErrorCreator.multipleSoftAssertionsError(AssertionErrorCreator.java:75)\r\n\tat org.assertj.core.api.AbstractSoftAssertions.assertAll(AbstractSoftAssertions.java:38)\r\n\tat org.assertj.core.api.AbstractSoftAssertions.assertAll(AbstractSoftAssertions.java:43)\r\n\tat com.dbs.pages.DBSCreditCardsPage.healthCare(DBSCreditCardsPage.java:231)\r\n\tat com.dbs.stepDefinitions.DbsStepDefs.print_the_similarities_and_differences_between_the_cards(DbsStepDefs.java:45)\r\n\tat ✽.Then Print the similarities and differences between the cards(CompareCards.feature:8)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 826862800,
  "status": "passed"
});
});