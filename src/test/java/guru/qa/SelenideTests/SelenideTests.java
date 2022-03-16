package guru.qa.SelenideTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

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
        $("h1").shouldHave(Condition.text("selenide / selenide")).click();
        //
    }
}

//ARRANGE - подготовка данных
//ACT - выполнение действий
//ASSERT - проверка разельтатов

