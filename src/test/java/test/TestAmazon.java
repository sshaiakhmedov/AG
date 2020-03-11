package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;


class TestAmazon {
    private WebDriver driver;

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

        //https://www.guru99.com/implicit-explicit-waits-selenium.html
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    void searchField() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,10);

        driver.navigate().to("https://www.amazon.com/");

        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        assertTrue(searchField.isDisplayed());


        searchField.sendKeys("nutella");
        searchField.submit();

        WebElement searchWord=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='twotabsearchtextbox' and @value='nutella']")));

        //Thread.sleep(2000);
        //String searchWord=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\" and @value='nutella']")).getAttribute("value");
        assertTrue(searchWord.getAttribute("value").contains("nutella"));

        //DropDownList, #1
        WebElement sortBydropDown=driver.findElement(By.xpath("//span[@id='a-autoid-0']//*[@role='button']"));
       sortBydropDown.click();
       WebElement priceHightToLow=driver.findElement(By.xpath("//a[contains(text(),'Price: High to Low')]"));
       priceHightToLow.click();

        List<WebElement> s=driver.findElements(By.xpath("//ul[@class='a-pagination']//*//a"));
        int pagesTotal=s.size();
        System.out.println("Total Result Pages: "+pagesTotal);
        //DropDownList with Select class, #2
        //Select dropDownBox= new Select(driver.findElement(By.xpath("//i[@class='a-icon a-icon-dropdown']")));

        //dropDownBox.selectByVisibleText("Price: Low to High");




        //driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
        //driver.manage().wait();

        WebElement firstItem=driver.findElement(By.xpath("//div[contains(@class,'result-list')]//div[@data-index='0']"));
        firstItem.click();
        driver.findElement(By.xpath("//*[@title='Add to Shopping Cart']")).click();
        String addedToCartText=driver.findElement(By.xpath("//h1")).getText();
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        assertTrue(addedToCartText.contains("Added"));
        driver.close();
    }



}
