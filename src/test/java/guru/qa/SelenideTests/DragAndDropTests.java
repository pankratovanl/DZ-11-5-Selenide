package guru.qa.SelenideTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTests {
    @Test

    void MakingDragAndDropTests(){
        //Открыть страницу https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Проверить, что на странице есть текст "Drag and Drop"
        $("h3").shouldHave(text("Drag and Drop"));
        //Прямоугольник А перетащить на прямоугольник В
        $("#column-a").dragAndDropTo("#column-b");
        //Проверить, что А занял место В
        $("#column-a").shouldHave(text("B"));
        //Проверить, что В занял место А
        $("#column-b").shouldHave(text("A"));

    }
}
