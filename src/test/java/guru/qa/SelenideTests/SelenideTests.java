package guru.qa.SelenideTests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {

    @Test
    void shouldFindSelenideInGithub() {
        // открыть страницу github.com
        open("http://github.com/");

        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();

        //нажать на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();

        //check: в заголовке встречается selenide/selenide, кликнуть
        $("h1").shouldHave(text("selenide / selenide")).click();

        //Перейти в раздел Wiki проекта
        $("#wiki-tab.UnderlineNav-item").click();

        //check: в списке странц Pages есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=\"wiki-pages-filter\"]").$(byText("SoftAssertions")).click();

        //check: внутри есть пример кода для JUnit5
        $$("h4").findBy(text("Using JUnit5 extend test class:")).sibling(0).shouldHave(text("SoftAssertsExtension.class"));

    }
}

//ARRANGE - подготовка данных
//ACT - выполнение действий
//ASSERT - проверка разельтатов

