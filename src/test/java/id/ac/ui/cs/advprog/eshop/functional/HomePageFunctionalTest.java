package id.ac.ui.cs.advprog.eshop.functional;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageFunctionalTest extends BaseFunctionalTest {
    @Test
    void pageTitle_isCorrect(ChromeDriver driver) {
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();

        assertEquals("ADV Shop", pageTitle);
    }

    @Test
    void welcomeMessage_homepage_isCorrect(ChromeDriver driver) {
        driver.get(baseUrl);
        String welcomeMessage = driver.findElement(By.tagName("h3")).getText();

        assertEquals("Welcome", welcomeMessage);
    }
}
