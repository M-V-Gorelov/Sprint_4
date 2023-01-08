package scooter;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.OrderPage;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class CheckOrderScenarioPositive {
    WebDriver driver;
    private final String userFirstName;
    private final String userLastName;
    private final String userAddress;
    private final String userPhoneNumber;
    private final String userComment;
    private final int daysBeforeDelivery;
    private final int stationNumber;



    public CheckOrderScenarioPositive(String userFirstName, String userLastName, String userAddress, String userPhoneNumber, String userComment, int daysBeforeDelivery, int stationNumber) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userComment = userComment;
        this.daysBeforeDelivery = daysBeforeDelivery;
        this.stationNumber = stationNumber;

    }
    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { "Михаил", "Горелов", "Крымская 17 кв. 65", "89034567889", "Можайск",2, 1},
                { "Иван", "Иванов", "Егорова 13 кв. 45", "89034511111", "Третий подъезд", 78, 4},
                { "Иван", "Иванов", "Егорова 13 кв. 45", "89034511111", "Третий подъезд", 3, 100},
                { "Иван", "Иванов", "Егорова 13 кв. 45", "89034511111", "Третий подъезд", 75, 99}
        };
    }

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickConfirmCookieButton();
    }

    @Test
    public void CheckOrderPositiveScenarioFromHeaderOrderButton(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickHeaderOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.sendDataInFirstScreenOrder(userFirstName, userLastName, userAddress, userPhoneNumber, stationNumber);
        orderPage.sendDataInSecondScreenOrder(userComment, daysBeforeDelivery);
        orderPage.checkOrderStatusBlock();
    }

    @Test
    public void CheckOrderPositiveScenarioFromThirdPartOrderButton(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickThirdPartOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.sendDataInFirstScreenOrder(userFirstName, userLastName, userAddress, userPhoneNumber, stationNumber);
        orderPage.sendDataInSecondScreenOrder(userComment, daysBeforeDelivery);
        orderPage.checkOrderStatusBlock();
    }

    @After
    public void close() {
        driver.quit();
    }
}
