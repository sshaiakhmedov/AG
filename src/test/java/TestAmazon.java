import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;


class TestAmazon {
    WebDriver driver;

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
        JavascriptExecutor js=(JavascriptExecutor)driver;

        WebDriverWait wait= new WebDriverWait(driver,10);

        driver.navigate().to("https://www.amazon.com/");

        WebElement searchField = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        assertTrue(searchField.isDisplayed());


        searchField.sendKeys("iphone");
        searchField.submit();


        WebElement searchWord=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='twotabsearchtextbox' and @value='iphone']")));
        System.out.println("Search word: "+searchWord.getAttribute("value"));

        //Thread.sleep(2000);
        //String searchWord=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\" and @value='nutella']")).getAttribute("value");
        assertTrue(searchWord.getAttribute("value").contains("iphone"));
       List<WebElement> links= driver.findElements(By.tagName("a"));
       int linksCount=links.size();
        System.out.println("Number of links: "+ linksCount);




        //DropDownList, #1
        WebElement sortBydropDown=driver.findElement(By.xpath("//span[@id='a-autoid-0']//*[@role='button']"));
        sortBydropDown.click();
        //number of filter options
        List<WebElement> filterOptions=driver.findElements(By.xpath("//li/a[starts-with(@id,'s-result-sort-select_')]"));
        System.out.println("Filter options: "+filterOptions.size());


        for (WebElement filter:filterOptions){
            System.out.println(filter.getText());
        }

        WebElement pageResultTotalCount=driver.findElement(By.xpath("//ul[@class='a-pagination']//li[last()-1]"));
        System.out.println("Total pages: "+pageResultTotalCount.getText());

        //loop through all pages of searchResult

        List<WebElement> pagesLine=driver.findElements(By.xpath("//ul[@class='a-pagination']/li[@class]"));
        int i=1;
        for (WebElement page:pagesLine){
            pagesLine.get(i).click();
            pagesLine.get(i+1).click();
                    i++;
        }

//        int i=3;
//        while (i<=7){
//            pagesLine.get(i).click();
//            Thread.sleep(3000);
//            i++;
//        }

        //ul[@class='a-pagination']//li[2]"



        WebElement priceHightToLow=driver.findElement(By.xpath("//a[contains(text(),'Price: High to Low')]"));
        priceHightToLow.click();



        //dropDownList: array
//        WebElement filterList=driver.findElement(By.xpath("//ul[@role='listbox']"));
//        Select s=new Select(filterList);
//        System.out.println(s.getOptions());


        //DropDownList with Select class, #2
//        WebElement dropDownBox= driver.findElement(By.xpath("//ul[@role='listbox']"));
//        Select s=new Select(dropDownBox);
//        s.selectByVisibleText("Price: Low to High");

        //dropDownBox.selectByVisibleText("Price: Low to High");
        WebElement paginationSection=driver.findElement(By.className("a-pagination"));
        js.executeScript("arguments[0].scrollIntoView();", paginationSection);
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        WebElement firstItem=driver.findElement(By.xpath("//div[contains(@class,'result-list')]//div[@data-index='0']//img"));
        firstItem.click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        //WebElement sideSheet=driver.findElement(By.id("attach-desktop-sideSheet"));
        //if (sideSheet.isDisplayed()==true){
           //driver.findElement(By.id("id=\"attachSiNoCoverage-announce\"")).click();


        WebElement addedToCart=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        String addedToCartText=driver.findElement(By.xpath("//h1")).getText();
        assertTrue(addedToCartText.contains("Added"));
        driver.quit();
        driver.close();
    }



}
