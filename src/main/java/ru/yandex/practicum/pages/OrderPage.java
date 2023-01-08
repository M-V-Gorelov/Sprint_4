package ru.yandex.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderPage {

    private final WebDriver driver;
// Локаторы первого экрана заказа.
    private final By FIRST_NAME_INPUT_FIELD =  By.xpath(".//input[@placeholder='* Имя']"); // Поле ввода "Имя".
    private final By LAST_NAME_INPUT_FIELD = By.xpath(".//input[@placeholder='* Фамилия']"); // Поле ввода "Фамилия".
    private final By ADDRESS_INPUT_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); // Поле ввода "Адрес".
    private final By METRO_STATION_INPUT_FIELD = By.xpath(".//input[@placeholder='* Станция метро']"); // Поле ввода "Станция метро".
    private final By PHONE_NUMBER_INPUT_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); // Поле ввода "Номер телефона".
    private final By NEXT_STEP_BUTTON = By.className("Button_Middle__1CSJM"); // Кнопка "Далее" на первом экране заказа.

// Локаторы второго экрана заказа.
    private final By DELIVERY_DATE_INPUT_FIELD =  By.xpath(".//input[@placeholder='* Когда привезти самокат']"); // Поле ввода "Когда привезти самокат".
    private final By RENTAL_PERIOD_INPUT_FIELD =  By.xpath(".//div[@class='Dropdown-placeholder']"); // Поле ввода "Срок аренды".
    private final By RENTAL_PERIOD_SELECTION =  By.xpath(".//div[@class='Dropdown-menu']/div[1]"); // Выпадающий список с выбором срока аренды.
    private final By SCOOTER_COLOUR_SELECTOR_BLACK = By.id("black"); // Чек-бокс цвета самоката "Черный Жемчуг".
    private final By COMMENT_INPUT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']"); // Поле ввода "Комментарий для курьера".
    private final By FINISH_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка "Заказать" на втором экране заказа.

// Локаторы всплывающего окна "Хотите оформить заказ?".
    private final By COMMIT_ORDER_BUTTON = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка "Да".

// Локаторы всплывающего окна "Заказ оформлен".
    private final By SHOW_ORDER_STATUS_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка "Посмотреть статус".


//    Заготовка. Тесты Уже работают, но мне бы хотелось вынести выбор цвета и срока аренды в параметризацию;
//    private final By RENTAL_PERIOD_DAYS_1 = By.xpath(".//div[@class='Dropdown-menu']/div[1]");
//    private final By RENTAL_PERIOD_DAYS_2 = By.xpath(".//div[@class='Dropdown-menu']/div[2]");
//    private final By RENTAL_PERIOD_DAYS_3 = By.xpath(".//div[@class='Dropdown-menu']/div[3]");
//    private final By RENTAL_PERIOD_DAYS_4 = By.xpath(".//div[@class='Dropdown-menu']/div[4]");
//    private final By RENTAL_PERIOD_DAYS_5 = By.xpath(".//div[@class='Dropdown-menu']/div[5]");
//    private final By RENTAL_PERIOD_DAYS_6 = By.xpath(".//div[@class='Dropdown-menu']/div[6]");
//    private final By RENTAL_PERIOD_DAYS_7 = By.xpath(".//div[@class='Dropdown-menu']/div[7]");
//
//    public void selectRentalPeriod(By rentalPeriodDays) {
//        driver.findElement(RENTAL_PERIOD_INPUT_FIELD).click();
//        driver.findElement(rentalPeriodDays).click();
//    }
//
//    private final By SCOOTER_COLOUR_SELECTOR_GREY = By.id("grey");
//    private final By SCOOTER_COLOUR_SELECTOR_BLACK = By.id("black");
//
//    public void selectScooterColour(By scooterColour){
//        driver.findElement(scooterColour).click();
//    }

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputUserFirstName(String userFirstName){
        driver.findElement(FIRST_NAME_INPUT_FIELD).sendKeys(userFirstName);
    }
    public void inputUserLastName(String userLastName){
        driver.findElement(LAST_NAME_INPUT_FIELD).sendKeys(userLastName);
    }
    public void inputUserAddress(String userAddress){
        driver.findElement(ADDRESS_INPUT_FIELD).sendKeys(userAddress);
    }

// Станция выбирается нажатием вниз * stationNumber + ENTER на клавиатуре.
    public void selectMetroStation(int stationNumber) {
        driver.findElement(METRO_STATION_INPUT_FIELD).click();
        for (int i = 0; i < stationNumber; i++) {
            driver.findElement(METRO_STATION_INPUT_FIELD).sendKeys(Keys.DOWN);
        }
        driver.findElement(METRO_STATION_INPUT_FIELD).sendKeys(Keys.ENTER);
    }
    public void inputUserPhoneNumber(String userPhoneNumber){
        driver.findElement(PHONE_NUMBER_INPUT_FIELD).sendKeys(userPhoneNumber);
    }
    public void clickNextStepButton(){
        driver.findElement(NEXT_STEP_BUTTON).click();
    }

    public void sendDataInFirstScreenOrder(String userFirstName, String userLastName, String userAddress, String userPhoneNumber, int stationNumber){
        inputUserFirstName(userFirstName);
        inputUserLastName(userLastName);
        inputUserAddress(userAddress);
        selectMetroStation(stationNumber);
        inputUserPhoneNumber(userPhoneNumber);
        clickNextStepButton();
    }
// Сегодняшний день + daysBeforeDelivery. Выбираем срок доставки самоката.
    public void inputDeliveryDate(int daysBeforeDelivery){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(daysBeforeDelivery).format(formatter);
        driver.findElement(DELIVERY_DATE_INPUT_FIELD).sendKeys(date);
        driver.findElement(DELIVERY_DATE_INPUT_FIELD).sendKeys(Keys.ENTER);
    }
    public void inputRentalPeriod(){
        driver.findElement(RENTAL_PERIOD_INPUT_FIELD).click();
        driver.findElement(RENTAL_PERIOD_SELECTION).click();
    }
    public void selectBlackScooterColour(){
        driver.findElement(SCOOTER_COLOUR_SELECTOR_BLACK).click();
    }


    public void inputUserComment(String userComment){
        driver.findElement(COMMENT_INPUT_FIELD).sendKeys(userComment);
    }
    public void clickFinishOrderButton(){
        driver.findElement(FINISH_ORDER_BUTTON).click();
    }
    public void clickCommitOrderButton(){
        driver.findElement(COMMIT_ORDER_BUTTON).click();
    }
    public void sendDataInSecondScreenOrder(String userComment, int daysBeforeDelivery){
        inputDeliveryDate(daysBeforeDelivery);
        inputRentalPeriod();
        selectBlackScooterColour();
        inputUserComment(userComment);
        clickFinishOrderButton();
        clickCommitOrderButton();
    }
    public void checkOrderStatusBlock(){
       driver.findElement(SHOW_ORDER_STATUS_BUTTON).click();
    }

}
