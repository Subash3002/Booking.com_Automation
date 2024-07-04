package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HotelPage {
    public WebDriver driver;
    public HotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//button[@id='hp_book_now_button']")
    @CacheLookup
    WebElement reverseBtn;


    @FindBy(xpath = "//tr[1]//select[@class='hprt-nos-select js-hprt-nos-select']")
    @CacheLookup
    WebElement roomDropdown;

    @FindBy(xpath = "//div[@class='hprt-reservation-cta']/button")
    @CacheLookup
    WebElement reserveItBtn;

    public void clickReserve(){
        reverseBtn.click();
    }

    public void clickReserveIt() throws InterruptedException {
        reserveItBtn.click();
//        Thread.sleep(1000);
    }

    public void selectRooms(){
        Select dropdown = new Select(roomDropdown);
        dropdown.selectByIndex(1);
    }



}
