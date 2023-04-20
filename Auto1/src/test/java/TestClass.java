import org.junit.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Praktikum {

    @Test
    public void test() {
        // Селенид сам создает браузер
        // перейду на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполню авторизацию
        $(byId("email")).setValue("jensenmartmusic@yandex.ru");
        $(byId("password")).setValue("lalala");
        $(byText("Войти")).click();
        // кликну по изображению профиля
        $(byCssSelector(".profile__image")).click();
        // в поле ссылки на изображение введу ссылку
        $(byId("owner-avatar")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png");
        // сохраню новое изображение
        $(byXpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();

        // Следующий шаг теста
        // кликну по кнопке добавления нового контента

        $(byClassName("profile__add-button")).click();
        // в поле названия введу «Москва»
        $(byName("name")).setValue("Москва");
        // в поле ссылки на изображение введу ссылку
        $(byName("link")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg");
        // сохраню контент
        $(byXpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();
        // удалю добавленную карточку, кликнув по кнопке удаления
        $(byXpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();

        //Следующий шаг теста, тк пишу портянку без page object
        // кликну по кнопке редактирования профиля
        $(byClassName("profile__edit-button")).click();
        // введу «Аристарх Сократович» в поле «Имя»
        $(byId("owner-name")).setValue("Аристарх Сократович");
        // введу «Автор автотестов» в поле «Занятие»
        $(byId("owner-description")).setValue("Автор автотестов");
        // сохраню изменения
        $(byXpath(".//form[@name='edit']/button[text()='Сохранить']")).click();

        // Еще один шаг
        // Выберу все карточки и название второй из них помещу в переменную cardText
        String cardText = $$(byClassName("card__image")).get(1).find(byClassName("card__title")).getText();
    }
    // Автоматически закроется браузер тк Селенид
}