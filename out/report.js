$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/Cucumber/Features/addAddress.feature");
formatter.feature({
  "line": 1,
  "name": "Add new address",
  "description": "",
  "id": "add-new-address",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Adding new shipping address",
  "description": "",
  "id": "add-new-address;adding-new-shipping-address",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User is logged in to PrestaShop",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User goes to Address Page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User fulfills necessary pages, keyword \u003calias\u003e, keyword \u003ccompany\u003e, keyword \u003caddress\u003e, keyword \u003cpostcode\u003e, keyword \u003ccity\u003e, keyword \u003cphone\u003e, keyword \u003ccountryValue\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User submits changes",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User see \"\u003ccreationMessage\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Validate address data, keyword \u003calias\u003e, keyword \u003ccompany\u003e, keyword \u003caddress\u003e, keyword \u003cpostcode\u003e, keyword \u003ccity\u003e, keyword \u003cphone\u003e, keyword \u003ccountry\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Quit browser",
  "keyword": "And "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "add-new-address;adding-new-shipping-address;",
  "rows": [
    {
      "cells": [
        "creationMessage",
        "alias",
        "company",
        "address",
        "postcode",
        "city",
        "phone",
        "countryValue",
        "country"
      ],
      "line": 12,
      "id": "add-new-address;adding-new-shipping-address;;1"
    },
    {
      "cells": [
        "Address successfully added!",
        "Your polarBear Company",
        "Your polarBear company",
        "Wroblewskiego 1-5",
        "51-618",
        "Wroclaw",
        "999999999",
        "17",
        "United Kingdom"
      ],
      "line": 13,
      "id": "add-new-address;adding-new-shipping-address;;2"
    },
    {
      "cells": [
        "Address successfully added!",
        "Your polarBear2 Company",
        "Your polarBear2 company",
        "Wroblewskiego 1-5",
        "51-618",
        "Wroclaw",
        "999999999",
        "17",
        "United Kingdom"
      ],
      "line": 14,
      "id": "add-new-address;adding-new-shipping-address;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Adding new shipping address",
  "description": "",
  "id": "add-new-address;adding-new-shipping-address;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User is logged in to PrestaShop",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User goes to Address Page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User fulfills necessary pages, keyword Your polarBear Company, keyword Your polarBear company, keyword Wroblewskiego 1-5, keyword 51-618, keyword Wroclaw, keyword 999999999, keyword 17",
  "matchedColumns": [
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User submits changes",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User see \"Address successfully added!\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Validate address data, keyword Your polarBear Company, keyword Your polarBear company, keyword Wroblewskiego 1-5, keyword 51-618, keyword Wroclaw, keyword 999999999, keyword United Kingdom",
  "matchedColumns": [
    1,
    2,
    3,
    4,
    5,
    6,
    8
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Quit browser",
  "keyword": "And "
});
formatter.match({
  "location": "AddAddress.userIsLoggedInToPrestaShop()"
});
formatter.result({
  "duration": 5261745313,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.userGoesToAddressPage()"
});
formatter.result({
  "duration": 1270175183,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Your polarBear Company",
      "offset": 39
    },
    {
      "val": "Your polarBear company",
      "offset": 71
    },
    {
      "val": "Wroblewskiego 1-5",
      "offset": 103
    },
    {
      "val": "51-618",
      "offset": 130
    },
    {
      "val": "Wroclaw",
      "offset": 146
    },
    {
      "val": "999999999",
      "offset": 163
    },
    {
      "val": "17",
      "offset": 182
    }
  ],
  "location": "AddAddress.userFulfillsNecessaryPagesKeywordAliasKeywordCompanyKeywordAddressKeywordPostcodeKeywordCityKeywordPhoneKeywordCountryvalue(String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 2014312232,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.userSubmitsChanges()"
});
formatter.result({
  "duration": 550827098,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Address successfully added!",
      "offset": 10
    }
  ],
  "location": "AddAddress.userSee(String)"
});
formatter.result({
  "duration": 71817373,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Your polarBear Company",
      "offset": 31
    },
    {
      "val": "Your polarBear company",
      "offset": 63
    },
    {
      "val": "Wroblewskiego 1-5",
      "offset": 95
    },
    {
      "val": "51-618",
      "offset": 122
    },
    {
      "val": "Wroclaw",
      "offset": 138
    },
    {
      "val": "999999999",
      "offset": 155
    },
    {
      "val": "United Kingdom",
      "offset": 174
    }
  ],
  "location": "AddAddress.validateAddressDataKeywordAliasKeywordCompanyKeywordAddressKeywordPostcodeKeywordCityKeywordPhoneKeywordCountryvalue(String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 987877915,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.quitBrowser()"
});
formatter.result({
  "duration": 127167422,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Adding new shipping address",
  "description": "",
  "id": "add-new-address;adding-new-shipping-address;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User is logged in to PrestaShop",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User goes to Address Page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User fulfills necessary pages, keyword Your polarBear2 Company, keyword Your polarBear2 company, keyword Wroblewskiego 1-5, keyword 51-618, keyword Wroclaw, keyword 999999999, keyword 17",
  "matchedColumns": [
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User submits changes",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User see \"Address successfully added!\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Validate address data, keyword Your polarBear2 Company, keyword Your polarBear2 company, keyword Wroblewskiego 1-5, keyword 51-618, keyword Wroclaw, keyword 999999999, keyword United Kingdom",
  "matchedColumns": [
    1,
    2,
    3,
    4,
    5,
    6,
    8
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Quit browser",
  "keyword": "And "
});
formatter.match({
  "location": "AddAddress.userIsLoggedInToPrestaShop()"
});
formatter.result({
  "duration": 3874444267,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.userGoesToAddressPage()"
});
formatter.result({
  "duration": 1181752422,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Your polarBear2 Company",
      "offset": 39
    },
    {
      "val": "Your polarBear2 company",
      "offset": 72
    },
    {
      "val": "Wroblewskiego 1-5",
      "offset": 105
    },
    {
      "val": "51-618",
      "offset": 132
    },
    {
      "val": "Wroclaw",
      "offset": 148
    },
    {
      "val": "999999999",
      "offset": 165
    },
    {
      "val": "17",
      "offset": 184
    }
  ],
  "location": "AddAddress.userFulfillsNecessaryPagesKeywordAliasKeywordCompanyKeywordAddressKeywordPostcodeKeywordCityKeywordPhoneKeywordCountryvalue(String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 1708195925,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.userSubmitsChanges()"
});
formatter.result({
  "duration": 478963732,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Address successfully added!",
      "offset": 10
    }
  ],
  "location": "AddAddress.userSee(String)"
});
formatter.result({
  "duration": 75747055,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Your polarBear2 Company",
      "offset": 31
    },
    {
      "val": "Your polarBear2 company",
      "offset": 64
    },
    {
      "val": "Wroblewskiego 1-5",
      "offset": 97
    },
    {
      "val": "51-618",
      "offset": 124
    },
    {
      "val": "Wroclaw",
      "offset": 140
    },
    {
      "val": "999999999",
      "offset": 157
    },
    {
      "val": "United Kingdom",
      "offset": 176
    }
  ],
  "location": "AddAddress.validateAddressDataKeywordAliasKeywordCompanyKeywordAddressKeywordPostcodeKeywordCityKeywordPhoneKeywordCountryvalue(String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 1034631999,
  "status": "passed"
});
formatter.match({
  "location": "AddAddress.quitBrowser()"
});
formatter.result({
  "duration": 71228318,
  "status": "passed"
});
});