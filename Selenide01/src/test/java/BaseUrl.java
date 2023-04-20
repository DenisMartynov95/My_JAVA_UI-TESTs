import static com.codeborne.selenide.Selenide.open;

    public class BaseUrl {

        public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

        public void openPage() {
            open(BASE_URL);
        }
    }

