package test;

import io.github.bonigarcia.wdm.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class TestGoogle {
    private WebDriver driver;

    @BeforeAll
    static void setupBeforeClass() throws Exception{
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() throws Exception{
//        ChromeOptions options = new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.NONE);
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }


    @Test
    void menuBar() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:/drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://google.com");

        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='hptl']/a"));
        System.out.println("Number of Elements " + elements.size());

        WebElement imagesMenu = driver.findElement(By.xpath("//a[text()='Images']"));
        assertEquals(imagesMenu.getText(), "Images");
        assertTrue(imagesMenu.isEnabled());
    }

    @Test
    void textLinkNews() throws InterruptedException {
        WebElement linkText = driver.findElement(By.id("prm"));
        assertTrue(linkText.isDisplayed());
        Thread.sleep(1000);
    }

    @Test
    void searchField() throws InterruptedException {
        WebElement searchField = driver.findElement(By.xpath("//*[@title='Search']"));
        assertTrue(searchField.isDisplayed());


        searchField.sendKeys("google");
        searchField.submit();
        Thread.sleep(2000);

        WebElement h3Title = driver.findElement(By.tagName("h3"));
        assertEquals(h3Title.getText(), "Google");
        driver.close();
    }

    @AfterEach
    void tearDown() throws Exception{
        driver.quit();
    }


}
