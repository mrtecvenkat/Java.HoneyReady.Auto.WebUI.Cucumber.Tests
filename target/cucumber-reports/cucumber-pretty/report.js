$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AppHome.feature");
formatter.feature({
  "line": 1,
  "name": "App Home",
  "description": "",
  "id": "app-home",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Welcome message test ONE",
  "description": "",
  "id": "app-home;welcome-message-test-one",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I logged in to the app \u0027soneuser\u0027 as admin",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I click on \u0027Contacts\u0027 menu item from \u0027Contact\u0027 menu",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I click on \u0027Create contact\u0027 button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I create contacts with below deatils",
  "rows": [
    {
      "cells": [
        "Email",
        "FirstName",
        "LastName"
      ],
      "line": 8
    },
    {
      "cells": [
        "someone@gmail.com",
        "First001",
        "section001"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "soneuser",
      "offset": 24
    }
  ],
  "location": "CommonStepDef.iLoggedInToTheAppSoneuserAsAdmin(String)"
});
formatter.result({
  "duration": 22881150700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Contacts",
      "offset": 12
    },
    {
      "val": "Contact",
      "offset": 38
    }
  ],
  "location": "CommonStepDef.iClickOnContactsMenuItemFromContactMenu(String,String)"
});
formatter.result({
  "duration": 4263824900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Create contact",
      "offset": 12
    }
  ],
  "location": "CommonStepDef.iClickOnCreateContactButton(String)"
});
formatter.result({
  "duration": 1931421900,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepDef.iCreateContactsWithBelowDeatils(DataTable)"
});
formatter.result({
  "duration": 3574705300,
  "status": "passed"
});
});