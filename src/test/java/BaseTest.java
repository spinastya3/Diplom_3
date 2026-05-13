import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.pageobjects.BurgerMainPage;
import service.UserClient;

public class BaseTest {

    protected WebDriver driver;
    protected BurgerMainPage burgerMainPage;
    protected String accessToken;
    protected UserClient userClient = new UserClient();

    private static final String BASE_URL= "https://stellarburgers.education-services.ru";

    @Rule
    public FactoryDriver factoryDriver = new FactoryDriver();

    @Before
    public void globalSetUp() {

        driver = factoryDriver.getDriver();
        burgerMainPage = new BurgerMainPage(driver);
        RestAssured.baseURI = BASE_URL;
    }

    @After
    public void tearDown() {

            if (accessToken != null) {
                userClient.delete(accessToken);
            }
        }
}