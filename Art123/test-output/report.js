$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Selenium_Automationframework/Art123/src/main/java/Feature/FBmap.feature");
formatter.feature({
  "line": 1,
  "name": "FB Login Automation",
  "description": "",
  "id": "fb-login-automation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Login to FB",
  "description": "",
  "id": "fb-login-automation;login-to-fb",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user is already on FB  Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enters login credentials",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ],
      "line": 7
    },
    {
      "cells": [
        "sagarforjob28@gmail.com",
        "Password@12345"
      ],
      "line": 8
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user clicks on login",
  "keyword": "And "
});
formatter.match({
  "location": "FBmapStepDefinition.user_is_already_on_FB_Page()"
});
formatter.result({
  "duration": 19404893109,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});