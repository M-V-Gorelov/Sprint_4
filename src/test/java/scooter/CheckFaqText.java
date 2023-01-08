package scooter;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.assertEquals;



public class CheckFaqText {

    WebDriver driver;
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
    public void checkAnswerText_1(){
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollDown();
        mainPage.clickOnQuestion_1();
        assertEquals("Строки отличаются", mainPage.getEXPECTED_TEXT_1(), mainPage.getAnswerText_1());
    }
    @Test
    public void checkAnswerText_2(){
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollDown();
        mainPage.clickOnQuestion_2();
        assertEquals("Строки отличаются", mainPage.getEXPECTED_TEXT_2(), mainPage.getAnswerText_2());
    }
    @Test
    public void checkAnswerText_3(){
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollDown();
        mainPage.clickOnQuestion_3();
        assertEquals("Строки отличаются", mainPage.getEXPECTED_TEXT_3(), mainPage.getAnswerText_3());
    }
    @Test
    public void checkAnswerText_4(){
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollDown();
        mainPage.clickOnQuestion_4();
        assertEquals("Строки отличаются", mainPage.getEXPECTED_TEXT_4(), mainPage.getAnswerText_4());
    }
    @Test
    public void checkAnswerText_5(){
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollDown();
        mainPage.clickOnQuestion_5();
        assertEquals("Строки отличаются", mainPage.getEXPECTED_TEXT_5(), mainPage.getAnswerText_5());
    }
    @Test
    public void checkAnswerText_6(){
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollDown();
        mainPage.clickOnQuestion_6();
        assertEquals("Строки отличаются", mainPage.getEXPECTED_TEXT_6(), mainPage.getAnswerText_6());
    }
    @Test
    public void checkAnswerText_7(){
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollDown();
        mainPage.clickOnQuestion_7();
        assertEquals("Строки отличаются", mainPage.getEXPECTED_TEXT_7(), mainPage.getAnswerText_7());
    }
    @Test
    public void checkAnswerText_8(){
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollDown();
        mainPage.clickOnQuestion_8();
        assertEquals("Строки отличаются", mainPage.getEXPECTED_TEXT_8(), mainPage.getAnswerText_8());
    }

    @After
    public void close() {
        driver.quit();
    }
}



