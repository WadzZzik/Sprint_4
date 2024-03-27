package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.MainPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertTrue;


// Класс для проверки корреткности ссылок на основной странице

public class MainPageLinksTests {
    // Веб драйвер /
    private WebDriver webDriver;

    // URL основной страницы
    private final String mainPageUrl = "https://qa-scooter.praktikum-services.ru";

    // URL  логотипа "Яндекс"
    private final String yandexUrl = "//yandex.ru";

    // URL  логотипа "Самокат"
    private final String scooterUrl = "//qa-scooter.praktikum-services.ru";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
        this.webDriver.get(this.mainPageUrl);
    }

    @After
    public void tearDown() {
        this.webDriver.quit();
    }

    //Тест для проверки открытия корректной ссылки в логотипе "Яндекс" в новом окне

    @Test
    public void checkYandexLinkIsCorrect() {
        MainPage mainPage = new MainPage(this.webDriver);

        assertTrue(
                "URL Яндекса не открывается " + this.yandexUrl,
                mainPage.getYandexLogoLink().contains(this.yandexUrl)
        );

        assertTrue(
                "URL Яндекса не открывается",
                mainPage.isYandexLogoLinkOpenedInNewTab()
        );
    }

    //Тест для проверки открытия ссылки логотипа "Самокат"
    @Test
    public void checkScooterLinkIsCorrect() {
        MainPage mainPage = new MainPage(this.webDriver);

        assertTrue(
                "Ссылка лого самоката не переходит" + this.scooterUrl,
                mainPage.getScooterLogoLink().contains(this.scooterUrl)
        );
    }
}
