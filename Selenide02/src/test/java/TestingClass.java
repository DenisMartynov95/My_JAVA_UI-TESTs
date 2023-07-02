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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestingClass extends BaseUrl {

    @ParameterizedTest
    @CsvSource({
            "idenismartynov@yandex.ru, 123456",
            " , 1234324342432",
            "jensenmartmusic@yandex.ru, d3m322sq5"
    })
    public void testAutorization(String login, String password) {
        openFirstUrl();

            //Нажатие на кнопку авторизации и ожидание определенного элемента, тк он долго обычно грузится
        $(byClassName("login_btn")).click();
        $(byId("si-mail")).shouldBe(enabled);//Использовал enabled, тк нужно контактировать с данным полем и он должен быть доступен для взаимодествия

            //Взаимодействия с полями авторизации, тут и вступает моя параметризация
        $(byId("si-mail"))
                .setValue(login);
        $(byId("si-passwd"))
                .setValue(password);

        if (login.isEmpty() || password.isEmpty()) {
            String errorMessage = "Тест не прошел - невалидный параметризированный вариант: login = " + login + ", password = " + password;
            System.out.println(errorMessage);
                    assertTrue(false);
        }
    }

}
