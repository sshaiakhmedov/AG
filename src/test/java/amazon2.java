import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class amazon2 {
    public WebDriver driver;
    public Actions builder;


    @BeforeAll
    static void setupBeforeClass() throws Exception{
        //WebDriverManager.chromedriver().setup();
      // System.setProperty("webdriver.chrome.driver", "c:/drivers/chromedriver.exe");
    }

    @BeforeEach
    void setup(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        builder=new Actions(driver);

        //https://www.guru99.com/implicit-explicit-waits-selenium.html
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    void searchField() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebDriverWait wait= new WebDriverWait(driver,10);

        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);
        assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/");
            System.out.println("Web URL is: "+ driver.getCurrentUrl());
        WebElement menuLeftIcon=driver.findElement(By.id("nav-hamburger-menu"));
        menuLeftIcon.click();

        //select menu with Select class
        List<WebElement> menu=driver.findElements(By.xpath("//div//ul[@data-menu-id='1']//li//a"));
        for (WebElement element:menu){
            System.out.println("Menu link: "+ element.getText());
        }


       driver.quit();
        driver.close();
    }



}
