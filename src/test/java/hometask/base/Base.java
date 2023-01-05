package hometask.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.*;

abstract public class Base {

    private void setUp() {
        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
        Configuration.browserSize = "1366x768";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    public void init() {
        setUp();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
