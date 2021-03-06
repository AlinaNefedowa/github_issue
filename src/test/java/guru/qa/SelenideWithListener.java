package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWithListener {

        @Test
        @Owner("AlinaNefedowa")
        @Severity(SeverityLevel.NORMAL)
        @Link(value="GitHub",url = "https://github.com")
        @Feature("Issues in repository")
        @Story("The issue in repository should be visible")
        @DisplayName("Тест на проверку вкладки issue")
        public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("AlinaNefedowa/github_issue");
        $(".header-search-input").submit();

        $(By.linkText("AlinaNefedowa/github_issue")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("#1")).should(Condition.exist);
        }

}