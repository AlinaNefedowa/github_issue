package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTests {

    private static final String repository = "AlinaNefedowa/github_issue";
    private static final int issue_number = 1;

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.openRepository(repository);
        steps.goToIssueTab();
        steps.checkThatIssueExists(issue_number);

    }
}
