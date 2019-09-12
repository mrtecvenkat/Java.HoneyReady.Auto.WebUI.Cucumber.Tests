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
  "name": "I can open \"someurl\" in the \"chrome\" browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I can do it",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "someurl",
      "offset": 12
    },
    {
      "val": "chrome",
      "offset": 29
    }
  ],
  "location": "CommonStepDef.iCanOpenSomeUrlInTheBrowseer(String,String)"
});
formatter.result({
  "duration": 91369300,
  "status": "passed"
});
formatter.match({
  "location": "HellowOne.iCanDoIt()"
});
formatter.result({
  "duration": 53700,
  "status": "passed"
});
});