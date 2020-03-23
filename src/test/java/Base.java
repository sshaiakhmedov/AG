import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class Base {
        protected WebDriver driver;
        protected void clickElement(By locator)
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(locator))
                    .click();
        }
        protected void clickElementWithFluentWait(By locator)
        {
            WebElement element = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }
    }

