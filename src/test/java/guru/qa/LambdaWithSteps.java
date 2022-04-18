package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaWithSteps {

        private static final String repository = "AlinaNefedowa/github_issue";
        private static final int issue_number = 1;

        @Test
        public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

                step("Open the main page", () -> {
                        open("https://github.com");
                });

                step("Search for a repository " + repository, () -> {
                        $(".header-search-input").click();
                        $(".header-search-input").sendKeys(repository);
                        $(".header-search-input").submit();
                });

                step("Open the repository " + repository, () -> {
                        $(By.linkText(repository)).click();
                });
                step("Go to the issue tab", () -> {
                        $(By.partialLinkText("Issues")).click();

                });
                step("Check that the issue " + issue_number + " exists", () -> {
                        $(withText("#" + issue_number)).should(Condition.exist);
                });
        }
}