import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import static org.junit.jupiter.api.Assertions.*;

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
       // driver.get(URL);
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public void submitLogin(String user, String pass){
        username.sendKeys(user);


    }


}
