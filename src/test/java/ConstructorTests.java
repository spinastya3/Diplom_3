import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTests extends BaseTest{

    @Test
    @DisplayName("Проверка переключения на вкладку Булки")
    public void checkBunTabisOpen(){

        burgerMainPage.clickSaucesTab()
                .clickBunTab();
        assertTrue("Вкладка Булки не активна", burgerMainPage.bunTabActive());
    }

    @Test
    @DisplayName("Проверка переключения на вкладку Соусы")
    public void checkSaucesTabisOpen(){

        burgerMainPage.clickSaucesTab();
        assertTrue("Вкладка Соусы не активна", burgerMainPage.saucesTabActive());
    }

    @Test
    @DisplayName("Проверка переключения на вкладку Начинки")
    public void checkFillingsTabisOpen(){

        burgerMainPage.clickFillingsTab();
        assertTrue("Вкладка Начинки не активна", burgerMainPage.fillingsTabActive());
    }
}
