import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;


class appleSiri {
    private WebDriver driver;
    public Actions builder;


    @BeforeAll
    static void setupBeforeClass() throws Exception{
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "c:/drivers/chromedriver.exe");
    }

    @BeforeEach
    void setup(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);


        driver = new ChromeDriver(options);
        builder=new Actions(driver);
        Thread.sleep(2000);


        //https://www.guru99.com/implicit-explicit-waits-selenium.html
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    void searchField() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;

        WebDriverWait wait= new WebDriverWait(driver,10);

        driver.navigate().to("https://www.amazon.com/");



        WebElement addedToCart=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        String addedToCartText=driver.findElement(By.xpath("//h1")).getText();
        assertTrue(addedToCartText.contains("Added"));
        driver.quit();
        driver.close();
    }



}
