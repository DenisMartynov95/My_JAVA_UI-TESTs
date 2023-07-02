import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.files.DownloadActions.click;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;

public class TestingClass extends BaseUrl { // В этот раз УРЛ перенес в отдельный класс, чтобы затем наследовать его

    @Test
    public void testOrder() throws InterruptedException {
        openPage();

// 1 Шаг Принял куки
        $(byText("да все привыкли")).click();

// 2 Шаг Нажал на кнопку Заказать
        $(byText("Заказать")).click();

// 3 Шаг В открытом окне заполняю поля для ввода
        $(byXpath(".//input[@placeholder='* Имя']")).setValue("Денис");

        $(byXpath(".//input[@placeholder='* Фамилия']")).setValue("Мартынов");

        $(byXpath(".//input[@placeholder='* Адрес: куда привезти заказ']")).setValue("Мартыново");

        //Сложное взаимодействие с выпадающим списком
        $(byXpath(".//input[@placeholder='* Станция метро']"))
                .setValue("Комсомольская"); //Сначала ввел нужное метро
        /*Далее нахожу элемент по CSS-селектору,
        который начинается с класса "Select-search" и заканчивается на "is-focused", но не выполняю с ним никаких действий, тк далее нужно кликнуть по нему
        */
        $("[class^='Select-search'][class$='is-focused']");
        // Открылся выпадающий список и там я нахожу уже нужное метро в выпадающем списке
        $(byXpath(".//li[@data-index='0']"))
                .click();

        $(byXpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")).setValue("79224313156");
        $(byText("Далее")).click();

//4 Шаг Заполнение полей для ввода на странице "Про аренду"
        $(byText("Про аренду")).shouldHave(text("Про аренду")); // Подождал когда появится заголовок и полетел дальше

        $(byXpath(".//input[@placeholder='* Когда привезти самокат']")).setValue("20.04.2024").pressEnter();

        $(byClassName("Dropdown-placeholder")).click();
        $(byText("четверо суток")).click();

        $(byXpath(".//input[@id = 'black']")).click();

        $(byXpath(".//input[@placeholder = 'Комментарий для курьера']")).setValue("Привезите мне его со 100% зарядом пожалуйста");

        //Нажать кнопку "Заказать" после заполнения всех полей
        $(byXpath("/html/body/div/div/div[2]/div[3]/button[2]")).click();

        //Ожидание окна подтверждения
        $(byClassName("Order_ModalHeader__3FDaJ")).shouldHave(text("Хотите оформить заказ?"));
        //Как только появилось - нажимаю кнопку "Да"
        $(byXpath(".//div[2][@class='Order_Content__bmtHS']//div[2][@class='Order_Buttons__1xGrp']//button[2][@class='Button_Button__ra12g Button_Middle__1CSJM']"))
        .doubleClick();

        System.out.println("Кнопка Да не работает ");
    }
}
