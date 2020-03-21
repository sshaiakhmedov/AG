import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.net.*;
import java.util.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

class LoginPage extends Base{
    private String URL = "http://the-internet.herokuapp.com/login";
    private String title="The Internet";

    //Class with elements (Mapping)

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "radius")
    private WebElement buttonLogin;

    @FindBy(id = "flash")
    private WebElement confirmLogout;


    //constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
        assertEquals(title, driver.getTitle(), "This is not the LoginPage");
    }

    //services
    public static LoginPage open(WebDriver driver){
        driver.get(URL);
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public void submitLogin(String user, String pass){
        username.sendKeys(user);


    }


}
