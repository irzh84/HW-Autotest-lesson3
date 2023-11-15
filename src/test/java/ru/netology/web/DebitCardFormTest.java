package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DebitCardFormTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
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
