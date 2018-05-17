$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/CreateProject.feature");
formatter.feature({
  "name": "Create Project",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "With valid credentials account",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I put a valid user and Password",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.iPutAValidAnd()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create Project",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@acceptance"
    }
  ]
});
formatter.step({
  "name": "I can create a new project with the following values",
  "rows": [
    {
      "cells": [
        "PROJECT_TITLE",
        "Projectx"
      ]
    },
    {
      "cells": [
        "PROJECT_ACCOUNT",
        "Fundacion"
      ]
    },
    {
      "cells": [
        "PROJECT_VISIBLE",
        "public"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectStep.iCanCreateANewProjectWithTheFollowingValues(ProjectDescription,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can verify the new project with \"Projectx\" project name",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectStep.iCanVerifyTheNewProjectWithProjectName(String)"
});
formatter.result({
  "status": "passed"
});
});