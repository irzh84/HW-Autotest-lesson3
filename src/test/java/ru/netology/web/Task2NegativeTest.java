package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2NegativeTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupAll() {
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
    void shouldTestEmptyName() {
        driver.get("http://localhost:9999");
        // driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Ольга");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79190006070");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.cssSelector(".button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=name].input_invalid .input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", text.trim());
    }

    @Test
    void shouldTestEmptyPhone() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Ольга");
        // driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79190006070");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.cssSelector(".button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=phone].input_invalid .input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", text.trim());
    }

    @Test
    void shouldTestEmptyAgreement() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Ольга");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79190006070");
        // driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.cssSelector(".button")).click();
        assertTrue(driver.findElement(By.cssSelector("[data-test-id=agreement].input_invalid")).isDisplayed());
    }

    @Test
    void shouldTestIncorrectNameEnglishLetters() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Olga");
        driver.findElement(By.cssSelector(".button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=name].input_invalid .input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }

    @Test
    void shouldTestIncorrectPhoneLetters() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Ольга");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("привет");
        driver.findElement(By.cssSelector(".button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=phone].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }

    @Test
    void shouldTestIncorrectPhone12Numbers() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванова Ольга");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+790022034340");
        driver.findElement(By.cssSelector(".button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=phone].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }
}

