package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DebitCardFormTest {
    private WebDriver driver;

    @BeforeAll
    public static void setup() {
        // System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void BeforeEach() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }


    @Test
    void shouldTestPositiveValues() throws InterruptedException {
       // throw new UnsupportedOperationException();
        driver.get("http://localhost:9999");
        Thread.sleep(5000);


    }
//        open("http://localhost:9999");
//        $("[data-test-id=name] input").setValue("Ольга");
//        $("[data-test-id=phone] input").setValue("+79190006070");
//        $("[data-test-id=agreement]").click();
//        $("[data-test-id=submit]").click();
//        $(".button__content").click();
//        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
//        // button.button
//    }
}
