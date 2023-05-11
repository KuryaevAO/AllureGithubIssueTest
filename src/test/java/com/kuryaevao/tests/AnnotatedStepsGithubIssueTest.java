package com.kuryaevao.tests;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsGithubIssueTest extends TestBase {

    String REPOSITORY = "kuryaevao/";

    @Test
    void AnnotatedStepsFindIssueTest() {

        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.checkResults();
        steps.selectProject();
        steps.checkProject();
        steps.openIssues();
        steps.checkIssues();
    }
}
