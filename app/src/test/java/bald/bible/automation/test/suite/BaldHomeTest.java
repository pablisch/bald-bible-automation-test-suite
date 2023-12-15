package bald.bible.automation.test.suite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaldHomeTest {
    private static ChromeDriver driver;
    private static BaldHomePage page;

    @BeforeAll
    static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new BaldHomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @BeforeEach
    void loadBaldBibleHomePage() {
        page.navigate();
    }

    @DisplayName("Create new todo for plain text, single char, accented chars and emojis")
    @ParameterizedTest(name = "Creates new todo with text {0}")
    @CsvSource({
            "Make tests",
            "X",
            "Héłlö",
            "⭐"
    })
    void testNewTodos(String text) {
        // Arrange
        // Act
        // Assert
    }

    @AfterEach
    void clearStorage() {
        driver.navigate().refresh();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
