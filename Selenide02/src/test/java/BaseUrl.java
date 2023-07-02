    import static com.codeborne.selenide.Selenide.open;

    public class BaseUrl {

        private static final String FIRST_URL = "https://software.informer.com/";
        private static final String SECOND_URL = "https://macdownload.informer.com/";

        public void openFirstUrl() {
            open(FIRST_URL);
        }

        public void openSecondUrl() {
            open(SECOND_URL);
        }
    }
