import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@Getter
public class FactoryDriver extends ExternalResource {

    private WebDriver driver;

    public void initDriver() {
        String browser = System.getProperty("browser", "chrome");
        if ("yandex".equals(browser)) {
            startYandex();
        } else {
            startChrome();
        }
        commonSetup();
    }

    private void commonSetup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void startYandex() {

        WebDriverManager.chromedriver().browserVersion("146").setup();
        ChromeOptions options = new ChromeOptions();
        String binaryPath = System.getProperty("yandex.binary", "C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.setBinary(binaryPath);
        driver = new ChromeDriver(options);
    }

    @Override
    protected void before() throws Throwable {
        initDriver();
        driver.get("https://stellarburgers.education-services.ru");
    }

    @Override
    protected void after() {
            driver.quit();
    }
}


