package ru.yandex.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {



    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private final WebDriver webDriver;


    private final String URL = "https://qa-scooter.praktikum-services.ru/";

    private final By COOKIE_BUTTON = By.id("rcc-confirm-button");
    private static final By HEADER_ORDER_BUTTON = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private final By THIRD_PART_ORDER_BUTTON = By.xpath(".//div[@class='Home_ThirdPart__LSTEE']/div[@class='Home_RoadMap__2tal_']/div[@class='Home_FinishButton__1_cWm']/button");

    private final By QUESTION_1 = By.id("accordion__heading-0");
    private final By QUESTION_2 = By.id("accordion__heading-1");
    private final By QUESTION_3 = By.id("accordion__heading-2");
    private final By QUESTION_4 = By.id("accordion__heading-3");
    private final By QUESTION_5 = By.id("accordion__heading-4");
    private final By QUESTION_6 = By.id("accordion__heading-5");
    private final By QUESTION_7 = By.id("accordion__heading-6");
    private final By QUESTION_8 = By.id("accordion__heading-7");

    private final By ANSWER_1 = By.id("accordion__panel-0");
    private final By ANSWER_2 = By.id("accordion__panel-1");
    private final By ANSWER_3 = By.id("accordion__panel-2");
    private final By ANSWER_4 = By.id("accordion__panel-3");
    private final By ANSWER_5 = By.id("accordion__panel-4");
    private final By ANSWER_6 = By.id("accordion__panel-5");
    private final By ANSWER_7 = By.id("accordion__panel-6");
    private final By ANSWER_8 = By.id("accordion__panel-7");

    private final String EXPECTED_TEXT_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String EXPECTED_TEXT_2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String EXPECTED_TEXT_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String EXPECTED_TEXT_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final String EXPECTED_TEXT_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String EXPECTED_TEXT_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String EXPECTED_TEXT_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String EXPECTED_TEXT_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";




    public String getEXPECTED_TEXT_1() {
        return EXPECTED_TEXT_1;
    }
    public String getEXPECTED_TEXT_2() {
        return EXPECTED_TEXT_2;
    }
    public String getEXPECTED_TEXT_3() {
        return EXPECTED_TEXT_3;
    }
    public String getEXPECTED_TEXT_4() {
        return EXPECTED_TEXT_4;
    }
    public String getEXPECTED_TEXT_5() {
        return EXPECTED_TEXT_5;
    }
    public String getEXPECTED_TEXT_6() {
        return EXPECTED_TEXT_6;
    }
    public String getEXPECTED_TEXT_7() {
        return EXPECTED_TEXT_7;
    }
    public String getEXPECTED_TEXT_8() {
        return EXPECTED_TEXT_8;
    }
    public void openPage() {
        webDriver.get(URL);
    }
    public void clickHeaderOrderButton(){
        webDriver.findElement(HEADER_ORDER_BUTTON).click();
    }
    public void clickThirdPartOrderButton(){
        webDriver.findElement(THIRD_PART_ORDER_BUTTON).click();
    }
    public void clickConfirmCookieButton() {
        webDriver.findElement(COOKIE_BUTTON).click();
    }
    public void scrollDown(){
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(QUESTION_1));
    }
    public void clickOnQuestion_1() {
        webDriver.findElement(QUESTION_1).click();
    }
    public void clickOnQuestion_2() {
        webDriver.findElement(QUESTION_2).click();
    }
    public void clickOnQuestion_3() {
        webDriver.findElement(QUESTION_3).click();
    }
    public void clickOnQuestion_4() {
        webDriver.findElement(QUESTION_4).click();
    }
    public void clickOnQuestion_5() {
        webDriver.findElement(QUESTION_5).click();
    }
    public void clickOnQuestion_6() {
        webDriver.findElement(QUESTION_6).click();
    }
    public void clickOnQuestion_7() {
        webDriver.findElement(QUESTION_7).click();
    }
    public void clickOnQuestion_8() {
        webDriver.findElement(QUESTION_8).click();
    }

    public String getAnswerText_1() {
        return webDriver.findElement(ANSWER_1).getText();
    }
    public String getAnswerText_2() {
        return webDriver.findElement(ANSWER_2).getText();
    }
    public String getAnswerText_3() {
        return webDriver.findElement(ANSWER_3).getText();
    }
    public String getAnswerText_4() {
        return webDriver.findElement(ANSWER_4).getText();
    }
    public String getAnswerText_5() {
        return webDriver.findElement(ANSWER_5).getText();
    }
    public String getAnswerText_6() {
        return webDriver.findElement(ANSWER_6).getText();
    }
    public String getAnswerText_7() {
        return webDriver.findElement(ANSWER_7).getText();
    }
    public String getAnswerText_8() {
        return webDriver.findElement(ANSWER_8).getText();
    }



}
